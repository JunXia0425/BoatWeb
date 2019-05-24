package com.lirui.boat.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.vo.ProductVO;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductMapperTest {
@Autowired
private ProductMapper productMapper;
  @Test
  @Ignore
  public void getProducts() {

    Page<ProductVO> voPage = new Page<>();
    voPage.setCurrent(2);
    voPage.setSize(3);
//    List<ProductVO> products = productMapper.getProducts(voPage);
//    Assert.assertEquals(2,products.size());
  }
}