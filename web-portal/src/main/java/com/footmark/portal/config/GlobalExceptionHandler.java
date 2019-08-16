package com.footmark.portal.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.netflix.hystrix.exception.HystrixRuntimeException;
import com.web.common.enums.ResultEnum;
import com.web.common.util.InterfaceResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.ConnectException;
import java.util.List;

/**
 * Created by zou
 */
@SuppressWarnings({"rawtypes","unchecked"})
@RestControllerAdvice
public class GlobalExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(getClass());


	@ExceptionHandler(value = Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public InterfaceResult exceptionHandler(Exception e) {
		logger.error(ResultEnum.UNKONW_ERROR.getMessage(), e);
		return InterfaceResult.build(ResultEnum.UNKONW_ERROR.getCode(), ResultEnum.UNKONW_ERROR.getMessage());
	}

	@ExceptionHandler(value = HttpMessageNotReadableException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public InterfaceResult httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
		logger.error(ResultEnum.ERROR_POST_PARAM.getMessage(), e);
		return InterfaceResult.build(ResultEnum.ERROR_POST_PARAM.getCode(), ResultEnum.ERROR_POST_PARAM.getMessage());

	}

	@ExceptionHandler(value = RuntimeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public InterfaceResult runtimeExceptionHandler(RuntimeException e) {
		logger.error("---------> huge error!", e);
		return InterfaceResult.build(ResultEnum.UNKONW_ERROR.getCode(), ResultEnum.UNKONW_ERROR.getMessage());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public InterfaceResult illegalParamsExceptionHandler(MethodArgumentNotValidException e) {
		logger.error("---------> invalid io!", e);
		List<ObjectError> errors = e.getBindingResult().getAllErrors();
		StringBuilder sb = new StringBuilder("");
		if (errors != null && errors.size() > 0) {
			int i = 0;
			for (ObjectError error : errors) {
				FieldError fieldError = (FieldError) error;
				if (i < errors.size()) {
					if (i == errors.size() - 1) {
						sb.append(fieldError.getField() + fieldError.getDefaultMessage());
					} else {
						sb.append(fieldError.getField() + fieldError.getDefaultMessage() + ", ");
					}
				}
				i++;
			}

		}
		return InterfaceResult.build(ResultEnum.ERROR_POST_METHOD.getCode(), sb.toString());
	}

	@ExceptionHandler(ConnectException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public InterfaceResult<String> connectException(ConnectException e) {
		logger.error("---------> ConnectException!", e);

		return InterfaceResult.build(ResultEnum.UNKONW_ERROR.getCode(), "服务请求超时");
	}

	@ExceptionHandler(JsonProcessingException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public InterfaceResult illegalJsonException(JsonProcessingException e) {
		logger.error("---------> invalid json!", e);
		return InterfaceResult.build(ResultEnum.UNKONW_ERROR.getCode(), "Json转换异常");
	}

	@ExceptionHandler(JsonMappingException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public InterfaceResult jsonMappingException(JsonMappingException e) {
		logger.error("---------> invalid jsonMappping!", e);
		return InterfaceResult.build(ResultEnum.UNKONW_ERROR.getCode(), "Json映射转换异常");
	}


	@ExceptionHandler(HystrixRuntimeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public InterfaceResult hystrixRuntimeException(HystrixRuntimeException e) {
		logger.error("---------> invalid eureka interface access!", e);
		return InterfaceResult.build(ResultEnum.UNKONW_ERROR.getCode(), "接口访问异常");
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public InterfaceResult exception() {
		logger.error("---------> Internal Server Error!");
		return InterfaceResult.build("500", "内部错误");
	}
}
