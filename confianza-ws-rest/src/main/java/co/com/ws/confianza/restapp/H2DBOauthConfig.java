package co.com.ws.confianza.restapp;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static java.util.Collections.singletonMap;

@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "h2EntityManagerFactory", transactionManagerRef = "h2TransactionManager", basePackages = {
		"co.com.ws.confianza.dao.oauth" })
@EnableTransactionManagement
public class H2DBOauthConfig {

	@Bean(name = { "h2EntityManagerFactory" })
	@Primary
	public LocalContainerEntityManagerFactoryBean firstEntityManagerFactory(final EntityManagerFactoryBuilder builder,
			final @Qualifier("h2Database") DataSource dataSource) {
		return builder.dataSource(dataSource).packages("co.com.ws.confianza.model.auth" )
				.persistenceUnit("h2DB").properties(singletonMap("hibernate.hbm2ddl.auto", "create-drop"))
				.build();
	}

	@Bean(name = { "h2TransactionManager" })
	@Primary
	public PlatformTransactionManager firstTransactionManager(
			@Qualifier("h2EntityManagerFactory") EntityManagerFactory firstEntityManagerFactory) {
		return new JpaTransactionManager(firstEntityManagerFactory);
	}
}
