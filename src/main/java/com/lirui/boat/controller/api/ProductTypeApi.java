package com.lirui.boat.controller.api;


import com.lirui.boat.service.impl.ProductTypeServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-24
 */
@RestController
@RequestMapping("/api/product-type")
public class ProductTypeApi {
    @Autowired
    private ProductTypeServiceImpl productTypeService;

    @GetMapping("list")
    public ModelMap list(){
        return ReturnUtil.success("ok",productTypeService.list());
    }

}
