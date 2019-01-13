package com.github.baifenghe.toolkit.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 自定义返回体格式
 *
 * @author bfh
 * @since 1.0.0
 */
@Getter
@Setter
public class Result<T> {

    /**
     * 返回码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private T data;

}
