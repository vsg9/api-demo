package com.assignment.apidemo.configuration;

import com.assignment.apidemo.exception.ApiErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebErrorConfig {

    @Bean
    public ErrorAttributes errorAttributes() {
        return new ApiErrorAttributes();
    }
}
