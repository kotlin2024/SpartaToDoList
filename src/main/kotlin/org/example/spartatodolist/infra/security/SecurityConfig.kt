package org.example.spartatodolist.infra.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity // 통신할때 관련 보안 기능을 키기 위해서 설정
class SecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .httpBasic{ it.disable() } //disable로 필요없는 필터를 제외시킴
            .formLogin { it.disable() }
            .csrf{ it.disable() }
            .build()
    }
}