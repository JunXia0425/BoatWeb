package com.lirui.boat.controller.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.dto.ProductDTO;
import com.lirui.boat.entity.vo.ProductVO;
import com.lirui.boat.service.impl.ProductServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * ProductApi
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-22
 */
@RestController
@RequestMapping("api/product")
public class ProductApi {
    @Autowired
    private ProductServiceImpl productService;

    /**
     * 查询product表中所有的产地
     * @return
     */
    @PostMapping("getRegions")
    public ModelMap getRegions(){
        return ReturnUtil.success("ok",productService.getRegions());
    }

    /**
     * 分页条件查询符合条件的所有商品，JSON格式返回
     */
    @PostMapping("/list")
    @ResponseBody
    public ModelMap listProduct(@RequestBody Page<ProductVO> productPage) {
        Page<ProductVO> page = productService.page(productPage);
        return ReturnUtil.success("ok", page, null);
    }

    /**
     * 分页条件查询符合条件的所有游艇，JSON格式返回
     */
    @PostMapping("/list/condition")
    public ModelMap listProduct(@RequestBody ProductDTO data) {

        Page<ProductVO> page = productService.page(data.getProductPage(),data.getQuery());
        return ReturnUtil.success("ok", page, null);
    }

    /**
     * 获取指定产品
     */
    @PostMapping("getProduct")
    public ModelMap getProduct(@RequestBody ProductVO productVO){
        productVO = productService.getById(productVO);
        return ReturnUtil.success("ok",productVO);
    }
}
