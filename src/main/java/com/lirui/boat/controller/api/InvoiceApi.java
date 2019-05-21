package com.lirui.boat.controller.api;


import com.lirui.boat.entity.Invoice;
import com.lirui.boat.service.impl.InvoiceServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 票据信息表 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@RestController
@RequestMapping("/api/invoice")
public class InvoiceApi {
    @Autowired
    private InvoiceServiceImpl invoiceService;

    @PostMapping("save")
    public ModelMap save(@RequestBody Invoice invoice){
        return ReturnUtil.success("OK",invoiceService.saveAndreturnId(invoice));
    }
}
