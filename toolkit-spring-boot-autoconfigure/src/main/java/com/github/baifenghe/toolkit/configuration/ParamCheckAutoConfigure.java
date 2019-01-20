package com.github.baifenghe.toolkit.configuration;

import com.github.baifenghe.toolkit.aop.ParamsCheck4JsonAop;
import com.github.baifenghe.toolkit.aop.ParamsCheckAop;
import com.github.baifenghe.toolkit.filter.RequestCacheFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;


/**
 * @author bfh
 * @since 1.0.0
 */
@Configuration
public class ParamCheckAutoConfigure {

    @Bean
    ParamsCheckAop paramsCheckAop() {
        return new ParamsCheckAop();
    }

    @Bean
    ParamsCheck4JsonAop paramsCheck4JsonAop() {
        return new ParamsCheck4JsonAop();
    }

    @Bean
    public FilterRegistrationBean registrationCacheFilter() {
        FilterRegistrationBean<RequestCacheFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new RequestCacheFilter());
        List<String> urlList = new ArrayList<>();
        urlList.add("/*");
        registration.setUrlPatterns(urlList);
        registration.setName("RequestCacheFilter");
        registration.setOrder(1);
        return registration;
    }

}
