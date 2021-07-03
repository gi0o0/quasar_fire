package co.com.mercadolibre.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import co.com.mercadolibre.mapper.IComunicacionMapper;
import co.com.mercadolibre.mapper.impl.ComunicacionMapper;
import co.com.mercadolibre.util.UtilidadesService;

@Configuration
@EnableTransactionManagement

public class DatasourceConfig {

	@Bean
	public IComunicacionMapper getIComunicacionMapper() {
		return new ComunicacionMapper(getUtilidadesService());
	}

	@Bean
	public UtilidadesService getUtilidadesService() {
		return new UtilidadesService();
	}

}