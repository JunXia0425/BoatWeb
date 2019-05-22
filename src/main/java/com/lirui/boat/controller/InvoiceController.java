package com.lirui.boat.controller;

import com.lirui.boat.entity.Invoice;
import com.lirui.boat.service.impl.InvoiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>
 * InvoiceController
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-23
 */
@Controller
@RequestMapping("invoice")
public class InvoiceController {
    @Autowired
    private InvoiceServiceImpl invoiceService;

    @GetMapping("info")
    public String showInfo(@RequestParam("id")String id, Model model){
        Invoice invoice = invoiceService.getById(id);
        model.addAttribute("invoice",invoice);
        return "/admin/invoice/form";

    }
}
