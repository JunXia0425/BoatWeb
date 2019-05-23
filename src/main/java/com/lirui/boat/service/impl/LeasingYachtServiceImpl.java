package com.lirui.boat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lirui.boat.entity.LeasingYacht;
import com.lirui.boat.entity.Route;
import com.lirui.boat.entity.Stock;
import com.lirui.boat.entity.User;
import com.lirui.boat.entity.dto.LeasingYachtDTO;
import com.lirui.boat.entity.dto.Query;
import com.lirui.boat.entity.dto.Range;
import com.lirui.boat.entity.vo.LeasingYachtVO;
import com.lirui.boat.entity.vo.YachtVO;
import com.lirui.boat.enums.Role;
import com.lirui.boat.mapper.LeasingYachtMapper;
import com.lirui.boat.service.LeasingYachtService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 租赁游艇表 服务实现类
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@Service
@Slf4j
public class LeasingYachtServiceImpl extends ServiceImpl<LeasingYachtMapper, LeasingYacht> implements LeasingYachtService {
    @Autowired
    private StockServiceImpl stockService;
    @Autowired
    private RouteServiceImpl routeService;
    @Autowired
    private LeasingYachtMapper leasingYachtMapper;

    @Override
    public Page<LeasingYachtVO> page(Page<LeasingYachtVO> page, Query query) {
        Range length = query.getLength();
        Range price = query.getPrice();
        String classification = query.getClassification();
        String region = query.getRegion();
        QueryWrapper<YachtVO> queryWrapper = new QueryWrapper<>();
        if (region != null) {
            queryWrapper.eq("region", region);
        }
        if (classification != null) {
            queryWrapper.eq("classification_id", classification);
        }
        if (price != null && price.getMax() != null) {
            queryWrapper.lt("price", price.getMax());
        }
        if (price != null && price.getMin() != null) {
            queryWrapper.ge("price", price.getMin());
        }
        if (length != null && length.getMax() != null) {
            queryWrapper.lt("length", length.getMax());
        }
        if (length != null && length.getMin() != null) {
            queryWrapper.ge("length", length.getMin());
        }
        return page.setRecords(leasingYachtMapper.getYachtsOnCondition(page, queryWrapper));
    }

    @Autowired
    private YachtServiceImpl yachtService;
    @Autowired
    private UserServiceImpl userService;

    @Override
    public boolean save(LeasingYachtDTO dto) {
        List<Route> routes = dto.getRoutes();
        Stock stock = dto.getStock();
        LeasingYacht leasingYacht = dto.getLeasingYacht();
        //判断所属
        //1. 根据租赁游艇的id查找游艇元信息
        String yachtId = leasingYacht.getYachtId();
        YachtVO yacht = yachtService.getById(yachtId);
        //2. 根据游艇元信息中owner_id 查询用户信息
        User owner = userService.getById(yacht.getOwnerId());
        //3。 如果用户是普通用户-游艇所属为个人，否则为企业
        if (owner.getUserType().equals(Role.USER)) {
            leasingYacht.setBelonging(1);
        } else {
            leasingYacht.setBelonging(0);
        }
        leasingYacht.setBelonging(1);
        for (Route route : routes) {
            route.setYachtId(yachtId);
        }
        // 判断是否已经存在，如果存在则保存，将原route全部删除，加入新的

        boolean exist = this.exist(yachtId);
        if (exist) {
            log.info("租赁已存在，现在开始更新");
            QueryWrapper<Route> wrapper = new QueryWrapper<>();
            wrapper.eq("yacht_id", yachtId);
            //删除原来的
            log.info("删除原来存储的航线，条件为{}",yachtId);
            boolean remove = routeService.remove(wrapper);
            log.info("添加最新航线");
            boolean routesSave = routeService.saveBatch(routes);
            //更新库存
            log.info("更新库存");
            boolean updateStock = stockService.updateById(stock);
            //更新出租游艇
            log.info("更新游艇");
            boolean updateLeasingYacht = this.saveOrUpdate(leasingYacht);
            return remove && updateLeasingYacht && updateStock;
        } else {
            boolean save = this.save(leasingYacht);
            boolean stockSave = stockService.save(stock);
            boolean routesSave = routeService.saveBatch(routes);
            return save && stockSave && routesSave;
        }

    }

    @Override
    public Page<LeasingYachtVO> page(Page<LeasingYachtVO> page) {
        Subject subject = SecurityUtils.getSubject();

        List<LeasingYachtVO> leasingYachtVOS;
        //获取当前用户
        User curUser = (User) subject.getPrincipal();
        //如果是普通用户，只查询自己的
        if (curUser.getUserType().equals(Role.USER.getUserType())) {
            QueryWrapper<LeasingYachtVO> wrapper = new QueryWrapper<>();
            wrapper.eq("owner_id", curUser.getId());
            leasingYachtVOS = leasingYachtMapper.getYachts(page, wrapper);
        } else {
            leasingYachtVOS = leasingYachtMapper.getYachtsByAdmin(page);
        }
        for (LeasingYachtVO leasingYachtVO : leasingYachtVOS) {
            QueryWrapper<Route> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("yacht_id", leasingYachtVO.getYachtId());
            leasingYachtVO.setRoutes(routeService.list(queryWrapper));
        }
        return page.setRecords(leasingYachtVOS);
    }


    @Override
    public boolean exist(String id) {
        LeasingYacht leasingYacht = leasingYachtMapper.selectById(id);
        return leasingYacht == null ? false : true;
    }

    @Override
    public LeasingYacht getById(Serializable id) {
        LeasingYachtVO leasingYachtVO = leasingYachtMapper.selectById(id);
        if (leasingYachtVO != null) {
            QueryWrapper<Route> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("yacht_id", leasingYachtVO.getYachtId());
            leasingYachtVO.setRoutes(routeService.list(queryWrapper));
        }
        return leasingYachtVO;
    }
}
