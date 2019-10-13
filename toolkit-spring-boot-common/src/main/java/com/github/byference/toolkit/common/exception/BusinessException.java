package com.github.byference.toolkit.common.exception;

import com.github.byference.toolkit.common.constant.BusinessEnumInterface;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 业务异常类
 *
 * @author bfh
 * @since 1.0.0
 */
@Getter
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    /**
     * 自定义错误码
     */
    private int code;

    public BusinessException() {}

    public BusinessException(BusinessEnumInterface businessEnumInterface) {
        super(businessEnumInterface.desc());
        this.code = businessEnumInterface.code();
    }

    public BusinessException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }

}
