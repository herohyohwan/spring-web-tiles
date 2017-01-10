package com.example.demo.service.auth;

import com.example.demo.service.auth.impl.DefaultAuthUserService;
import com.example.demo.service.auth.repository.AuthUserRepository;
import com.google.common.base.Preconditions;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.inject.Inject;

/**
 * AuthUserConfig
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
@Configuration
public class AuthUserConfig {


    /**
     * The Sql session factory.
     */
    @Inject
    private SqlSessionFactory sqlSessionFactory;

    /**
     * Auth user service auth user service.
     *
     * @return the auth user service
     */
    @Bean
    public AuthUserService authUserService() {
        return new DefaultAuthUserService(authUserRepository());
    }


    /**
     * Auth user repository auth user repository.
     *
     * @return the auth user repository
     */
    @Bean
    protected AuthUserRepository authUserRepository() {
        return createMapper(AuthUserRepository.class);
    }

    /**
     * Create mapper t.
     *
     * @param <T>         the type parameter
     * @param mapperClass the mapper class
     *
     * @return the t
     */
    private <T> T createMapper(Class<T> mapperClass) {
        Preconditions.checkNotNull(sqlSessionFactory);
        SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
        return sessionTemplate.getMapper(mapperClass);
    }
}
