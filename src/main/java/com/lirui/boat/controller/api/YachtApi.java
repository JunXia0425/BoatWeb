package com.lirui.boat.controller.api;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lirui.boat.entity.Yacht;
import com.lirui.boat.entity.dto.YachtDTO;
import com.lirui.boat.entity.vo.YachtVO;
import com.lirui.boat.service.impl.YachtServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * YachtApi
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-18
 */
@RestController
@RequestMapping("api")
public class YachtApi {
    @Autowired
    private YachtServiceImpl yachtService;

    @PostMapping("getRegions")
    public ModelMap getRegions(){
        return ReturnUtil.success("ok",yachtService.getRegions());
    }

    /**
     * 分页查询所有游艇，JSON格式返回
     */
    @PostMapping("/yacht/list")
    public ModelMap listYacht(@RequestBody Page<YachtVO> page){
        page = yachtService.page(page);
        return ReturnUtil.success("ok",page);
    }
    /**
     * 分页条件查询符合条件的所有游艇，JSON格式返回
     */
    @PostMapping("/yacht/list/condition")
    public ModelMap listYacht(@RequestBody YachtDTO data) {

        Page<YachtVO> page = yachtService.page(data.getYachtPage(),data.getQuery());
        return ReturnUtil.success("ok", page, null);
    }


    /**
     * 根据id查询对应游艇信息并以JSON格式返回
     * @param yacht
     * @return
     */
    @PostMapping("/yacht/getYacht")
    public ModelMap getYacht(@RequestBody Yacht yacht){
        yacht = yachtService.getById(yacht.getId());
        return ReturnUtil.success("ok",yacht);
    }
}
