package com.myboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	//acccess localhost:8080/swagger-ui.html
	@Bean
	public Docket createRestApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.myboot.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	
	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder()
				.title("spring boot project")
				.description("for spring boot learning")
				.termsOfServiceUrl("http://hczboy.github.com")
				.version("1.0")
				.build();
	}
}
