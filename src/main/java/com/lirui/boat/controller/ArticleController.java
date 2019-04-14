package com.lirui.boat.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Article;
import com.lirui.boat.entity.Menu;
import com.lirui.boat.entity.User;
import com.lirui.boat.entity.vo.ArticleVO;
import com.lirui.boat.service.impl.ArticleServiceImpl;
import com.lirui.boat.service.impl.MenuServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 文章信息表 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
@Slf4j
@Controller
@RequestMapping("/article")
public class ArticleController {

  @Autowired
  private ArticleServiceImpl articleService;
  @Autowired
  private MenuServiceImpl menuService;

  /**
   * 跳转到文章列表
   */
  @GetMapping("list/{menuId}")
  public String articleList(@PathVariable("menuId") String id, Model model) {
    Menu menu = menuService.getById(id);
    model.addAttribute("menu", menu);
    //TODO:这里需要让列表页查出来的数据与menuid相符
    return "/admin/articles/article-list";
  }

  /**
   * 跳转到menu-tree（菜单树）
   */
  @GetMapping("menu-tree")
  public String menuTree() {
    return "/admin/articles/menu-tree";
  }

  /**
   * 分页条件查询符合条件的所有文章，JSON格式返回
   */
  @PostMapping("list/{menuId}")
  @ResponseBody
  public ModelMap list(@RequestBody Page<ArticleVO> articlePage,@PathVariable("menuId")String id) {
    IPage<ArticleVO> page = articleService.page(articlePage,id);
    return ReturnUtil.success("ok", page, null);
  }


  /**
   * 跳转到表单页面，如果传入的对象不是null，获取对象的所有信息，反填到表单中
   * 这里要提取路径中的menuid，然后数据库查询菜单信息，传给下一个页面，用于保存文章所属栏目
   * @param article 表单传入的User对象
   */
  @GetMapping({"edit/{menuId}"})
  public String showForm(Article article,@PathVariable("menuId") String id, Model model) {
    Article article1 = new Article();
    if (!StringUtils.isEmpty(article.getId())) {
      article1 = articleService.getById(article.getId());
    }
    //获取当前用户
    User user = (User) SecurityUtils.getSubject().getPrincipal();
    model.addAttribute("article", article1);
    //编辑者是当前用户（新文章）
    model.addAttribute("editorId", user.getId());
    Menu menu = menuService.getById(id);
    model.addAttribute("menu",menu);
    return "/admin/articles/edit";
  }

  /**
   * 文章新增/保存
   *
   * @param article 表单传入的User对象
   */
  @PostMapping("save")
  @ResponseBody
  public ModelMap saveAdmin(Article article) {

    return savearticle(article);
  }


  /**
   * 根据id删除文章
   */
  @GetMapping("del")
  @ResponseBody
  public ModelMap del(@RequestParam("id") String id) {
    boolean b = articleService.removeById(id);
    if (b) {
      return ReturnUtil.success("删除成功", null, null);
    }
    return ReturnUtil.error("删除失败", null, null);
  }

  /**
   * 具体的保存方法，根据id判断文章是否存在，存在执行update，否则执行insert
   *
   * @param article 表单传入的News对象
   */
  //TODO:经常使用，后期改成泛型的，用反射改造
  public ModelMap savearticle(Article article) {
    if (!StringUtils.isEmpty(article.getId())) {
      log.info("此文章存在，本次操作为：更新文章");
      //设置最后更新时间
      article.setLastEditTime(LocalDateTime.now());
      boolean save = articleService.updateById(article);
      if (save) {
        return ReturnUtil.success("更新成功", null, null);
      } else {
        return ReturnUtil.error("更新失败", null, null);
      }
    } else {
      log.info("文章不存在，本次操作为：新增文章");
      article.setCreateTime(LocalDateTime.now());
      article.setLastEditTime(LocalDateTime.now());
      boolean save = articleService.save(article);
      if (save) {
        return ReturnUtil.success("保存成功", null, "article-list");
      } else {
        return ReturnUtil.error("操作失败", null, null);
      }
    }
  }
}
