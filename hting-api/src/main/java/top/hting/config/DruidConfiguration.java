package top.hting.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
/**
 * Druid 连接池监控配置
 * @author Administrator
 *
 */
@Configuration
public class DruidConfiguration {

	@Bean
	public ServletRegistrationBean statViewServlet() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
		servletRegistrationBean.addInitParameter("loginUsername", "druid");
		servletRegistrationBean.addInitParameter("loginPassword", "123456");
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		return servletRegistrationBean;
	}
	
	@Bean
	public FilterRegistrationBean statFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.jpeg,*.png,*.css,*.css,*.ico,*,/druid/*");
		return filterRegistrationBean;
	}
	
	
}
