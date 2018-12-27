package com.github.baifenghe.tools.configuration;

import com.github.baifenghe.tools.aop.ParamsCheckAop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 测试自动注入
 *
 * @author bfh
 * @since 1.0.0
 */
@Configuration
public class ParamCheckAutoConfigure {

    @Bean
    ParamsCheckAop paramsCheckAop() {
        return new ParamsCheckAop();
    }

}
