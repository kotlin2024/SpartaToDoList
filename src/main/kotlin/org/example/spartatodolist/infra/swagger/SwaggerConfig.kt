package org.example.spartatodolist.infra.swagger

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Bean
    fun openAPI(): OpenAPI = OpenAPI()
        .components(Components())
        .info(
            Info()
                .title("TODOLIST작성을 위한 API ")
                .description("Course API schema by HJP")
                .version("1.0.0")
        )
}