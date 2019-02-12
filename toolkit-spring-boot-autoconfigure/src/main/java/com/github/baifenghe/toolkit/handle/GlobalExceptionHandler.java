package com.github.baifenghe.toolkit.handle;

import com.github.baifenghe.toolkit.common.constant.enums.BusinessEnum;
import com.github.baifenghe.toolkit.common.exception.BusinessException;
import com.github.baifenghe.toolkit.common.exception.IllegalParameterException;
import com.github.baifenghe.toolkit.common.util.ResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity defaultExceptionHandler(Exception e) {

        log.error("globalExceptionHandler exception: ", e);

        if (e instanceof BindException) {
            BindException validException = (BindException) e;
            return ResponseHelper.status(HttpStatus.BAD_REQUEST).body(BusinessEnum.ERROR.getCode(),
                    "参数校验异常：" + validException.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        }
        if (e instanceof IllegalParameterException) {
            IllegalParameterException illegalParameterException = (IllegalParameterException) e;
            return ResponseHelper.status(HttpStatus.BAD_REQUEST).body(illegalParameterException.getCode(),
                    "参数校验异常：" + illegalParameterException.getMessage());
        }
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            return ResponseHelper.status(HttpStatus.INTERNAL_SERVER_ERROR).body(businessException.getCode(),
                    "业务异常：" + businessException.getMessage());
        }

        return ResponseHelper.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BusinessEnum.ERROR.getCode(),
                "系统异常：" + e.getMessage());
    }
 

}
