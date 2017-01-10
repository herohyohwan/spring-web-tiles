package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * TestApplicationConfig
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
@Configuration
@Import({ RootApplicationConfig.class, WebApplicationConfig.class })
public class TestApplicationConfig {
}
