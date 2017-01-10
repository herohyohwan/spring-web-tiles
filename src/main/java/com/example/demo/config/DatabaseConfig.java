package com.example.demo.config;

import com.example.demo.profile.CurrentProfile;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.flywaydb.core.Flyway;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.inject.Inject;
import javax.sql.DataSource;

/**
 * DatabaseConfig
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
@Configuration
public class DatabaseConfig {

    /**
     * The Jdbc driver.
     */
    @Value("#{coreProperties['jdbc.driverClassName']}")
    String jdbcDriver;

    /**
     * The Jdbc url.
     */
    @Value("#{coreProperties['jdbc.url']}")
    String jdbcUrl;

    /**
     * The Username.
     */
    @Value("#{coreProperties['jdbc.username']}")
    String username;

    /**
     * The Password.
     */
    @Value("#{coreProperties['jdbc.password']}")
    String password;


    /**
     * The Current profile.
     */
    @Inject
    CurrentProfile currentProfile;

    /**
     * Data source data source.
     *
     * @return the data source
     */
    @Bean(name = "dataSource")
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMaxActive(20);
        dataSource.setTestWhileIdle(true);
        dataSource.setTimeBetweenEvictionRunsMillis(720000);
        dataSource.setValidationQuery("select 1");
        return dataSource;
    }

    /**
     * Flyway flyway.
     *
     * @return the flyway
     */
    @Bean(name = "flyway", initMethod = "migrate")
    public Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource());
        flyway.setCleanOnValidationError(true);

        return flyway;
    }

    /**
     * Transction manager data source transaction manager.
     *
     * @return the data source transaction manager
     */
    @Bean
    public DataSourceTransactionManager transctionManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    /**
     * Sql session factory sql session factory.
     *
     * @return the sql session factory
     *
     * @throws Exception the exception
     */
    @Bean
    @DependsOn("flyway")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setTypeAliasesPackage("com.example.demo.service.auth.model");
        factoryBean.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
        return factoryBean.getObject();
    }

    /**
     * Jdbc template jdbc template.
     *
     * @return the jdbc template
     */
    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

}
