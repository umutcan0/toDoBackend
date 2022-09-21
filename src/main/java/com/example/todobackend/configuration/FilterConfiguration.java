package com.example.todobackend.configuration;

import ch.qos.logback.access.servlet.TeeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfiguration {

    @Bean
    public FilterRegistrationBean<TeeFilter> requestResponseFilter() {

        final FilterRegistrationBean<TeeFilter> filterRegBean = new FilterRegistrationBean<TeeFilter>();
        TeeFilter filter = new TeeFilter();
        filterRegBean.setFilter(filter);
        filterRegBean.addUrlPatterns("/auth/*");
        filterRegBean.setName("Request Response Filter");
        filterRegBean.setAsyncSupported(Boolean.TRUE);
        return filterRegBean;
    }

}