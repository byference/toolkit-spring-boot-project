package com.github.byference.toolkit.common.model;

import lombok.Builder;
import lombok.Getter;

/**
 * @author bfh
 * @since 1.0.0
 */
@Builder
@Getter
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
