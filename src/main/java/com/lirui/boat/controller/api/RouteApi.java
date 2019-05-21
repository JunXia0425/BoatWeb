package com.lirui.boat.controller.api;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lirui.boat.entity.Route;
import com.lirui.boat.service.impl.RouteServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 航线表 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-20
 */
@RestController
@RequestMapping("/api/route")
public class RouteApi {
    @Autowired
    private RouteServiceImpl routeService;
    @GetMapping("list-by-yachtId")
    public ModelMap list(@Param("id") String id){
        QueryWrapper<Route> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("yacht_id",id);
        return ReturnUtil.success("ok",routeService.list(queryWrapper));
    }
}
