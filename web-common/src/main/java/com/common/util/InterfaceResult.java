package com.common.util;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by zou on 2018/5/18.
 */
@Data
public class InterfaceResult<T> implements Serializable {


    /**
     *
     */
    private static final long serialVersionUID = 6424892182374472984L;

    private String code;

    private String msg;

    private T data;

    private Integer pageNum;

    private Integer pageSize;

    private Integer total;

    public InterfaceResult(){

    }
    public InterfaceResult(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public InterfaceResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static InterfaceResult success (String code, String msg ,Object data) {
      return new InterfaceResult(code,msg,data);
    }

    public static InterfaceResult build(String code, String msg, Object data) {
        return new InterfaceResult(code, msg, data);
    }

    public static InterfaceResult build(String code, String msg) {
        return new InterfaceResult(code, msg, null);
    }
}
