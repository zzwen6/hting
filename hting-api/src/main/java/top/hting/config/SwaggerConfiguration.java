/**
 * File Name: top.hting.config.SwaggerConfiguration.java

 * @Date:2018年8月20日下午9:29:32
 */
package top.hting.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * File Name: top.hting.config.SwaggerConfiguration.java
 * 
 * @Date:2018年8月20日下午9:29:32
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
	@Bean
	public Docket swaggerPlugin(){
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).build();
	}
	
	
}
