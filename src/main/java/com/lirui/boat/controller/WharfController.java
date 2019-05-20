package com.lirui.boat.controller;


import com.lirui.boat.service.impl.WharfServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 码头表 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@RestController
@RequestMapping("/api/wharf")
public class WharfController {
    @Autowired
    private WharfServiceImpl wharfService;

    @GetMapping("list")
    public ModelMap getAllWharfs(){
        return ReturnUtil.success("ok",wharfService.list());
    }
}
