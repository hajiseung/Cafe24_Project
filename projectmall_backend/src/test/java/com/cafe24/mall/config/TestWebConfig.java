package com.cafe24.mall.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.cafe24.config.web.MessageConfig;
import com.cafe24.config.web.TestMVCConfig;

@Configuration
@EnableWebMvc
@ComponentScan({ "com.cafe24.mall.controller" })
@Import({ TestMVCConfig.class, MessageConfig.class })
public class TestWebConfig {

}
