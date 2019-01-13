package com.github.baifenghe.toolkit.annotation;

import com.github.baifenghe.toolkit.configuration.ParamCheckAutoConfigure;
import com.github.baifenghe.toolkit.handle.GlobalExceptionHandler;
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
