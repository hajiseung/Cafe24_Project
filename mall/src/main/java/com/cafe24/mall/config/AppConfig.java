package com.cafe24.mall.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import com.cafe24.config.app.DBConfig;
import com.cafe24.config.app.MyBatisConfig;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan({ "com.cafe24.mall.service"})
@Import({ DBConfig.class, MyBatisConfig.class })
public class AppConfig {
}
