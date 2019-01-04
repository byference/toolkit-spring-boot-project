package com.github.baifenghe.tools.common.util;

import com.alibaba.fastjson.JSON;
import com.github.baifenghe.tools.common.constant.CommonConst;
import com.github.baifenghe.tools.common.entity.Result;

import java.io.Serializable;

/**
 * 自定义返回体工具类
 *
 * @author bfh
 * @since 1.0.0
 */
public class R implements Serializable {

    private static final long serialVersionUID = 1L;

    public static<T> String success(String msg, T data) {

        Result<T> info = new Result<>();
        info.setCode(CommonConst.SUCCESS);
        info.setMessage(msg);
        info.setData(data);
        return JSON.toJSONString(info);

    }

    public static<T> String fail(Integer code, String msg, T data) {

        Result<T> info = new Result<>();
        info.setCode(code);
        info.setMessage(msg);
        info.setData(data);
        return JSON.toJSONString(info);

    }

}
