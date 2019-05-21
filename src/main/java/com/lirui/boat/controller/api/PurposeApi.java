package com.lirui.boat.controller.api;


import com.lirui.boat.service.impl.PurposeServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 出行目的表 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@RestController
@RequestMapping("/api/purpose")
public class PurposeApi {
    @Autowired
    private PurposeServiceImpl purposeService;

    @GetMapping("list")
    public ModelMap list(){
        return ReturnUtil.success("ok",purposeService.list());
    }
}
