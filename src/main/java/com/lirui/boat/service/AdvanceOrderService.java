package com.lirui.boat.service;

import com.lirui.boat.entity.AdvanceOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lirui.boat.entity.dto.AdvanceOrderDTO;

/**
 * <p>
 * 预定订单表 服务类
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
public interface AdvanceOrderService extends IService<AdvanceOrder> {

    /**
     * 接收前端传来的对象，保存订单信息
     * @param entity 表单对象
     * @return
     */
    boolean save(AdvanceOrderDTO entity) throws Exception;
}
