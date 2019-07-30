package cl.diegojerez.previred.desafio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${application.name}")
	private String applicationName;

	@Value("${build.version}")
	private String buildVersion;

	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().apiInfo(getApiInfo());
	}

	private ApiInfo getApiInfo() {
		return new ApiInfo(applicationName, "Solucion Desafío 1: Periodos perdidos", buildVersion,
				"nivel 3", new Contact("Diego Jerez", "(+56) 958508377", "diegojerez32@gmail.com"),
				"", "", Lists.newArrayList(new ArrayList<>()));
	}

}