package com.lirui.boat.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.LeasingYacht;
import com.lirui.boat.entity.vo.LeasingYachtVO;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 租赁游艇表 Mapper 接口
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
public interface LeasingYachtMapper extends BaseMapper<LeasingYacht> {


    /**
     * 连表查询游艇表和用户信息表中的用户昵称
     * @param page 分页
     * @return
     */
    List<LeasingYachtVO> getYachtsByAdmin(Page<LeasingYachtVO> page);

    List<LeasingYachtVO> getYachts(Page<LeasingYachtVO> page, @Param("ew") QueryWrapper queryWrapper);

    List<LeasingYachtVO> getYachtsOnCondition(Page<LeasingYachtVO> page, @Param("ew") QueryWrapper query);

    LeasingYachtVO selectById(Serializable id);
}
