package com.github.byference.toolkit.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.byference.toolkit.annotation.ParamsCheck4Json;
import com.github.byference.toolkit.common.constant.enums.IllegalParameterEnum;
import com.github.byference.toolkit.common.exception.IllegalParameterException;
import com.github.byference.toolkit.request.HttpServletRequestCacheWrapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * json参数校验切面
 *
 * @author bfh
 * @since 1.0.0
 */
@Aspect
@Slf4j
@Configuration
public class ParamsCheck4JsonAop {

    /**
     * 切点选择为 {@link ParamsCheck4Json} 注解
     */
    @Pointcut("@annotation(com.github.byference.toolkit.annotation.ParamsCheck4Json)")
    public void MyPointcut(){}


    /**
     * 配置前置通知，进行参数校验
     * @param joinPoint {@link JoinPoint}
     */
    @Before("MyPointcut()")
    public void doBeforeAccess(JoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletRequestCacheWrapper requestWrapper = (HttpServletRequestCacheWrapper) request;
        String json = new String(requestWrapper.getBody());
        log.info("json: {}", json);
        if (!StringUtils.isEmpty(json)) {
            JSONObject jsonObject = JSON.parseObject(json);

            MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
            Method method = methodSignature.getMethod();
            ParamsCheck4Json paramsCheck4Json = method.getAnnotation(ParamsCheck4Json.class);
            String params = paramsCheck4Json.params();
            if (!StringUtils.isEmpty(params)) {
                String[] split = params.split(",");
                for (String parameter : split) {
                    log.info("parameter: {}", parameter);
                    if (StringUtils.isEmpty(jsonObject.get(parameter))) {
                        throw new IllegalParameterException(parameter + " 不能为空", IllegalParameterEnum.PARAMS_CHECK_ERROR.getCode());
                    }
                }
            }
        }
    }

}

