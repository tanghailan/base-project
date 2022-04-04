package com.coderman.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author coderman
 * @Title: base com.coderman.controller
 * @Description: TOD
 * @date 2022/3/1612:37
 */
@RestController
@Slf4j
@ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
public class BaseController {

    @InitBinder
    protected void initBinder(WebDataBinder webDataBinder){

        SimpleDateFormat simpleDateFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(simpleDateFormat,true));
    }
}
