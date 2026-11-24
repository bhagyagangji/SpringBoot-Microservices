package com.wipro.product.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfiguration {
	@Bean
    public OpenAPI productAPI() {

        return new OpenAPI()
            .info(new Info()
                .title("Product Service API")
                .description(
                    "REST APIs for Product Management"
                )
                .version("1.0"));
    }
}
