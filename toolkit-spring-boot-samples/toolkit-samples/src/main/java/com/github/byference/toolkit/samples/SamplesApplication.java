package com.github.byference.toolkit.samples;

import com.github.byference.toolkit.annotation.EnableGlobalLog;
import com.github.byference.toolkit.annotation.EnableParamCheckHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author bfh
 */
@SpringBootApplication
@EnableParamCheckHandler
@EnableGlobalLog
public class SamplesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SamplesApplication.class, args);
    }

}

