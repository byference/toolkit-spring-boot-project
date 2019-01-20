package com.github.baifenghe.toolkit.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.baifenghe.toolkit.annotation.ParamsCheck4Json;
import com.github.baifenghe.toolkit.common.constant.enums.BusinessEnum;
import com.github.baifenghe.toolkit.common.exception.BusinessException;
import com.github.baifenghe.toolkit.request.HttpServletRequestCacheWrapper;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 参数校验切面
 * 可以使用拦截器来做，目前还不支持json格式的参数校验
 *
 * @author bfh
 * @since 1.0.0
 */
@Aspect
@Slf4j
public class ParamsCheck4JsonAop {

    @Pointcut("@annotation(com.github.baifenghe.toolkit.annotation.ParamsCheck4Json)")
    public void MyMethod(){}

    @Before("MyMethod()")
    public void doAfterReturning(JoinPoint joinPoint) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletRequestCacheWrapper requestWrapper = (HttpServletRequestCacheWrapper) request;
        String json = new String(requestWrapper.getBody());
        log.info("json: {}", json);
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
                    throw new BusinessException(parameter + " 不能为空", BusinessEnum.PARAMS_CHECK_ERROR.getCode());
                }
            }
        }
    }

}

