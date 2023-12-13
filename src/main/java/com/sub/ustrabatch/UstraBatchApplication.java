package com.sub.ustrabatch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(scanBasePackages = {"com.sub"})
@Configuration
@EnableBatchProcessing
public class UstraBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(UstraBatchApplication.class, args);
    }

}
