package co.com.ws.confianza.restapp;

import java.util.Collections;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "oracleEntityManagerFactory", transactionManagerRef = "oracleTransactionManager", basePackages = {
		"co.com.ws.confianza.dao.external" })
@EnableTransactionManagement
public class OracleConfig {
	@Bean(name = { "oracleEntityManagerFactory" })
	public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("OracleDB") DataSource dataSource) {
		return builder.dataSource(dataSource).packages(new String[] { "" }).persistenceUnit("OracleDB")
				.properties(Collections.singletonMap("hibernate.hbm2ddl.auto", "create-drop")).build();
	}

	@Bean(name = { "oracleTransactionManager" })
	public PlatformTransactionManager firstTransactionManager(
			@Qualifier("oracleEntityManagerFactory") EntityManagerFactory firstEntityManagerFactory) {
		return new JpaTransactionManager(firstEntityManagerFactory);
	}
}
