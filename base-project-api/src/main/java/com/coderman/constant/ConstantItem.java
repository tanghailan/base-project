package com.coderman.constant;

import com.coderman.model.BaseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author coderman
 * @Title: TODO
 * @Description: TOD
 * @date 2022/1/2519:49
 */
@Data
@NoArgsConstructor
public class ConstantItem extends BaseModel {

    private Object code;

    private String name;


    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ConstantItem(Object code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ConstantItem{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}'+'\n';
    }
}
