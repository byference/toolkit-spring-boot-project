package com.github.byference.toolkit.aop;

import com.github.byference.toolkit.annotation.ParamsCheck;
import com.github.byference.toolkit.common.constant.enums.IllegalParameterEnum;
import com.github.byference.toolkit.common.exception.IllegalParameterException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * 非json参数校验切面
 *
 * @author bfh
 * @since 1.0.0
 */
@Aspect
@Configuration
public class ParamsCheckAop {


    /**
     * 切点选择为 {@link ParamsCheck} 注解
     */
    @Pointcut("@annotation(com.github.byference.toolkit.annotation.ParamsCheck)")
    public void MyPointcut(){}

    /**
     * 配置前置通知，进行参数校验
     * @param joinPoint {@link JoinPoint}
     */
    @Before("MyPointcut()")
    public void doBeforeAccess(JoinPoint joinPoint) {

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        assert sra != null;
        HttpServletRequest request = sra.getRequest();

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        ParamsCheck paramsCheck = method.getAnnotation(ParamsCheck.class);
        String params = paramsCheck.params();
        if (!StringUtils.isEmpty(params)) {
            String[] split = params.split(",");
            for (String parameter : split) {
                if (StringUtils.isEmpty(request.getParameter(parameter))) {
                    throw new IllegalParameterException(parameter + " 不能为空", IllegalParameterEnum.PARAMS_CHECK_ERROR.getCode());
                }
            }
        }
    }

}
