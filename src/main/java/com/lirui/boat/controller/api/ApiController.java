package com.lirui.boat.controller.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Article;
import com.lirui.boat.entity.Menu;
import com.lirui.boat.entity.Yacht;
import com.lirui.boat.entity.vo.ArticleVO;
import com.lirui.boat.entity.vo.MenuVO;
import com.lirui.boat.entity.vo.ProductVO;
import com.lirui.boat.entity.vo.YachtVO;
import com.lirui.boat.service.impl.ArticleServiceImpl;
import com.lirui.boat.service.impl.MenuServiceImpl;
import com.lirui.boat.service.impl.ProductServiceImpl;
import com.lirui.boat.service.impl.YachtServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * ApiController
 * </p>
 *
 * @author Li Rui
 * @since 2019/4/22
 */
@Controller
@RequestMapping("api")
public class ApiController {

    private MenuServiceImpl menuService;
    private ArticleServiceImpl articleService;
    private ProductServiceImpl productService;
    private YachtServiceImpl yachtService;

    @Autowired
    public ApiController(MenuServiceImpl menuService,
                         ArticleServiceImpl articleService,
                         ProductServiceImpl productService,
                         YachtServiceImpl yachtService) {
        this.menuService = menuService;
        this.articleService = articleService;
        this.productService = productService;
        this.yachtService = yachtService;
    }

    /**
     * 分页条件查询符合条件的所有栏目，JSON格式返回
     */
    @PostMapping("/menu/list")
    @ResponseBody
    public ModelMap listMenu(@RequestBody Page<MenuVO> menuPage) {
        menuPage.setAsc("num");
        IPage<MenuVO> page = menuService.page(menuPage);
        return ReturnUtil.success("ok", page, null);
    }

    /**
     * 查询所有启用目录(仅查询id，栏目名称，父级栏目id,url)，用于展示树形图
     */
    @PostMapping("/menu/all")
    @ResponseBody
    public ModelMap allMenu() {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "pid", "url", "name").eq("enable_status", 1).orderByAsc("num");
        List<Map<String, Object>> maps = menuService.listMaps(queryWrapper);
        return ReturnUtil.success("ok", maps, null);
    }

    /**
     * 分页条件查询符合条件的所有文章，JSON格式返回
     */
    @PostMapping("/article/list/{menuId}")
    @ResponseBody
    public ModelMap listArticle(@RequestBody Page<ArticleVO> articlePage,
                                @PathVariable("menuId") String id) {
        IPage<ArticleVO> page = articleService.page(articlePage, id);
        return ReturnUtil.success("ok", page, null);
    }

    /**
     * 分页条件查询符合条件的所有商品，JSON格式返回
     */
    @PostMapping("/product/list")
    @ResponseBody
    public ModelMap listProduct(@RequestBody Page<ProductVO> productPage) {
        Page<ProductVO> page = productService.page(productPage);
        return ReturnUtil.success("ok", page, null);
    }

    /**
     * 分页条件查询符合条件的所有游艇，JSON格式返回
     */
    @PostMapping("/yacht/list")
    @ResponseBody
    public ModelMap listYacht(@RequestBody Page<YachtVO> yachtPage) {
        Page<YachtVO> page = yachtService.page(yachtPage);
        return ReturnUtil.success("ok", page, null);
    }

    /**
     * 根据id查询对应文章并以JSON格式返回
     *
     * @param id 文章id
     * @return JSON对象
     */
    @PostMapping("/article/{articleId}")
    @ResponseBody
    public ModelMap getArticle(@PathVariable("articleId") String id) {
        Article article = articleService.getById(id);
        return ReturnUtil.success("ok", article, null);
    }

    /**
     * 根据id查询对应游艇信息并以JSON格式返回
     * @param yacht
     * @return
     */
    @PostMapping("/yacht/getYacht")
    @ResponseBody
    public ModelMap getYacht(@RequestBody Yacht yacht){
        yacht = yachtService.getById(yacht.getId());
        return ReturnUtil.success("ok",yacht);
    }
}
