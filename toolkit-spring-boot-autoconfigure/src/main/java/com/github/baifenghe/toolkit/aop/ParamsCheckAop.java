package com.github.baifenghe.toolkit.aop;

import com.github.baifenghe.toolkit.annotation.ParamsCheck;
import com.github.baifenghe.toolkit.common.constant.enums.IllegalParameterEnum;
import com.github.baifenghe.toolkit.common.exception.IllegalParameterException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
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
public class ParamsCheckAop {

    @Pointcut("@annotation(com.github.baifenghe.toolkit.annotation.ParamsCheck)")
    public void MyMethod(){}

    @Before("MyMethod()")
    public void doAfterReturning(JoinPoint joinPoint) {

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
