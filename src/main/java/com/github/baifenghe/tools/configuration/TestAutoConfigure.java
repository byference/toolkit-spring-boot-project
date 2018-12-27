package com.github.baifenghe.tools.configuration;

import com.github.baifenghe.tools.util.TestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 测试自动注入
 *
 * @author wj
 * @since 2018/12/27
 */
@Configuration
//@ConditionalOnClass(TestService.class)
public class TestAutoConfigure {

    @Bean
        //@ConditionalOnMissingBean
    TestService testService() {
        return new TestService();
    }

}
