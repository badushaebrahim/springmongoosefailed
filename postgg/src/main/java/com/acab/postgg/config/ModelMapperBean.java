package com.acab.postgg.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperBean {
    @Bean
public ModelMapper ModelMapperBean() {
        return new ModelMapper();
    }
}
