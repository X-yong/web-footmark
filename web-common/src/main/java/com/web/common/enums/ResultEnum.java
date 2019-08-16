package com.web.common.enums;

/**
 * 系统接口结果常量枚举类
 */
public enum ResultEnum {
 
	SUCCESS("200", "success"),
	ERROR_POST_PARAM("400","访问参数异常"),
    FORBIDDEN("403","无权限访问"),
	ERROR_POST_METHOD("405","访问方法异常"),
	PARAMS_MISSING_ERROR("409","缺少参数" ),
	UNKONW_ERROR("500","系统内部错误" );

	private String code;

	private String message;

	ResultEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	} 

}
