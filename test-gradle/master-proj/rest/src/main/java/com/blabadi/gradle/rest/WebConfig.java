package com.blabadi.gradle.rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.blabadi.gradle.bl.BlConfig;

@Configuration
@EnableWebMvc
@Import(BlConfig.class)
@ComponentScan(basePackages = {"com.blabadi.gradle.rest"})
public class WebConfig {
}
