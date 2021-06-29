package co.com.mercadolibre.config;

import java.beans.PropertyVetoException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import co.com.mercadolibre.mapper.IComunicacionMapper;
import co.com.mercadolibre.mapper.impl.ComunicacionMapper;
import co.com.mercadolibre.util.UtilidadesService;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "co.com.mercadolibre.dao")
public class DatasourceConfig {

	@Bean
	public DataSource datasource() throws PropertyVetoException {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase dataSource = builder.setType(EmbeddedDatabaseType.H2).addScript("sql-scripts/schema.sql")
				.addScript("sql-scripts/data.sql").build();

		return dataSource;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(@Qualifier("datasource") DataSource ds)
			throws PropertyVetoException {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(ds);
		entityManagerFactory.setPackagesToScan(new String[] { "co.com.mercadolibre.entities" });
		JpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter);
		return entityManagerFactory;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public IComunicacionMapper getIComunicacionMapper() {
		return new ComunicacionMapper(getUtilidadesService());
	}

	@Bean
	public UtilidadesService getUtilidadesService() {
		return new UtilidadesService();
	}

}