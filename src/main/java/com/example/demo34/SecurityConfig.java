package com.example.demo34;

// 스프링 시큐리티 설정

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.security.access.prepost.*;
import org.springframework.security.config.annotation.method.configuration.*;
import org.springframework.security.config.annotation.web.builders.*;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;
import org.springframework.security.web.*;

// 스프링 시큐리티는
// 인증 : 신원확인(일반적으로 로그인) -> 상태코드 401
//       http는 사용자 인증만 수행 -> https는 사용자와 서버가 상호 인증한다(서버의 공인인증서를 이용)
// 인가 : 인증된 사용자의 권한 확인 -> 상태코드 403


// 어노테이션을 활성화해서 어노테이션으로 통제하겠다
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
// 스프링 시큐리티 설정이다
@EnableWebSecurity
// 이 클래스는 설정파일이다. 읽어가라
@Configuration
public class SecurityConfig {
  @Autowired
  private PasswordEncoder encoder;

  // 스프링 시큐리티 필터 체인을 커스터마이즈해서 등록하는 메소드
  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // csrf : 타임리프 위변조를 잡아내는 기술 -> 일단 꺼놓자
    http.csrf(config->config.disable());
    // 로그인 페이지와 로그인 처리 주소를 지정(로그인 처리는 SS가 담당. 주소만 지정)
    http.formLogin(config->config.loginPage("/member/login").loginProcessingUrl("/member/login"));
    // 로그아웃을 처리할 주소 지정
    http.logout(config->config.logoutUrl("/member/logout").logoutSuccessUrl("/"));
    return http.build();
  }
}

// 서버에서 실행되는 자바 표준 : Servlet
// 스프링은 Servlet 기반의 프레임워크(스프링과 서블릿 기술을 연결해주는 서블릿 : DispatcherServlet)
// Filter : 서블릿 기술에서 서블릿 앞에서 실행되는 클래스
// - 필터를 사용하는 대표적인 예는 보안기능이다
// - 스프링 시큐리티는 10여개의 필터를 이용해서 각종 보안처리를 한다(FilterChain)











