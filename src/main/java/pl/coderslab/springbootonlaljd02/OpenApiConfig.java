package pl.coderslab.springbootonlaljd02;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Springbootonlaljd02 Application API").description(
                                "This is a sample application with Spring Boot and OpenAPI")
                        .version("1.0.42"));
    }

    @Bean
    public GroupedOpenApi homeOpenApi() {
        return GroupedOpenApi
                .builder()
                .group("home")
                .packagesToScan("pl.coderslab.springbootonlaljd02.controller")
                .build();
    }

    @Bean
    public GroupedOpenApi remainingOpenApi() {
        return GroupedOpenApi
                .builder()
                .group("remaining")
                .packagesToScan("pl.coderslab.springbootonlaljd02.cartoon", "pl.coderslab.springbootonlaljd02.cinema")
                .build();
    }
}