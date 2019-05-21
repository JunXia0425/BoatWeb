package com.lirui.boat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lirui.boat.entity.AdvanceOrder;
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
        // 先保存订单
        //抽离order
        AdvanceOrder order = new AdvanceOrder();
        order.setCustomerName(entity.getCustomerName())
                .setGender(entity.getGender())
                .setInvoice(entity.getInvoice())
                .setPeopleCount(entity.getPeopleCount())
                .setPhone(entity.getPhone())
                .setRemark(entity.getRemark())
                .setRoute(entity.getRoute())
                .setTripDate(entity.getTripDate())
                .setTripPurpose(entity.getTripPurpose())
                .setTripTime(entity.getTripTime())
                .setYachtName(entity.getYachtName());
        boolean save = this.save(order);
        String yachtId = entity.getYachtId();
        // 更新库存
        Stock stock = stockService.getById(yachtId);
        Integer count = stock.getCount();
        if (count == 0) {
            throw new RuntimeException("暂无库存，稍后再试");
        }
        stock.setCount(--count);
        boolean update = stockService.updateById(stock);
        return save && update;

    }
}
