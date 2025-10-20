package com.example.demo34.controller;

import com.example.demo34.entity.*;
import com.example.demo34.service.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

// 스프링 검증 기능 활성화
// @Validated가 없으면 스프링이 아닌 자바 표준 검증을 사용한다 -> 반복 코드들이 발생....
@Validated
@Controller
public class MemberController {
  @Autowired
  private MemberService memberService;

  @GetMapping("/")
  public ModelAndView index() {
    return new ModelAndView("index");
  }

  // 로그인 여부 확인 : PreAuthorize('isAuthenticated()'), PreAuthorize('isAnonymous()')
  // 비로그인만 접근 가능하게 설정. 로그인 사용자가 접근하면 403이 발생
  @PreAuthorize("isAnonymous()")
  @GetMapping("/member/join")
  public void join() {}

  @PreAuthorize("isAnonymous()")
  @PostMapping("/member/join")
  public ModelAndView join(@ModelAttribute @Valid Member member, BindingResult br) {
    // @Valid로 검증 수행 -> 검증에 실패한 경우 실패 메시지가 BindingResult 안에 담긴다
    memberService.join(member);
    return new ModelAndView("redirect:/member/login");
  }

  // 스프링은 url이 아니라 예외에 반응하는 컨트롤러를 지원한다
  // Hello.java ==== 컴파일 ===> Hello.class
  @ExceptionHandler(ConstraintViolationException.class)
  public ModelAndView constraintViolationException() {
    return new ModelAndView("error").addObject("msg", "작업을 수행할 수 없습니다");
  }

  @PreAuthorize("isAnonymous()")
  @GetMapping("/member/login")
  public void login() {}

  // get 비밀번호 확인


  // post 비밀번호 확인 처리

  // get 내정보 보기 출력
}









