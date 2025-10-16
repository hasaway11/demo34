package com.example.demo34.service;

import com.example.demo34.dao.*;
import com.example.demo34.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;

import java.time.*;

@Service
public class MemberService {
  @Autowired
  private MemberDao memberDao;
  @Autowired
  private PasswordEncoder encoder;

  public void join(Member member) {
    String encodedPassword = encoder.encode(member.getPassword());
    member.setPassword(encodedPassword);
    member.setJoinDay(LocalDate.now());
    memberDao.insert(member);
  }
}
