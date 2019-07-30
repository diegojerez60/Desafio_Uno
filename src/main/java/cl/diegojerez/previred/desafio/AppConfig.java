package cl.diegojerez.previred.desafio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author diegojerez32@@gmail.com
 *
 */
@Configuration
public class AppConfig {
	
	/**
	 * Registro de cliente rest Template, utilizado para obtener los datos del servicio
	 * Generador Datos Desafio
	 * 
	 * @return
	 */
	@Bean("clienteRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}
