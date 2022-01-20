package com.beilie.test;

import com.beilie.gaohr.contract.GPService;
import com.beilie.platform.es.controller.nosession.NoSession_LoginController;
import com.beilie.platform.es.service.ESUE01Service;
import io.protostuff.GraphProtostuffOutput;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.beilie.core.logging.Logger;
import com.beilie.core.logging.LoggerFactory;
import com.beilie.spring.SpringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(clients = {
        ESUE01Service.class,
        GPService.class,
        NoSession_LoginController.class
})
public class TestServer {
    public static ConfigurableApplicationContext context;
    private static final Logger LOGGER = LoggerFactory.getLogger(TestServer.class);

    public static void main(String[] args) {
        context = SpringApplication.run(TestServer.class, args);
        Random random = new Random(System.currentTimeMillis());
        List<String> types = Arrays.asList("ESTS0001", "ESTS0002", "ESTS0003");
        while (true) {
            LOGGER.begin().headerType(types.get(random.nextInt(3)))
                    .info("测试");
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
            }
        }
    }

    @Bean
    public SpringUtils getContext() {
        return new SpringUtils();
    }
}
