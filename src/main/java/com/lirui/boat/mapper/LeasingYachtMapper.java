package com.lirui.boat.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lirui.boat.entity.LeasingYacht;
import com.lirui.boat.entity.vo.LeasingYachtVO;

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


    List<LeasingYachtVO> selectList();


    LeasingYachtVO selectById(Serializable id);
}
