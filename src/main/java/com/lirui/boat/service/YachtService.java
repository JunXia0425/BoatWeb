package com.lirui.boat.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lirui.boat.entity.Yacht;
import com.lirui.boat.entity.dto.Query;
import com.lirui.boat.entity.vo.YachtVO;

import java.util.List;

/**
 * <p>
 * 游艇信息 服务类
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-27
 */
public interface YachtService extends IService<Yacht> {
    /**
     * 分页查询商品信息（连表查询查出持有者昵称）
     * @param page 分页对象
     * @return
     */
    Page<YachtVO> page(Page<YachtVO> page);

    /**
     * 分页按筛选条件查询商品信息
     * @param page 分页对象
     * @param query 接收过滤条件
     * @return
     */
    Page<YachtVO> page(Page<YachtVO> page, Query query);

    /**
     * 查询表中现有游艇的产地
     * @return
     */
    List<Object> getRegions();
}
