package com.lirui.boat.controller.api;


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
     * 开票保存
     *
     * @param advanceOrder
     * @return
     */
    @PostMapping("save")
    public ModelMap save(@RequestBody AdvanceOrderDTO advanceOrder) {
        try {
            return ReturnUtil.success("ok", advanceOrderService.save(advanceOrder));
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnUtil.error(e.getMessage());
        }
    }

    @PostMapping("save-no-invoice")
    public ModelMap saveNoInvoice(@RequestBody AdvanceOrderDTO advanceOrderDTO) {
        return null;
    }
}
