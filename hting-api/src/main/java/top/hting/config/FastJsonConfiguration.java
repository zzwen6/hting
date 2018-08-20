package top.hting.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 两种配置形式：
 * 	1.通过继承WebMvcConfigurerAdapter实现全局的转换器
 *  2.添加一个bean的方式，这个bean会在切面里面充当最终输出流的转换
 * @author Administrator
 *
 */
@Configuration
public class FastJsonConfiguration extends WebMvcConfigurerAdapter{

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		super.configureMessageConverters(converters);
		
//		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
//		FastJsonConfig config = new FastJsonConfig();
//		config.setSerializerFeatures(
//				SerializerFeature.DisableCircularReferenceDetect,
//				SerializerFeature.WriteMapNullValue,
//				SerializerFeature.WriteNullListAsEmpty,
//				SerializerFeature.WriteNullStringAsEmpty);
//		fastJsonHttpMessageConverter.setFastJsonConfig(config);
		converters.add(converter());
	}
	@Bean
	public FastJsonHttpMessageConverter converter() {
		FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(
				SerializerFeature.DisableCircularReferenceDetect,
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullStringAsEmpty);
		fastJsonHttpMessageConverter.setFastJsonConfig(config);
		return fastJsonHttpMessageConverter;
	}
	
}
