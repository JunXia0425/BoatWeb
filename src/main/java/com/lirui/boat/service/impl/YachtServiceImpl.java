package com.lirui.boat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lirui.boat.entity.User;
import com.lirui.boat.entity.Yacht;
import com.lirui.boat.entity.dto.Query;
import com.lirui.boat.entity.dto.Range;
import com.lirui.boat.entity.vo.YachtVO;
import com.lirui.boat.enums.Role;
import com.lirui.boat.mapper.YachtMapper;
import com.lirui.boat.service.YachtService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 游艇信息 服务实现类
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-27
 */
@Service
@Slf4j
public class YachtServiceImpl extends ServiceImpl<YachtMapper, Yacht> implements YachtService {
    @Autowired
    private YachtMapper yachtMapper;

    @Override
    public Page<YachtVO> page(Page<YachtVO> page) {
        Subject subject = SecurityUtils.getSubject();
        User curUser = (User) subject.getPrincipal();
        if (curUser.getUserType().equals(Role.USER.getUserType())) {
            QueryWrapper<YachtVO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("owner_id",curUser.getId());
            return page.setRecords(yachtMapper.getYachts(page,queryWrapper));
        }
        return page.setRecords(yachtMapper.getYachtsByAdmin(page));
    }

    @Override
    public Page<YachtVO> page(Page<YachtVO> page, Query query) {
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
        return page.setRecords(yachtMapper.getYachtsOnCondition(page, queryWrapper));
    }

    @Override
    public YachtVO getById(Serializable id) {
        return yachtMapper.selectById(id);
    }

    @Override
    public List<Object> getRegions() {
        QueryWrapper<Yacht> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("region").groupBy("region");
        return yachtMapper.selectObjs(queryWrapper);
    }
}
