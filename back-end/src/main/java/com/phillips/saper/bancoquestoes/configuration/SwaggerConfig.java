package com.phillips.saper.bancoquestoes.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(
                        new Components().addSecuritySchemes(BASIC_AUTH_SECURITY_SCHEME,
                                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
                .info(new Info()
                        .title("Banco de Questões")
                        .description("Sistema para cadastro de questões e geração de provas")
                        .version("v1.0")                             
                        .license(new License().name("License").url("https://github.com/git/git-scm.com/blob/main/MIT-LICENSE.txt"))
                );
    }

    public static final String BASIC_AUTH_SECURITY_SCHEME = "basicAuth";
}
