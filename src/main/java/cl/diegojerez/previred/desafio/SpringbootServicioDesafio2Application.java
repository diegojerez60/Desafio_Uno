package cl.diegojerez.previred.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class SpringbootServicioDesafio2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootServicioDesafio2Application.class, args);
	}

}
