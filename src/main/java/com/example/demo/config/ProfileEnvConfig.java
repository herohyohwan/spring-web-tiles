package com.example.demo.config;

import com.example.demo.profile.CurrentProfile;
import com.example.demo.profile.PropertiesPath;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;

import javax.inject.Inject;


/**
 * ProfileEnvConfig
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
public class ProfileEnvConfig {

    /**
     * The Env.
     */
    @Inject
    Environment env;

    /**
     * Properties path properties path.
     *
     * @return the properties path
     */
    @Bean
    public PropertiesPath propertiesPath() {
        return new PropertiesPath(currentProfile());
    }


    /**
     * Properties factory bean properties factory bean.
     *
     * @return the properties factory bean
     */
    @Bean(name = "coreProperties")
    public PropertiesFactoryBean propertiesFactoryBean() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocations(
                new ClassPathResource(propertiesPath().getPath("db.properties"))
        );
        return propertiesFactoryBean;
    }

    /**
     * Current profile current profile.
     *
     * @return the current profile
     */
    @Bean
    public CurrentProfile currentProfile() {
        return new CurrentProfile(env);
    }

}
