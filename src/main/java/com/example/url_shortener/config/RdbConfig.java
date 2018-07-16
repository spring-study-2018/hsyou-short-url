package com.example.url_shortener.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.annotation.WebServlet;

@Configuration
public class RdbConfig {

    @Value("${spring.h2.console.path}")
    private String h2URL;


//    @Beane
}
