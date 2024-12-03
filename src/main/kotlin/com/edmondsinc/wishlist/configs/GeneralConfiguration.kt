package com.edmondsinc.wishlist.configs

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class GeneralConfiguration {


    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Wishlist API")
                    .version("1.0")
                    .description("API documentation for the Wishlist application")
            )
    }
}