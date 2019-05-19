package com.lirui.boat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lirui.boat.entity.Yacht;
import com.lirui.boat.entity.dto.Query;
import com.lirui.boat.entity.vo.YachtVO;
import com.lirui.boat.mapper.YachtMapper;
import com.lirui.boat.service.YachtService;
import lombok.extern.slf4j.Slf4j;
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
        return page.setRecords(yachtMapper.getYachts(page));
    }

    @Override
    public Page<YachtVO> page(Page<YachtVO> page, Query query) {
        Query.Range length = query.getLength();
        Query.Range price = query.getPrice();
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
