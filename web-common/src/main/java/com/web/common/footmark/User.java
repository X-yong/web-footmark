package com.web.common.footmark;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/10 20:09
 */
@Data
public class User {

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "name")
    private String name ;


}
