package com.sao;

import org.springframework.boot.web.servlet.FilterRegistrationBean;

//todo
//@Configuration
public class FilterConfig {

//    @Bean
    public FilterRegistrationBean registerFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SkipFilter());
        registration.addUrlPatterns("/*");
        registration.setName("LogCostFilter");
        registration.setOrder(1);
        return registration;
    }

}