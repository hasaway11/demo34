package com.example.demo34.controller;

import com.example.demo34.entity.*;
import com.example.demo34.service.*;
import jakarta.servlet.http.*;
import jakarta.validation.*;
import jakarta.validation.constraints.*;
import org.apache.tomcat.util.net.openssl.ciphers.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;
import org.springframework.validation.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.security.*;

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

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/member/check-password")
  public ModelAndView checkPassword(HttpSession session) {
    // 이미 비밀번호확인했어 -> 그러면 내정보로 가
    if(session.getAttribute("checkPassword")!=null)
      return new ModelAndView("redirect:/member/readme");
    return new ModelAndView("member/check-password");
  }

  @PreAuthorize("isAuthenticated()")
  @PostMapping("/member/check-password")
  public ModelAndView checkPassword(@RequestParam @NotEmpty String password, Principal principal, HttpSession session) {
    // 비밀번호 확인 -> 실패하면 확인화면으로 이동 -> 성공하면 성공정보는 세션에 저장 후 readme로 이동
    boolean checkSuccess = memberService.checkPassword(password, principal.getName());
    if(checkSuccess==false)
      return new ModelAndView("redirect:/member/check-password?error");
    session.setAttribute("checkPassword", true);
    return new ModelAndView("redirect:/member/readme");
  }

  @PreAuthorize("isAuthenticated()")
  @GetMapping("/member/readme")
  public ModelAndView readme(HttpSession session, Principal principal) {
    // 내정보본다고 -> 비밀번호 확인했어? -> 안했으면 확인부터 해
    if(session.getAttribute("checkPassword")==null)
      return new ModelAndView("redirect:/member/check-password");
    Member member = memberService.readme(principal.getName());
    return new ModelAndView("member/readme").addObject("member", member);
  }
}









