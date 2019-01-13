package com.github.baifenghe.toolkit.handle;

import com.github.baifenghe.toolkit.common.constant.enums.BusinessEnum;
import com.github.baifenghe.toolkit.common.exception.BusinessException;
import com.github.baifenghe.toolkit.common.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author bfh
 * @since 1.0.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String defaultExceptionHandler(Exception e) {

        log.error("GlobalExceptionHandler#Exception: ", e);
        if (e instanceof BindException) {
            BindException validException = (BindException) e;
            return R.fail(BusinessEnum.ERROR.getCode(), "参数校验异常："
                    + validException.getBindingResult().getFieldErrors().get(0).getDefaultMessage(), null);
        }
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            return R.fail(businessException.getCode(), businessException.getMessage(), null);
        }
        return R.fail(BusinessEnum.ERROR.getCode(), "系统异常：" + e, null);

    }
 

}
