package com.lirui.boat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lirui.boat.entity.Product;
import com.lirui.boat.entity.User;
import com.lirui.boat.entity.dto.Query;
import com.lirui.boat.entity.vo.ProductVO;
import com.lirui.boat.enums.Role;
import com.lirui.boat.mapper.ProductMapper;
import com.lirui.boat.service.ProductService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品信息表 服务实现类
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-22
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Page<ProductVO> page(Page<ProductVO> page) {
        Subject subject = SecurityUtils.getSubject();
        User curUser = (User) subject.getPrincipal();
        if (curUser.getUserType().equals(Role.USER.getUserType())) {
            QueryWrapper<ProductVO> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("owner_id", curUser.getId());
            return page.setRecords(productMapper.getProducts(page, queryWrapper));
        }
        return page.setRecords(productMapper.getProductsByAdmin(page));
    }

    @Override
    public Page<ProductVO> page(Page<ProductVO> page, Query query) {
        Query.Range price = query.getPrice();
        String region = query.getRegion();
        QueryWrapper<ProductVO> queryWrapper = new QueryWrapper<>();
        if (region != null) {
            queryWrapper.eq("region", region);
        }
        if (price != null && price.getMax() != null) {
            queryWrapper.lt("price", price.getMax());
        }
        if (price != null && price.getMin() != null) {
            queryWrapper.ge("price", price.getMin());
        }
        return page.setRecords(productMapper.getProductsOnCondition(page, queryWrapper));
    }


    @Override
    public List<Object> getRegions() {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("region").groupBy("region");
        return productMapper.selectObjs(queryWrapper);
    }
}
