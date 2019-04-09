package com.lirui.boat.mapper;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lirui.boat.entity.Product;
import com.lirui.boat.entity.User;
import java.util.HashMap;
import java.util.List;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductsMapperTest {
  @Autowired
  private ProductMapper productMapper;
  @Autowired
  private UserMapper userMapper;
  @Test
  @Ignore
  public void addUser(){
    User user = new User();
    user.setAccount("123");
    user.setNickname("zhangsan");
    user.setUserType(1);
    userMapper.insert(user);
    HashMap<String, Object> stringStringHashMap = new HashMap<>();
    stringStringHashMap.put("account","123");
    List<User> users = userMapper.selectByMap(stringStringHashMap);
    Assert.assertEquals("zhangsan",users.get(0).getNickname());
  }

  @Test
  @Ignore
  public void addProduct(){
    Product product = new Product();
    product.setDescription("描述");
    product.setEnableStatus(1);
    product.setProductName("shangping1");
    product.setType(1);
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("nickname","zhangsan");
    product.setOwnnerId(userMapper.selectOne(queryWrapper).getId());
    int insert = productMapper.insert(product);
    Assert.assertEquals(1,insert);
  }

  /**
   * 级联删除测试
   */
  @Test
  public void delUserCascade(){
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("account","123");
    userMapper.delete(queryWrapper);
    List<Product> products = productMapper.selectByMap(null);
    Assert.assertEquals(0,products.size());
  }
}