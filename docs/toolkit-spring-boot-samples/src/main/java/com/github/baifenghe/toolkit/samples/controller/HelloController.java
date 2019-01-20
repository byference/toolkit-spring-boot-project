package com.github.baifenghe.toolkit.samples.controller;

import com.github.baifenghe.toolkit.annotation.ParamsCheck;
import com.github.baifenghe.toolkit.annotation.ParamsCheck4Json;
import com.github.baifenghe.toolkit.common.util.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author bfh
 * @since 2018/12/31
 */
@RestController
public class HelloController {

    @RequestMapping("json")
    @ParamsCheck4Json(params = "name")
    public String test(@RequestBody String name) {
        return R.success("ParamsCheck4Json操作成功!", name);
    }

    @RequestMapping("hello")
    @ParamsCheck(params = "name")
    public String hello(String name) {
        return R.success("ParamsCheck操作成功!", name);
    }
}
