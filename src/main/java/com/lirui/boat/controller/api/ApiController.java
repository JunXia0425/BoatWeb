package com.lirui.boat.controller.api;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Menu;
import com.lirui.boat.entity.vo.MenuVO;
import com.lirui.boat.service.impl.ArticleServiceImpl;
import com.lirui.boat.service.impl.MenuServiceImpl;
import com.lirui.boat.service.impl.ProductServiceImpl;
import com.lirui.boat.service.impl.YachtServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
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
    public ModelMap listMenu(@RequestBody Page<MenuVO> menuPage) {
        menuPage.setAsc("num");
        IPage<MenuVO> page = menuService.page(menuPage);
        return ReturnUtil.success("ok", page, null);
    }

    /**
     * 请求目录名称
     */
    @PostMapping("/menu")
    public ModelMap getMenu(@RequestBody Menu menu){
        menu = menuService.getById(menu.getId());
        return ReturnUtil.success("ok",menu);
    }

    /**
     * 查询所有启用目录(仅查询id，栏目名称，父级栏目id,url)，用于展示树形图
     */
    @PostMapping("/menu/all")
    public ModelMap allMenu() {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "pid", "url", "name").eq("enable_status", 1).orderByAsc("num");
        List<Map<String, Object>> maps = menuService.listMaps(queryWrapper);
        return ReturnUtil.success("ok", maps, null);
    }



}
