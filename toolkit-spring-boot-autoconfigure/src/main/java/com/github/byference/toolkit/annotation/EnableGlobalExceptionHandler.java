package com.github.byference.toolkit.annotation;

import com.github.byference.toolkit.handle.GlobalExceptionHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启自定义全局异常处理
 *
 * @author bfh
 * @since 1.0.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({GlobalExceptionHandler.class})
public @interface EnableGlobalExceptionHandler {
}
