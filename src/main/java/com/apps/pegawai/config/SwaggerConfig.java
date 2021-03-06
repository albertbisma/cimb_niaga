package com.apps.pegawai.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

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

	public Docket docket() {	
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.paths(Predicates.not(PathSelectors.regex("/error/*")))
                .paths(Predicates.not(PathSelectors.regex("/actuator")))
				.build()
				.apiInfo(apiInfo());
	}
	
	private ApiInfo apiInfo() {
        Contact contact = new Contact(
                "Albert Bisma Nugraha",
                "https://albertbisma.github.io",
                "albertbisma@ymail.com");
        return new ApiInfo(
                "Develop Rest API using SpringBoot",
                "Implementation Swagger on Rest Spring Boot",
                "Version 1.0.0",
                "",
                contact,
                "",
                "",
                Collections.emptyList());
    }
}

