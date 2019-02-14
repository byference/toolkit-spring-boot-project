package com.github.baifenghe.toolkit.samples;

import com.github.baifenghe.toolkit.annotation.EnableParamCheckHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author bfh
 */
@SpringBootApplication
@EnableParamCheckHandler
public class SamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SamplesApplication.class, args);
    }

}

