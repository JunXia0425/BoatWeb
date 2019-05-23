package com.lirui.boat.service.impl;

import com.lirui.boat.entity.SliderImg;
import com.lirui.boat.entity.dto.SliderDTO;
import com.lirui.boat.mapper.SliderImgMapper;
import com.lirui.boat.service.SliderImgService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 轮播图片表 服务实现类
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@Service
public class SliderImgServiceImpl extends ServiceImpl<SliderImgMapper, SliderImg> implements SliderImgService {
    @Autowired
    private SliderImgMapper sliderImgMapper;

    @Override
    public boolean save(SliderDTO entity) {
        String yachtId = entity.getId();
        List<String> pics = entity.getPics();
        ArrayList<SliderImg> sliderImgs = new ArrayList<>();
        for (String pic : pics) {
            SliderImg sliderImg = new SliderImg();
            sliderImg.setYachtId(yachtId);
            sliderImg.setPath(pic);
            sliderImgs.add(sliderImg);
        }
        return this.saveBatch(sliderImgs);
    }
}
