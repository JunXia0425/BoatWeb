package com.lirui.boat.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lirui.boat.entity.LeasingYacht;
import com.lirui.boat.entity.dto.LeasingYachtDTO;
import com.lirui.boat.entity.dto.Query;
import com.lirui.boat.entity.vo.LeasingYachtVO;

/**
 * <p>
 * 租赁游艇表 服务类
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
public interface LeasingYachtService extends IService<LeasingYacht> {

    /**
     * 保存表单数据到数据库
     * @param dto
     * @return
     */
    boolean save(LeasingYachtDTO dto);

    /**
     * 分页查询商品信息（连表查询查出持有者昵称）
     * @param page 分页对象
     * @return
     */
    Page<LeasingYachtVO> page(Page<LeasingYachtVO> page);

    /**
     * 分页按筛选条件查询商品信息
     * @param page 分页对象
     * @param query 接收过滤条件
     * @return
     */
    Page<LeasingYachtVO> page(Page<LeasingYachtVO> page, Query query);

    /**
     * 判断该id是否被出租
     * @param id 传入id
     * @return
     */
    public boolean exist(String id);
}
