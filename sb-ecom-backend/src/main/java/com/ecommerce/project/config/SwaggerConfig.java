package com.ecommerce.project.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        SecurityScheme bearerScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .description("JWT Bearer Token");

        SecurityRequirement bearerRequirement = new SecurityRequirement()
                .addList("Bearer Authentication");

        return new OpenAPI()
                .info(new Info()
                        .title("Spring Boot eCommerce APi")    //Custom heading or title at the top
                        .version("1.0")
                        .description("This is a spring boot project for ecommerce")
                        .license(new License().name("Apache 2.0").url("http://url.com"))
                        .contact(new Contact().name("Akshit Singh")
                                .email("akshit@gmail.com")
                                .url("https://github.com/AkshitShekhawat")))
                .externalDocs(new ExternalDocumentation()
                        .description("Project Documentation")
                        .url("https://github.com/AkshitShekhawat"))

                .components(new Components()
                        .addSecuritySchemes("Bearer Authentication", bearerScheme))
                .addSecurityItem(bearerRequirement);
    }
}



//First a fall we're defining a SecurityScheme and this SecurityScheme is being used for bearer token that will be used in
//swagger ui which means that there will be an authorised button that will be enabled in the swagger ui

//After we are defining the actual open api object for the swagger ui generation