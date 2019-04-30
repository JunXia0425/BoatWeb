package com.lirui.boat.controller;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lirui.boat.entity.User;
import com.lirui.boat.entity.Yacht;
import com.lirui.boat.service.impl.YachtServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 游艇信息 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-04-27
 */
@Controller
@RequestMapping("/yacht")
@Slf4j
public class YachtController {
    @Autowired
    private YachtServiceImpl yachtService;


    /**
     * 跳转到游艇列表
     */
    @GetMapping("list")
    public String yachtList() {
        return "/admin/yacht/list";
    }





    /**
     * 跳转到表单页面，如果传入的对象不是null，获取对象的所有信息，反填到表单中
     *
     * @param yacht 表单传入的Yacht对象
     */
    @GetMapping({"form"})
    public String showForm(Yacht yacht, Model model) {
        Yacht yacht1 = new Yacht();
        if (!StringUtils.isEmpty(yacht.getId())) {
            yacht1 = yachtService.getById(yacht.getId());
        }
        User principal = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("yacht", yacht1);
        model.addAttribute("ownerId",principal.getId());
        return "/admin/yacht/form";
    }

    /**
     * 游艇新增/保存
     *
     * @param yacht 表单传入的Yacht对象
     */
    @PostMapping("save")
    @ResponseBody
    public ModelMap saveAdmin(Yacht yacht) {

        return saveyacht(yacht);
    }


    /**
     * 根据id删除游艇
     */
    @GetMapping("del")
    @ResponseBody
    public ModelMap del(@RequestParam("id") String id) {
        boolean b = yachtService.removeById(id);
        if (b) {
            return ReturnUtil.success("删除成功", null, "yacht/list");
        }
        return ReturnUtil.error("删除失败", null, "yacht/list");
    }

    /**
     * 具体的保存方法，根据id判断游艇是否存在，存在执行update，否则执行insert
     *
     * @param yacht 表单传入的Yacht对象
     */
    //TODO:经常使用，后期改成泛型的，用反射改造
    public ModelMap saveyacht(Yacht yacht) {
        if (!StringUtils.isEmpty(yacht.getId())) {
            log.info("此游艇存在，本次操作为：更新游艇");
            boolean save = yachtService.updateById(yacht);
            if (save) {
                return ReturnUtil.success("更新成功", null, "yacht/list");
            } else {
                return ReturnUtil.error("更新失败", null, "yacht/list");
            }
        } else {
            log.info("游艇不存在，本次操作为：新增游艇");
            boolean save = yachtService.save(yacht);
            if (save) {
                return ReturnUtil.success("保存成功", null, "yacht/list");
            } else {
                return ReturnUtil.error("操作失败", null, "yacht/list");
            }
        }
    }
}
