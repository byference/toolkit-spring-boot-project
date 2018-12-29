package com.github.baifenghe.tools.annotation;

import com.github.baifenghe.tools.configuration.TestAutoConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 测试注解
 *
 * @author bfh
 * @since 1.0.0
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({TestAutoConfigure.class})
public @interface EnableTest {
}
