package org.example.pagoyaeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class PagoyaEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PagoyaEurekaServerApplication.class, args);
    }

}
