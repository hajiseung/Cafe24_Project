package com.cafe24.mall.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cafe24.config.web.MVCConfig;
import com.cafe24.config.web.MessageConfig;
import com.cafe24.config.web.SecurityConfig;
import com.cafe24.config.web.SwaggerConfig;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.cafe24.mall.controller", "com.cafe24.mall.exception" })
@Import({ MVCConfig.class, SwaggerConfig.class, SecurityConfig.class, MessageConfig.class })
public class WebConfig {
}