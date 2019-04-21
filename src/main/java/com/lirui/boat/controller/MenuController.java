package com.lirui.boat.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Menu;
import com.lirui.boat.entity.Menu;
import com.lirui.boat.entity.User;
import com.lirui.boat.entity.vo.MenuVO;
import com.lirui.boat.service.impl.MenuServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

/**
 * <p>
 * 菜单信息表 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
@Slf4j
@Controller
@RequestMapping("/menu")
public class MenuController {

  @Autowired
  private MenuServiceImpl menuService;

  /**
   * 跳转到栏目列表
   */
  @GetMapping("list")
  public String menuList() {
    return "/admin/menus/menu-list";
  }

  /**
   * 跳转到栏目预览页面
   */
  @GetMapping("preview")
  public String preView() {
    return "admin/menus/preview";
  }

  /**
   * 重定向到栏目下对应的文章列表页 从路径中获取栏目id，然后再把id放到请求路径中传递
   *
   * @param id 栏目id
   */
  @GetMapping("article/{menuId}")
  public String menuArticle(@PathVariable("menuId") String id) {
    return "redirect:/article/list/" + id;
  }





  /**
   * 跳转到表单页面，如果传入的对象不是null，获取对象的所有信息，反填到表单中
   *
   * @param menu 表单传入的Menu对象
   */
  @GetMapping({"form"})
  public String showForm(Menu menu, Model model) {
    Menu menu1 = new Menu();
    if (!StringUtils.isEmpty(menu.getId())) {
      menu1 = menuService.getById(menu.getId());
    }
    QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
    queryWrapper.select("id", "name");
    List<Menu> objects = menuService.list(queryWrapper);
    model.addAttribute("menu", menu1);
    model.addAttribute("menuList", objects);
    return "/admin/menus/form";
  }

  /**
   * 栏目新增/保存
   *
   * @param menu 表单传入的Menu对象
   */
  @PostMapping("save")
  @ResponseBody
  public ModelMap saveAdmin(Menu menu) {

    return savemenu(menu);
  }


  /**
   * 根据id删除栏目，同时删除该栏目下的子栏目
   */
  @GetMapping("del")
  @ResponseBody
  public ModelMap del(@RequestParam("id") String id) {

    boolean b = menuService.removeById(id);
    if (b) {
      return ReturnUtil.success("删除成功", null, null);
    }
    return ReturnUtil.error("删除失败", null, null);
  }

  /**
   * 具体的保存方法，根据id判断栏目是否存在，存在执行update，否则执行insert
   *
   * @param menu 表单传入的Menu对象
   */
  //TODO:经常使用，后期改成泛型的，用反射改造
  public ModelMap savemenu(Menu menu) {
    if (!StringUtils.isEmpty(menu.getId())) {
      log.info("此栏目存在，本次操作为：更新栏目");
      //设置最后更新时间
      menu.setLastEditTime(LocalDateTime.now());
      boolean save = menuService.updateById(menu);
      if (save) {
        return ReturnUtil.success("更新成功", null, null);
      } else {
        return ReturnUtil.error("更新失败", null, null);
      }
    } else {
      log.info("栏目不存在，本次操作为：新增栏目");
      menu.setCreateTime(LocalDateTime.now());
      menu.setLastEditTime(LocalDateTime.now());
      boolean save = menuService.save(menu);
      if (save) {
        return ReturnUtil.success("保存成功", null, "menu-list");
      } else {
        return ReturnUtil.error("操作失败", null, null);
      }
    }
  }
}
