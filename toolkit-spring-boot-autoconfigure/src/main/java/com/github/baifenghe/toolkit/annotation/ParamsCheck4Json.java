package com.github.baifenghe.toolkit.annotation;

import java.lang.annotation.*;

/**
 * Json参数校验注解
 *
 * @author bfh
 * @since 2019/01/06
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamsCheck4Json {
    String params() default "";
}
