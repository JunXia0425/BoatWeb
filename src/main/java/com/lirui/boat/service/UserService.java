package com.lirui.boat.service;

import com.lirui.boat.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.ui.ModelMap;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
public interface UserService extends IService<User> {

  /**
   * 根据账号查询用户信息
   *
   * @param account 账号
   * @return User对象
   */
  User getByAccount(String account);

  /**
   * 根据User对象注册用户（存入数据库）
   *
   * @param user User对象
   */
  ModelMap regist(User user);
}
