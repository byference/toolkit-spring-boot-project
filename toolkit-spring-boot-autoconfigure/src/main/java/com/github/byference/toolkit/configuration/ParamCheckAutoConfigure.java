package com.github.byference.toolkit.configuration;

import com.github.byference.toolkit.aop.ParamsCheck4JsonAop;
import com.github.byference.toolkit.aop.ParamsCheckAop;
import com.github.byference.toolkit.filter.RequestCacheFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.ArrayList;
import java.util.List;


/**
 * 注入参数校验注解相关 Bean
 *
 * @see ParamsCheckAop
 * @see ParamsCheck4JsonAop
 * @see RequestCacheFilter
 *
 * @author bfh
 * @since 1.0.0
 */
@Configuration
@Import({ParamsCheckAop.class, ParamsCheck4JsonAop.class})
public class ParamCheckAutoConfigure {

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
