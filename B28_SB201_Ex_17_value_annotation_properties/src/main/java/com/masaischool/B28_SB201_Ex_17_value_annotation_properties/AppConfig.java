package com.masaischool.B28_SB201_Ex_17_value_annotation_properties;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.masaischool.B28_SB201_Ex_17_value_annotation_properties"})
@PropertySource("a1.properties")
public class AppConfig {

}
