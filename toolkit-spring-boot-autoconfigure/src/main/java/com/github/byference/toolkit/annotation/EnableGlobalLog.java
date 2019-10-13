package com.github.byference.toolkit.annotation;

import com.github.byference.toolkit.aop.LoggerAop;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用全局controller日志处理
 *
 * @author bfh
 * @since 2019/02/17
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({LoggerAop.class})
public @interface EnableGlobalLog {
}
