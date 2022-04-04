package com.coderman.constant;

import com.coderman.model.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author coderman
 * @Title: TODO
 * @Description: TOD
 * @date 2022/3/1720:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConstantItems extends BaseModel {

    @ApiModelProperty(value = "字典组")
    private String group;


    @ApiModelProperty(value = "字典香")
    private List<ConstantItem> itemList;
}
