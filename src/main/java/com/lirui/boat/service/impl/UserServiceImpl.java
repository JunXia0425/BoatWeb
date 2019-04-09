package com.lirui.boat.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lirui.boat.entity.User;
import com.lirui.boat.enums.EnableStatus;
import com.lirui.boat.enums.Role;
import com.lirui.boat.mapper.UserMapper;
import com.lirui.boat.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  public ModelMap regist(User user) {
    //获取user中的账号
    String account = user.getAccount();
    //用这个账号查询数据库
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("account", account);
    List<User> users = userMapper.selectList(queryWrapper);
    //如果查询出来的列表不为空，说明有同名用户，返回
    if (!users.isEmpty()) {
      return ReturnUtil.error("error", "用户已存在");
    }
    //如果要注册的用户是管理员，账户先设为不可用
    if (Role.ADMIN.getUserType().equals(user.getUserType())) {
      user.setEnableStatus(EnableStatus.DISABLE.getValue());
    }
    //将这个用户保存到数据库
    int insert = userMapper.insert(user);
    return insert == 1 ? ReturnUtil.success("ok", "注册成功") : ReturnUtil.error("error", "注册失败");
  }

  @Override
  public User getByAccount(String account) {
    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
    queryWrapper.eq("account", account);
    return userMapper.selectOne(queryWrapper);
  }

  @Override
  public IPage<User> page(IPage<User> page) {
    return userMapper.selectPage(page,null);
  }
}
