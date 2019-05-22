package com.lirui.boat.controller.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.LeasingYacht;
import com.lirui.boat.entity.dto.LeasingYachtQueryDTO;
import com.lirui.boat.entity.vo.LeasingYachtVO;
import com.lirui.boat.service.impl.LeasingYachtServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("exist")
    public ModelMap exist(@RequestParam("id") String id){
        boolean exist = leasingYachtService.exist(id);
        return ReturnUtil.success("ok",exist);
    }

    @GetMapping("info")
    public ModelMap info(@RequestParam("id") String id){
        LeasingYacht leasingYacht = leasingYachtService.getById(id);
        try {
            return ReturnUtil.success("ok",leasingYacht);
        } catch (Exception e) {
            return ReturnUtil.error(e.getMessage());
        }
    }

    /**
     * 分页条件查询符合条件的所有游艇，JSON格式返回
     */
    @PostMapping("list/condition")
    public ModelMap listYacht(@RequestBody LeasingYachtQueryDTO data) {

        Page<LeasingYachtVO> page = leasingYachtService.page(data.getYachtPage(),data.getQuery());
        return ReturnUtil.success("ok", page, null);
    }
}
