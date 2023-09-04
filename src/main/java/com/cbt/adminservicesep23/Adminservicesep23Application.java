package com.cbt.adminservicesep23;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class Adminservicesep23Application {

    public static void main(String[] args) {


        new SpringApplicationBuilder()
                .profiles("dev")
                .sources(Adminservicesep23Application.class)
                .run(args);
    }

}
