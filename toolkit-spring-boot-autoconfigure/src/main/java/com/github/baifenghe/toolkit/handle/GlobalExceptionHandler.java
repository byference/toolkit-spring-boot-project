package com.github.baifenghe.toolkit.handle;

import com.github.baifenghe.toolkit.common.constant.enums.BusinessEnum;
import com.github.baifenghe.toolkit.common.exception.BusinessException;
import com.github.baifenghe.toolkit.common.exception.IllegalParameterException;
import com.github.baifenghe.toolkit.common.util.Response;
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
    public ResponseEntity<Response> defaultExceptionHandler(Exception e) {

        log.error("globalExceptionHandler exception: ", e);
        Response message = null;
        if (e instanceof BindException) {
            BindException validException = (BindException) e;
            message = Response.build().code(BusinessEnum.ERROR.getCode()).message("参数校验异常："
                    + validException.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        if (e instanceof IllegalParameterException) {
            IllegalParameterException illegalParameterException = (IllegalParameterException) e;
            message = Response.build().code(illegalParameterException.getCode()).message("参数校验异常：" + illegalParameterException.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            message = Response.build().code(businessException.getCode()).message("业务异常：" + businessException.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }

        message = Response.build().code(BusinessEnum.ERROR.getCode()).message("系统异常：" + e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }
 

}
