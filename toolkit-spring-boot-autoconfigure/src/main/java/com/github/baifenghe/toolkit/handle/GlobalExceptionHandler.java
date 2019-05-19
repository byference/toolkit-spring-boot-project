package com.github.baifenghe.toolkit.handle;

import com.github.baifenghe.toolkit.common.constant.enums.BusinessEnum;
import com.github.baifenghe.toolkit.common.exception.BusinessException;
import com.github.baifenghe.toolkit.common.exception.IllegalParameterException;
import com.github.baifenghe.toolkit.common.util.ResponseHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

/**
 * 全局异常处理
 *
 * @author bfh
 * @since 1.0.0
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {


    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseEntity bindExceptionHandler(Exception e) {

        BindException validException = (BindException) e;
        return ResponseHelper.status(HttpStatus.BAD_REQUEST).body(BusinessEnum.ERROR.getCode(),
                "参数校验异常：" + validException.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
    }


    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResponseEntity httpMessageNotReadableExceptionHandler(Exception e) {

        HttpMessageNotReadableException httpMessageNotReadableException = (HttpMessageNotReadableException) e;
        String messageSegment = Optional.ofNullable(httpMessageNotReadableException.getMessage())
                .map(m -> m.split(":")[0])
                .orElse("Required request body is missing");
        return ResponseHelper.status(HttpStatus.BAD_REQUEST).body(BusinessEnum.ERROR.getCode(),
                "参数校验异常：" + messageSegment);
    }


    @ExceptionHandler(IllegalParameterException.class)
    @ResponseBody
    public ResponseEntity illegalParameterExceptionHandler(Exception e) {

        IllegalParameterException illegalParameterException = (IllegalParameterException) e;
        return ResponseHelper.status(HttpStatus.BAD_REQUEST).body(illegalParameterException.getCode(),
                "参数校验异常：" + illegalParameterException.getMessage());
    }


    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResponseEntity businessExceptionExceptionHandler(Exception e) {

        BusinessException businessException = (BusinessException) e;
        return ResponseHelper.status(HttpStatus.INTERNAL_SERVER_ERROR).body(businessException.getCode(),
                "业务异常：" + businessException.getMessage());
    }




    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity defaultExceptionHandler(Exception e) {

        return ResponseHelper.status(HttpStatus.INTERNAL_SERVER_ERROR).body(BusinessEnum.ERROR.getCode(),
                "系统异常：" + e.getMessage());
    }

}
