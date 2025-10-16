package com.example.demo34.service;

import com.example.demo34.dao.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

// 스프링 시큐리티에게 사용자 정보를 담은 객체(UserDetails)를 전달하는 클래스

@Service
public class Demo34UserDetailsService implements UserDetailsService {
  @Autowired
  private MemberDao memberDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // 사용자가 로그인하면 스프링 시큐리티가 현재 메소드를 이용해 DB에서 사용자 정보를 읽어온다
  }
}
