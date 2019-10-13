package com.github.byference.toolkit.annotation;

import com.github.byference.toolkit.configuration.ParamCheckAutoConfigure;
import com.github.byference.toolkit.handle.GlobalExceptionHandler;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用参数校验注解并开启全局异常处理，
 * 参照 {@link GlobalExceptionHandler} 以及 {@link ParamCheckAutoConfigure}
 *
 * @author bfh
 * @since 1.0.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ParamCheckAutoConfigure.class, GlobalExceptionHandler.class})
public @interface EnableParamCheckHandler {
}
