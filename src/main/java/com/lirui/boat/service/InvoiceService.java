package com.lirui.boat.service;

import com.lirui.boat.entity.Invoice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 票据信息表 服务类
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
public interface InvoiceService extends IService<Invoice> {

    /**
     * 保存开票信息，并返回id
     * @param entity
     * @return
     */
    String saveAndreturnId(Invoice entity);
}
