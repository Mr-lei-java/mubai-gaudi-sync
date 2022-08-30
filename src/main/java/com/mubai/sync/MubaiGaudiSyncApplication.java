package com.mubai.sync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author leitengfei
 */
@SpringBootApplication
@EnableScheduling
public class MubaiGaudiSyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(MubaiGaudiSyncApplication.class, args);
    }

}
