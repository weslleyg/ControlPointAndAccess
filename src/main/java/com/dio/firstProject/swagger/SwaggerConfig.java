package com.dio.firstProject.swagger;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket apiAdmin() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("com.dio.firstProject")).paths(PathSelectors.ant("/**")).build()
        .apiInfo(apiInfo()).globalOperationParameters(
            Collections.singletonList(new ParameterBuilder().name("Authorization").description("Header para token JWT")
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build()));
  }

  @Bean
  public ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Api-Rest").description("Api primeiro desafio do bootcamp Santander")
        .version("0.0.1").license("Apache License Version 2.0")
        .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
        .contact(new Contact("Weslley", "https://github.com/weslleyg", "wesley.dipaulatorres@hotmail.com")).build();
  }
}
