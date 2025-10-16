package com.example.demo34;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;

@SpringBootApplication
public class Demo34Application {
	public static void main(String[] args) {
		SpringApplication.run(Demo34Application.class, args);
	}

  // @Component vs @Bean
  // ApplicationContext : 스프링이 대표하는 클래스(빈을 등록, 관리, 주입)
  // @Component는 스프링이 객체를 생성해 ApplicationContext에 등록
  // @Bean은 개발자가 객체를 생성해 ApplicationContext에 등록
  // @Mapper는 마이바티스가 객체를 생성해  ApplicationContext에 등록
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
