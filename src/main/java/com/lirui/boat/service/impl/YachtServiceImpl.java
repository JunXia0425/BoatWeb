package com.lirui.boat.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Yacht;
import com.lirui.boat.entity.vo.YachtVO;
import com.lirui.boat.mapper.YachtMapper;
import com.lirui.boat.service.YachtService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 游艇信息 服务实现类
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-27
 */
@Service
public class YachtServiceImpl extends ServiceImpl<YachtMapper, Yacht> implements YachtService {
    @Autowired
    private YachtMapper yachtMapper;
    @Override
    public Page<YachtVO> page(Page<YachtVO> page) {
        return page.setRecords(yachtMapper.getYachts(page));
    }
}
