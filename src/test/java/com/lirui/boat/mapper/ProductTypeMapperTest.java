package com.lirui.boat.mapper;

import com.lirui.boat.entity.ProductType;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTypeMapperTest {
    @Autowired
    private ProductTypeMapper productMapper;
    @Test
    @Ignore
    public void initType() {
        String[] type = {"淡水净化器","潜水服","蓄电池","救生圈"};
        for (String s : type) {
            ProductType productType = new ProductType();
            productType.setType(s);
            productMapper.insert(productType);
        }
        Assert.assertEquals(type.length,productMapper.selectList(null).size());

    }

}