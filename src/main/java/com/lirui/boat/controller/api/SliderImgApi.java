package com.lirui.boat.controller.api;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lirui.boat.entity.SliderImg;
import com.lirui.boat.entity.dto.SliderDTO;
import com.lirui.boat.service.impl.SliderImgServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 轮播图片表 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@RestController
@RequestMapping("/api/slider-img")
public class SliderImgApi {
    @Autowired
    private SliderImgServiceImpl sliderImgService;

    @PostMapping("save")
    public ModelMap saveSliderPics(@RequestBody SliderDTO sliderDTO){
        try {
            return ReturnUtil.success("ok",sliderImgService.save(sliderDTO));
        } catch (Exception e) {
            return ReturnUtil.error(e.getMessage());
        }
    }

    @PostMapping("get")
    public ModelMap getSliderPics(@RequestBody SliderImg sliderImg){
        String yachtId = sliderImg.getYachtId();
        QueryWrapper<SliderImg> sliderImgQueryWrapper = new QueryWrapper<>();
        sliderImgQueryWrapper.eq("yacht_id",yachtId);
        return ReturnUtil.success("ok",sliderImgService.list(sliderImgQueryWrapper));
    }
}
