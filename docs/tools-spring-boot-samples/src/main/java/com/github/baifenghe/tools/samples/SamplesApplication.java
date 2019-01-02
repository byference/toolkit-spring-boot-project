package com.github.baifenghe.tools.samples;

import com.github.baifenghe.tools.annotation.EnableParamCheckHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableParamCheckHandler
public class SamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SamplesApplication.class, args);
    }

}

