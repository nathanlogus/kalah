package com.cycleon.kalah.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
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
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {

        ApiInfo apiInfo = new ApiInfoBuilder()
                .title ("Kalah REST Service")
                .description ("This is the backend application for Kalah")
                .license("MIT")
                .licenseUrl("https://opensource.org/licenses/MIT")
                .version("1.0.0")
                .contact(new Contact("Nathan Ribeiro","https://github.com/nathanlogus", "nathanpirral@gmail.com"))
                .build();

        return apiInfo;
    }
}
