package com.github.baifenghe.tools.annotation;

import com.github.baifenghe.tools.configuration.TestAutoConfigure;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 测试注解
 *
 * @author wj
 * @since 2018/12/27
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({TestAutoConfigure.class})
public @interface EnableTest {
}
