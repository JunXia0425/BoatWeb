package com.lirui.boat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lirui.boat.entity.AdvanceOrder;
import com.lirui.boat.entity.Invoice;
import com.lirui.boat.entity.Stock;
import com.lirui.boat.entity.dto.AdvanceOrderDTO;
import com.lirui.boat.mapper.AdvanceOrderMapper;
import com.lirui.boat.service.AdvanceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 预定订单表 服务实现类
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@Service
public class AdvanceOrderServiceImpl extends ServiceImpl<AdvanceOrderMapper, AdvanceOrder> implements AdvanceOrderService {
    @Autowired
    private StockServiceImpl stockService;
    @Autowired
    private InvoiceServiceImpl invoiceService;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public boolean save(AdvanceOrderDTO entity) throws Exception {
        Invoice invoice = entity.getInvoice();
        AdvanceOrder advanceOrder = entity.getAdvanceOrder();
        //1. 保存开票信息
        String invoiceId = invoiceService.saveAndreturnId(invoice);
        //2. 将票据id存到advanceOrder的invoice中
        advanceOrder.setInvoice(invoiceId);
        //3. 从订单中获取游艇id，根据id找对应库存
        Stock stock = stockService.getById(advanceOrder.getYachtId());
        Integer count = stock.getCount();
        if (count == 0) {
            throw new RuntimeException("暂无库存，稍后再试");
        }
        //库存减1
        stock.setCount(--count);
        //4. 更新减1之后的库存
        boolean update = stockService.updateById(stock);
        //5.保存订单信息
        boolean save = this.save(advanceOrder);
        return update && save;

    }
}
