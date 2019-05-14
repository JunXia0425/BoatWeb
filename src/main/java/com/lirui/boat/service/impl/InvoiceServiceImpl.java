package com.lirui.boat.service.impl;

import com.lirui.boat.entity.Invoice;
import com.lirui.boat.mapper.InvoiceMapper;
import com.lirui.boat.service.InvoiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 票据信息表 服务实现类
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@Service
public class InvoiceServiceImpl extends ServiceImpl<InvoiceMapper, Invoice> implements InvoiceService {

}
