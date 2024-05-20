package com.prisonproject.main.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Prison Project Api")
                        .description("API for prison management")
                        .version("v1.0.0")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("Prison Project ApiDocumentation")
                        .url("http://example.com"));
    }
    @Bean
    public OpenApiCustomizer customiseOpenApi() {
        return openApi -> openApi.getPaths().keySet().removeIf(path ->
                !path.contains("/inmate/add") &&
                        !path.contains("/inmate/get") &&
                        !path.contains("/cell/add") &&
                        !path.contains("/crime/add") &&
                        !path.contains("/guard/add")
        );
    }
}
