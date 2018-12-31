package com.github.baifenghe.tools.annotation;

import com.github.baifenghe.tools.configuration.ParamCheckAutoConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用参数校验注解
 *
 * @author bfh
 * @since 1.0.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ParamCheckAutoConfigure.class})
public @interface EnableParamCheck {
}
