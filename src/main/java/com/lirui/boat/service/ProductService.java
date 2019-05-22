package com.lirui.boat.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lirui.boat.entity.dto.Query;
import com.lirui.boat.entity.vo.ProductVO;

import java.util.List;

/**
 * <p>
 * 商品信息表 服务类
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-22
 */
public interface ProductService extends IService<Product> {
    /**
     * 分页查询商品信息（连表查询查出持有者昵称）
     *
     * @param page 分页对象
     * @return
     */
    Page<ProductVO> page(Page<ProductVO> page);

    /**
     * 分页按筛选条件查询商品信息
     *
     * @param page  分页对象
     * @param query 接收过滤条件
     * @return
     */
    Page<ProductVO> page(Page<ProductVO> page, Query query);

    /**
     * 查询表中现有商品的产地
     *
     * @return
     */
    List<Object> getRegions();
}
