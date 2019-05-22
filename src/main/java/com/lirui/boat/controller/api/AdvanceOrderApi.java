package com.lirui.boat.controller.api;


import com.lirui.boat.entity.AdvanceOrder;
import com.lirui.boat.entity.dto.AdvanceOrderDTO;
import com.lirui.boat.service.impl.AdvanceOrderServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 预定订单表 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@RestController
@RequestMapping("/api/advance-order")
@Slf4j
public class AdvanceOrderApi {
    @Autowired
    private AdvanceOrderServiceImpl advanceOrderService;

    /**
     * 开票预定
     *
     * @param advanceOrder 包含订单和开票信息
     * @return
     */
    @PostMapping("save")
    public ModelMap save(@RequestBody AdvanceOrderDTO advanceOrder) {
        try {
            return ReturnUtil.success("恭喜您，预定成功！", advanceOrderService.save(advanceOrder));
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.error(e.getMessage());
        }
    }

    /**
     * 不开票预定，直接传回订单并保存
     * @param advanceOrder 订单信息
     * @return
     */
    @PostMapping("save-no-invoice")
    public ModelMap saveNoInvoice(@RequestBody AdvanceOrder advanceOrder) {
        advanceOrder.setInvoice(null);
        return ReturnUtil.success("恭喜您，预定成功！",advanceOrderService.save(advanceOrder));
    }
}
