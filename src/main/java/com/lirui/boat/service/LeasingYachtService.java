package com.lirui.boat.service;

import com.lirui.boat.entity.LeasingYacht;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lirui.boat.entity.dto.LeasingYachtDTO;

/**
 * <p>
 * 租赁游艇表 服务类
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
public interface LeasingYachtService extends IService<LeasingYacht> {

    /**
     * 保存表单数据到数据库
     * @param dto
     * @return
     */
    boolean save(LeasingYachtDTO dto);
}
