package com.myapp.configration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger 설정
 * 
 * @author chans
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	
    @Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("com.myapp.controller"))
                .paths(PathSelectors.any())
                .build()
                .useDefaultResponseMessages(false); //swagger에서 기본으로 세팅되는 response 메시지를 표시 하지 않음
    }
 
    //API 개요
    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("토이 프로젝트 쇼핑몰 API Document")
                .description("토이 프로젝트 쇼핑몰 API Document 입니다")
                .license("chans © 2020").version("1").build();
    }
}