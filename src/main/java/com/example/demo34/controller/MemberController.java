package com.example.demo34.controller;

import com.example.demo34.entity.*;
import com.example.demo34.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.access.prepost.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class MemberController {
  @Autowired
  private MemberService memberService;

  @GetMapping("/")
  public ModelAndView index() {
    return new ModelAndView("/index");
  }

  // 로그인 여부 확인 : PreAuthorize('isAuthenticated()'), PreAuthorize('isAnonymous()')
  // 비로그인만 접근 가능하게 설정. 로그인 사용자가 접근하면 403이 발생
  @PreAuthorize("isAnonymous()")
  @GetMapping("/member/join")
  public void join() {}

  @PreAuthorize("isAnonymous()")
  @PostMapping("/member/join")
  public ModelAndView join(@ModelAttribute Member member) {
    memberService.join(member);
    return new ModelAndView("redirect:/member/login");
  }

  @PreAuthorize("isAnonymous()")
  @GetMapping("/member/login")
  public void login() {}
}
