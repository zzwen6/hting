/**
 * File Name: top.hting.config.GlobalExceptionHandler.java

 * @Date:2018年8月28日下午9:54:20
 */
package top.hting.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import top.hting.api.ResultAPI;
import top.hting.exception.CustomeException;

/**
 * File Name: top.hting.config.GlobalExceptionHandler.java
 * 统一异常处理
 * @Date:2018年8月28日下午9:54:20
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResultAPI errorHandler(Exception ex){
		return ResultAPI.systemError();
	}
	
	@ExceptionHandler(value = CustomeException.class)
	public ResultAPI customErrorHanlder(CustomeException ce){
		ResultAPI resultAPI = new ResultAPI();
		resultAPI.setCode(400);
		resultAPI.setMsg(ce.getMessage());
		resultAPI.setData(null);
		return resultAPI;
	}
	
}
