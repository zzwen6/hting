package top.hting.config;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

import top.hting.api.ResultAPI;

/**
 * 统一返回切面
 * @author Administrator
 *
 */
@Component
@Aspect
public class ResponseAspect {
	@Resource
	FastJsonHttpMessageConverter convert;
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping) ||"
			+ " @annotation(org.springframework.web.bind.annotation.PostMapping)")
	public void responseBodyPointCut() {}
	
	@Around(value = "responseBodyPointCut()")
	public void around(ProceedingJoinPoint jp) throws Throwable {
		Object ret = jp.proceed();
		ResultAPI resultAPI = null;
		if (ret instanceof ResultAPI) {
			resultAPI = (ResultAPI) ret;
		}else {
			resultAPI = ResultAPI.buildSuccess(ret);
		}
		
		HttpServletResponse response =((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
		HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
		
		convert.write(resultAPI, MediaType.APPLICATION_JSON_UTF8, outputMessage);
		
	}
	
	
}
