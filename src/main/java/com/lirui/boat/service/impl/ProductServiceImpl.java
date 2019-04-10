package com.lirui.boat.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Product;
import com.lirui.boat.entity.vo.ProductVO;
import com.lirui.boat.mapper.ProductMapper;
import com.lirui.boat.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品信息表 服务实现类
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements
    ProductService {

  @Autowired
  private ProductMapper productMapper;

  @Override
  public Page<ProductVO> page(Page<ProductVO> page) {
    return page.setRecords(productMapper.getProducts(page));
  }
}
