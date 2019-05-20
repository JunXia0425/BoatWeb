package com.lirui.boat.controller.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.vo.LeasingYachtVO;
import com.lirui.boat.service.impl.LeasingYachtServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * LeasingYachtApi
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-20
 */
@RestController
@RequestMapping("api/leasing-yacht")
public class LeasingYachtApi {
    @Autowired
    private LeasingYachtServiceImpl leasingYachtService;

    @PostMapping("list")
    public ModelMap doList(@RequestBody Page<LeasingYachtVO> page){
        page = leasingYachtService.page(page);
        return ReturnUtil.success("ok",page);
    }
}
