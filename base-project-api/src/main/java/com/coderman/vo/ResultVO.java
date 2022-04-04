package com.coderman.vo;

import com.coderman.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author coderman
 * @Title: 公共返回对象
 * @Description: TOD
 * @date 2022/1/115:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultVO<T> extends BaseModel {

    /**
     * 状态码
     */
    private int code;

    /**
     * 返回消息
     */
    private String msg;


    /**
     * 响应结果
     */
    private T result;
}
