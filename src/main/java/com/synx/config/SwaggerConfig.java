package com.synx.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  ApiInfo apiInfo() {
    Contact contact = new Contact("Koorye", "https://koorye.github.io", "a1311586225@gmail.com");
    return new ApiInfo(
        "Question and Answer API Document",
        "By Koorye",
        "V1.2.1 Alpha",
        "https://koorye.github.io",
        contact,
        "SYNX",
        "http://koorye.github.io",
        new ArrayList<>()
    );
  }

  @Bean
  public Docket userDocket(){
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .groupName("User")
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.synx.controller.user"))
        .build();
  }

  @Bean
  public Docket questionDocket(){
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .groupName("Question")
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.synx.controller.question"))
        .build();
  }

  @Bean
  public Docket answerDocket(){
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .groupName("Answer")
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.synx.controller.answer"))
        .build();
  }

  @Bean
  public Docket manageDocket(){
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .groupName("Manage")
        .select()
        .apis(RequestHandlerSelectors.basePackage("com.synx.controller.manage"))
        .build();
  }
}
