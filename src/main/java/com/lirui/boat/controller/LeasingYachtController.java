package com.lirui.boat.controller;


import com.lirui.boat.entity.Yacht;
import com.lirui.boat.entity.dto.LeasingYachtDTO;
import com.lirui.boat.entity.vo.YachtVO;
import com.lirui.boat.service.impl.ClassificationServiceImpl;
import com.lirui.boat.service.impl.LeasingYachtServiceImpl;
import com.lirui.boat.service.impl.YachtServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 租赁游艇表 前端控制器
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-14
 */
@Controller
@RequestMapping("/leasing-yacht")
@Slf4j
public class LeasingYachtController {
    @Autowired
    private YachtServiceImpl yachtService;
    @Autowired
    private ClassificationServiceImpl classificationService;
    @Autowired
    private LeasingYachtServiceImpl leasingYachtService;
    /**
     * 跳转到租赁游艇列表
     */
    @GetMapping("list")
    public String toList(){
        return "/admin/leasing/list";
    }

    /**
     * 跳转到表单页面，如果传入的对象不是null，获取对象的所有信息，反填到表单中
     *
     */
    @GetMapping({"form"})
    public String showForm(@RequestParam("id")String id, Model model) {
        YachtVO yachtVO = yachtService.getById(id);
        model.addAttribute("yacht",yachtVO);
        return "/admin/leasing/form";
    }


    /**
     * 保存表单内容
     * @param dto 表单传入数据对象
     * @return
     */
    @PostMapping("save")
    @ResponseBody
    public ModelMap save(@RequestBody LeasingYachtDTO dto) {
        boolean save = leasingYachtService.save(dto);
        try {
            return ReturnUtil.success("出租成功",null,"leasing-yacht/list");
        } catch (Exception e) {
            return ReturnUtil.error(e.getMessage(),null,"leasing-yacht/list");
        }
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
