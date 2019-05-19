package com.lirui.boat.controller.api;

import com.lirui.boat.service.impl.ClassificationServiceImpl;
import com.lirui.boat.utils.ReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * Classification
 * </p>
 *
 * @author Li Rui
 * @since 2019-05-18
 */
@RestController
@RequestMapping("api")
public class ClassificationApi {
    @Autowired
    private ClassificationServiceImpl classificationService;


    @PostMapping("getClassifications")
    public ModelMap getClassifications(){
        return ReturnUtil.success("ok",classificationService.list());
    }
}
