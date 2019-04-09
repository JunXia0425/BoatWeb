package com.lirui.boat.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.User;
import com.lirui.boat.enums.Role;
import com.lirui.boat.service.UserService;
import com.lirui.boat.service.impl.UserServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
@Slf4j
@Controller
public class UserController {

  @Autowired
  private UserServiceImpl userService;

  /**
   * 跳转到管理员列表
   */
  @GetMapping("admin/list")
  public String adminList() {
    log.info("当前用户信息{}",SecurityUtils.getSubject().getPrincipal().toString());
    return "/admin/user/admin-list";
  }

  /**
   * 跳转到用户列表
   */
  @GetMapping("user/list")
  public String userList() {
    return "/admin/user/user-list";
  }


  /**
   * 分页条件查询符合条件的所有用户，JSON格式返回
   */
  @PostMapping("user/list")
  @ResponseBody
  public ModelMap list(@RequestBody Page<User> UserPage) {
    IPage<User> page = userService.page(UserPage);
    return ReturnUtil.success("ok", page, null);
  }


  /**
   * 跳转到表单页面，如果传入的对象不是null，获取对象的所有信息，反填到表单中
   *
   * @param User 表单传入的User对象
   */
  @GetMapping({"admin/form", "user/form"})
  public String showForm(User User, Model model) {
    User user = new User();
    if (!StringUtils.isEmpty(User.getId())) {
      user = userService.getById(User.getId());
    }
    model.addAttribute("user", user);
    return "/admin/user/form";
  }

  /**
   * 根据id删除用户
   */
  @GetMapping("user/del")
  @ResponseBody
  public ModelMap del(@RequestParam("id") String id) {
    boolean b = userService.removeById(id);
    if (b) {
      return ReturnUtil.success("删除成功", null, null);
    }
    return ReturnUtil.error("删除失败", null, null);
  }


}
