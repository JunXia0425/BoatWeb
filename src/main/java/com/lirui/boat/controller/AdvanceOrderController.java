package com.lirui.boat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>
 * AdvanceOrderController
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-22
 */
@Controller
@RequestMapping("advance-order")
public class AdvanceOrderController {

    @GetMapping("list")
    public String toList(){
        return "admin/invoice/list";
    }
}
