package com.lirui.boat.controller.api;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.AlipayTradePagePayModel;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.lirui.boat.config.AlipayProperties;
import com.lirui.boat.entity.YachtOrder;
import com.lirui.boat.service.impl.YachtOrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * 支付宝-电脑网站支付.
 * <p>
 * 电脑网站支付 https://docs.open.alipay.com/270/105898/
 *
 * @author Mengday Zhang
 * @version 1.0
 * @since 2018/6/14
 */
@Controller
@RequestMapping("/alipay/page")
@Slf4j
public class AlipayPagePayController {

    @Autowired
    private AlipayProperties alipayProperties;

    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private AlipayController alipayController;
    @Autowired
    private YachtOrderServiceImpl yachtOrderService;


    @GetMapping("/gotoPayPage")
    public void gotoPayPage(@RequestParam("yachtId")String yachtId,
                            @RequestParam("yachtName") String yachtName,
                            @RequestParam("phone") String phone,
                            @RequestParam("price") Float price,
                            @RequestParam("customerName") String customerName,
                            HttpServletResponse response) throws AlipayApiException, IOException
    {
        YachtOrder yachtOrder = new YachtOrder(yachtName, price, phone, customerName, yachtId);
        yachtOrderService.save(yachtOrder);
        // 订单模型
        String productCode = "FAST_INSTANT_TRADE_PAY";
        AlipayTradePagePayModel model = new AlipayTradePagePayModel();
        model.setOutTradeNo(yachtOrder.getId());
        model.setSubject("支付购买"+yachtName+"费用");
        model.setTotalAmount(price.toString());
        model.setBody("支付"+ yachtName +"，共"+ price +"元");
        model.setProductCode(productCode);

        AlipayTradePagePayRequest pagePayRequest =new AlipayTradePagePayRequest();
        pagePayRequest.setReturnUrl("http://6rqj3v.natappfree.cc/manage/alipay/page/returnUrl");
        pagePayRequest.setNotifyUrl(alipayProperties.getNotifyUrl());
        pagePayRequest.setBizModel(model);

        // 调用SDK生成表单, 并直接将完整的表单html输出到页面
        String form = alipayClient.pageExecute(pagePayRequest).getBody();
        response.setContentType("text/html;charset=" + alipayProperties.getCharset());
        response.getWriter().write(form);
        response.getWriter().flush();
        response.getWriter().close();
    }

    @RequestMapping("/returnUrl")
    public String returnUrl(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException, AlipayApiException {
        response.setContentType("text/html;charset=" + alipayProperties.getCharset());

        boolean verifyResult = alipayController.rsaCheckV1(request);
        if(verifyResult){
            //验证成功
            //请在这里加上商户的业务逻辑程序代码，如保存支付宝交易号
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            log.info("账单号={}",out_trade_no);
            YachtOrder yachtOrder = new YachtOrder();
            yachtOrder.setId(out_trade_no).setStatus(1);
            yachtOrderService.updateById(yachtOrder);
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");

            return "/alipay/pagePaySuccess";

        }else{
            return "/alipay/pagePayFail";

        }
    }
}
