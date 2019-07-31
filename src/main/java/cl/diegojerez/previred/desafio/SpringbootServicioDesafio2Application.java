package cl.diegojerez.previred.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableCircuitBreaker
@SpringBootApplication
@ComponentScan("cl.diegojerez.previred.*")
@EnableWebMvc
public class SpringbootServicioDesafio2Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioDesafio2Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootServicioDesafio2Application.class);
	}

	
}
