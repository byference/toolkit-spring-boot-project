package com.github.byference.toolkit.common.exception;

import com.github.byference.toolkit.common.constant.enums.IllegalParameterEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 非法参数异常
 *
 * @author bfh
 * @since 1.0.0
 */
@Getter
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class IllegalParameterException extends RuntimeException {

    private static final long serialVersionUID = 8185235148785754962L;

    /**
     * 自定义错误码
     */
    private int code;

    public IllegalParameterException() {}

    public IllegalParameterException(IllegalParameterEnum illegalParameterEnum) {
        super(illegalParameterEnum.getDesc());
        this.code = illegalParameterEnum.getCode();
    }

    public IllegalParameterException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }

}
