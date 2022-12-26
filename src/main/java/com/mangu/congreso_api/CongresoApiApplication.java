package com.mangu.congreso_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class CongresoApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(CongresoApiApplication.class, args);
  }

}
