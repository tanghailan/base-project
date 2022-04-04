package com.coderman.constant;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * @author coderman
 * @Title: TODO
 * @Description: TOD
 * @date 2022/1/2519:47
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface ConstantList {

    /**
     * 常量组
     *
     * @return
     */
    String group();


    /**
     * 常量名
     *
     * @return
     */
    String name();
}
