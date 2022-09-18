package com.cydeo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages ="com.cydeo")  You can give as one package  you can list as below
@ComponentScan(basePackages ={"com.cydeo.proxy","com.cydeo.repository","com.cydeo.service"})
public class CommentConfig {
}
