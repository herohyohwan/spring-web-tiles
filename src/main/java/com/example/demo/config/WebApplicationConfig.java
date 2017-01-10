package com.example.demo.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.accept.ContentNegotiationManagerFactoryBean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.UriComponentsBuilderMethodArgumentResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/**
 * WebApplicationConfig
 *
 * @author herohyohwan@gmail.com
 * @date 2017.01.09
 */
@EnableWebMvc
@ComponentScan(basePackages = "com.example.demo",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class))
public class WebApplicationConfig extends WebMvcConfigurerAdapter {


    /**
     * Add argument resolvers.
     *
     * @param argumentResolvers the argument resolvers
     */
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new UriComponentsBuilderMethodArgumentResolver());
    }

    /**
     * View resolver view resolver.
     *
     * @return the view resolver
     */
    @Bean()
    public ViewResolver viewResolver() {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();
        viewResolver.setOrder(0);
        viewResolver.setContentNegotiationManager(contentNegotiationManager());
        viewResolver.setDefaultViews(Lists.newArrayList(jsonView()));
        return viewResolver;
    }

    /**
     * Content negotiation manager content negotiation manager.
     *
     * @return the content negotiation manager
     */
    public ContentNegotiationManager contentNegotiationManager() {
        ContentNegotiationManagerFactoryBean factoryBean = new ContentNegotiationManagerFactoryBean();
        factoryBean.setDefaultContentType(MediaType.APPLICATION_JSON);
        factoryBean.setFavorPathExtension(false);
        factoryBean.setIgnoreAcceptHeader(true);
        factoryBean.addMediaType("json", MediaType.APPLICATION_JSON);
        return factoryBean.getObject();
    }


    /**
     * Json view view.
     *
     * @return the view
     */
    public View jsonView() {
        MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
        jsonView.setObjectMapper(objectMapper());
        jsonView.setExtractValueFromSingleKeyModel(true);
        return jsonView;
    }

    /**
     * Object mapper object mapper.
     *
     * @return the object mapper
     */
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        objectMapper.configure(MapperFeature.AUTO_DETECT_FIELDS, true);
        objectMapper.configure(MapperFeature.AUTO_DETECT_GETTERS, false);
        objectMapper.configure(MapperFeature.AUTO_DETECT_SETTERS, false);
        objectMapper.configure(MapperFeature.AUTO_DETECT_IS_GETTERS, false);
        VisibilityChecker visibilityChecker = objectMapper
                .getVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY);
        objectMapper.setVisibility(visibilityChecker);

        DateFormat dateFormat = new ISO8601DateFormat();
        dateFormat.setTimeZone(TimeZone.getDefault());
        objectMapper.setDateFormat(dateFormat);
        return objectMapper;
    }

}
