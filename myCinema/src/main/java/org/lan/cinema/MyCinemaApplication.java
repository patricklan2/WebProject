package org.lan.cinema;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@MapperScan("org.lan.cinema.mapper")
public class MyCinemaApplication {

    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(MyCinemaApplication.class, args);
    }

}
