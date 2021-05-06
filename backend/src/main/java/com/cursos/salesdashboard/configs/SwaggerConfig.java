package com.cursos.salesdashboard.configs;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig{
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cursos.salesdashboard.controllers"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfo(
				"API do projeto Spring Boot + React",
				"Esta API foi criada com base na Semana DevSuperior 3.0",
				"Versão 1.0",
				"",
				new Contact("Felipe Milana", "https://github.com/FelipeMilana", "felipe.milana97@gmail.com"),
				"Permitido para todos",
				"",
				Collections.emptyList());
	}
}
