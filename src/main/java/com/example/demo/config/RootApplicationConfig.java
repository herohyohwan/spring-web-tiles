package com.example.demo.config;

import com.example.demo.profile.CurrentProfile;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

/**
 * RootApplicationConfig
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
@Import({ProfileEnvConfig.class})
@ComponentScan(basePackages = "com.example.demo.config",
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class))
public class RootApplicationConfig {

    /**
     * The Profile.
     */
    @Inject
    CurrentProfile profile;
}
