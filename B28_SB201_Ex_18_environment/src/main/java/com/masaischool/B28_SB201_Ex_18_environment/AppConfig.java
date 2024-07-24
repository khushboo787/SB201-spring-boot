package com.masaischool.B28_SB201_Ex_18_environment;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.masaischool.B28_SB201_Ex_18_environment"})
@PropertySource("a1.properties")
public class AppConfig {

}
