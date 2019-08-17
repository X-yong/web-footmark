package com.common.footmark;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description :
 * @Author : xiongyong
 * @Date : 2018/10/10 20:09
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -1L;

    @ApiModelProperty(value = "id")
    private Integer id;

    @ApiModelProperty(value = "name")
    private String name ;



    public User (){

    }
    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
