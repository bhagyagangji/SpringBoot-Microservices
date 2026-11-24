package com.wipro.coupon.congiguration;

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
                .title("Coupon Service API")
                .description(
                    "REST APIs for Coupon Management"
                )
                .version("1.0"));
    }
}
