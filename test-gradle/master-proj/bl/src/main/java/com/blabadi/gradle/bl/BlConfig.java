package com.blabadi.gradle.bl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.blabadi.gradle.dao.DaoConfig;

@Configuration
@ComponentScan({"com.blabadi.gradle.bl"})
@Import(DaoConfig.class)

public class BlConfig {

}
