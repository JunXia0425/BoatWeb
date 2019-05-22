package com.lirui.boat.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lirui.boat.entity.Product;
import com.lirui.boat.entity.User;
import com.lirui.boat.service.impl.ProductServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 商品信息表 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-22
 */
@Controller
@RequestMapping("/product")
@Slf4j
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("list")
    public String toList(){
        return "/admin/product/list";
    }

    /**
     * 跳转到表单页面，如果传入的对象不是null，获取对象的所有信息，反填到表单中
     *
     * @param product 表单传入的Product对象
     */
    @GetMapping({"form"})
    public String showForm(Product product, Model model) {
        Product product1 = new Product();
        if (!StringUtils.isEmpty(product.getId())) {
            product1 = productService.getById(product.getId());
        }
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("product", product1);
        model.addAttribute("ownerId",principal.getId());
        return "/admin/product/form";
    }

    /**
     * 配件新增/保存
     *
     * @param product 表单传入的Product对象
     */
    @PostMapping("save")
    @ResponseBody
    public ModelMap saveAdmin(Product product) {

        return saveproduct(product);
    }


    /**
     * 根据id删除配件
     */
    @GetMapping("del")
    @ResponseBody
    public ModelMap del(@RequestParam("id") String id) {
        boolean b = productService.removeById(id);
        if (b) {
            return ReturnUtil.success("删除成功", null, "product/list");
        }
        return ReturnUtil.error("删除失败", null, "product/list");
    }

    /**
     * 具体的保存方法，根据id判断配件是否存在，存在执行update，否则执行insert
     *
     * @param product 表单传入的Product对象
     */
    public ModelMap saveproduct(Product product) {
        if (!StringUtils.isEmpty(product.getId())) {
            log.info("此配件存在，本次操作为：更新配件");
            boolean save = productService.updateById(product);
            if (save) {
                return ReturnUtil.success("更新成功", null, "product/list");
            } else {
                return ReturnUtil.error("更新失败", null, "product/list");
            }
        } else {
            log.info("配件不存在，本次操作为：新增配件");
            boolean save = productService.save(product);
            if (save) {
                return ReturnUtil.success("保存成功", null, "product/list");
            } else {
                return ReturnUtil.error("操作失败", null, "product/list");
            }
        }
    }
}
