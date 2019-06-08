package com.lirui.boat.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.YachtOrder;
import com.lirui.boat.service.impl.YachtOrderServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 游艇订单表 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-06-08
 */
@Controller
@RequestMapping("/yacht-order")
public class YachtOrderController {
    @Autowired
    private YachtOrderServiceImpl yachtOrderService;


    @GetMapping("list")
    public String toList(){
        return "admin/yacht/order";
    }

    /**
     * 分页查询所有订单，JSON格式返回
     */
    @PostMapping("list")
    @ResponseBody
    public ModelMap userList(@RequestBody Page<YachtOrder> yachtOrderPage) {
        QueryWrapper<YachtOrder> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        IPage<YachtOrder> page = yachtOrderService.page(yachtOrderPage,wrapper);
        return ReturnUtil.success("ok", page, null);
    }
}
