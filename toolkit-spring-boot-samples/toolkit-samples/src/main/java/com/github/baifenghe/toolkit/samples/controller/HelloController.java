package com.github.baifenghe.toolkit.samples.controller;

import com.github.baifenghe.toolkit.annotation.ParamsCheck;
import com.github.baifenghe.toolkit.annotation.ParamsCheck4Json;
import com.github.baifenghe.toolkit.common.util.ResponseHelper;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity test(@RequestBody String name) {
        String body = "ParamsCheck4Json操作成功！name is " + name;
        return ResponseHelper.ok().body(body);
    }

    @RequestMapping("hello")
    @ParamsCheck(params = "name")
    public ResponseEntity hello(String name) {
        String body = "ParamsCheck操作成功！name is " + name;
        return ResponseHelper.ok().body(body);
    }
}
