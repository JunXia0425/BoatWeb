package com.lirui.boat.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Product;
import com.lirui.boat.entity.vo.ProductVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 商品信息表 Mapper 接口
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-22
 */
public interface ProductMapper extends BaseMapper<Product> {
    /**
     * 连表查询商品表和用户信息表中的用户昵称
     * @param page 分页
     * @return
     */
    List<ProductVO> getProductsByAdmin(Page<ProductVO> page);

    List<ProductVO> getProducts(Page<ProductVO> page, @Param("ew") QueryWrapper queryWrapper);

    List<ProductVO> getProductsOnCondition(Page<ProductVO> page, @Param("ew") QueryWrapper query);

}
