package com.example.usetestsdk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pers.wangying.testsdk.TestSdk;

@SpringBootApplication
public class UseTestSdkApplication {

    public static void main(String[] args) {
        SpringApplication.run(UseTestSdkApplication.class, args);
        TestSdk testSdk = new TestSdk();
        testSdk.greeting();
    }

}
