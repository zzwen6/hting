package top.hting.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.hibernate.cfg.ImprovedNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "entityManagerFactorySlave",
		transactionManagerRef = "transactionManagerSlave",
		basePackages = {"top.hting.jpa.slave" })
public class DruidSlaveConfig {

	@Autowired
	@Qualifier("slaveDataSource")
	private DataSource dataSource;

	@Bean(name = "entityManagerSlave")
	public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
		return entityManagerFactoryPrimary(builder).getObject().createEntityManager();
	}

	@Bean(name = "entityManagerFactorySlave")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(dataSource)
				.packages("top.hting.entity.slave")
				.persistenceUnit("primary")
				.properties(buildProperties())
				.build();
	}

	@Bean(name = "transactionManagerSlave")
	@Autowired
	public PlatformTransactionManager primaryTransactionManager(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
	}

	// 公共jpa设置
	@Value("${spring.jpa.hibernate.ddl-auto}")
	String dll;
	@Value("${spring.jpa.properties.hibernate.dialect}")
	String dialect;
	@Value("${spring.jpa.show-sql}")
	String showSql;

	private Map<String, Object> buildProperties() {
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("hibernate.ejb.naming_strategy", ImprovedNamingStrategy.class.getName());
		properties.put("hibernate.hbm2ddl.auto", dll);
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.show_sql", showSql);
		return properties;
	}

}
