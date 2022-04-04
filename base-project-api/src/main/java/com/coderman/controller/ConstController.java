package com.coderman.controller;

import com.coderman.constant.ConstantItem;
import com.coderman.constant.ConstantService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author coderman
 * @Title: 常量获取
 * @Description: TOD
 * @date 2022/1/2520:28
 */
@RestController
public class ConstController {

    @GetMapping(value = "/${domain}/const/all")
    public Map<String, List<ConstantItem>> getAllConst(){
        return ConstantService.getAllConst();
    }
}
