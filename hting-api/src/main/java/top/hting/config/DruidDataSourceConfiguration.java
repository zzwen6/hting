package top.hting.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;
/**
 * 管理多数据源
 * @author Administrator
 *
 */
@Configuration
public class DruidDataSourceConfiguration {

	@Bean(name = "primaryDataSource")
	@Qualifier("primaryDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.primary")
	public DataSource primaryDataSource() {
		return new DruidDataSource();
	}
	
	@Bean(name = "slaveDataSource")
	@Qualifier("slaveDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.slave")
	public DataSource slaveDataSource() {
		return new DruidDataSource();
	}
}
