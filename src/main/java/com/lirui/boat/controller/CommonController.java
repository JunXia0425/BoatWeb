package com.lirui.boat.controller;

import com.lirui.boat.entity.User;
import com.lirui.boat.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 公共功能 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-09
 */
@Slf4j
@Controller
public class CommonController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * 跳转到登录页面
     */
    @GetMapping("login")
    public String toIndex(Model model) {
        model.addAttribute("user", new User());
        return "/general/signin";
    }

    /**
     * 跳转到注册页面
     */
    @GetMapping("regist")
    public String toRegist(Model model) {
        model.addAttribute("user", new User());
        return "/general/signup";
    }

    /**
     * 跳转到登陆后首页
     *
     * @param model
     * @return
     */
    @GetMapping("console")
    public String toConsole(Model model) {
        return "/admin/console";
    }

    /**
     * 执行登录验证
     */
    @PostMapping("login")
    public String doLogin(User user, Model model) {
        String account = user.getAccount();
        String password = user.getPassword();
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        //封装token，由账户密码构成
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        //执行登录方法
        try {
            subject.login(token);
            return "redirect:/console";
        } catch (UnknownAccountException e) {
            log.error("未知用户名=>{}", account, e.getMessage());
            model.addAttribute("errMsg", "用户不存在");
        } catch (IncorrectCredentialsException e) {
            log.error("密码错误", e.getMessage());
            model.addAttribute("errMsg", "密码错误");
        }
        return "login";
    }

    /**
     * 执行注册操作
     */
    @PostMapping("regist")
    @ResponseBody
    public ModelMap doRegist(User user) {
        return userService.regist(user);
    }

    /**
     * 登出，跳转到登录页面，中间的用户注销逻辑由shiro自动完成
     */
    @GetMapping("logout")
    public String logout() {
        return "redirect:/login";
    }

    /**
     * 没有权限时请求此接口跳转到提示页面
     *
     * @return 无权限提示页面
     */
    @GetMapping("noPermission")
    public String noPermission() {
        return "noPermission";
    }
}
