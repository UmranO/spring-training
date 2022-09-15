package com.cydeo.bean_annotation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RandomConfig {

    @Bean
    public String myString(){

        return new String ("Cydeo");
    }
    @Bean
    public Integer myInteger(){
        return 5;
    }

}
