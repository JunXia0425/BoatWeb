package com.lirui.boat.service;

import com.lirui.boat.entity.SliderImg;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lirui.boat.entity.dto.SliderDTO;

/**
 * <p>
 * 轮播图片表 服务类
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
public interface SliderImgService extends IService<SliderImg> {
    /**
     * 批量保存游艇轮播图
     * @param entity
     * @return
     */
    boolean save(SliderDTO entity);
}
