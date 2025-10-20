package com.example.demo34.service;

import com.example.demo34.dao.*;
import com.example.demo34.entity.*;
import jakarta.validation.constraints.*;
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
    memberDao.insert(member);
  }

  // 비밀번호는 암호화되어 있다. 비밀번호가 맞는 지 확인은 개발자가 아닌 "passwordEncoder"가 수행해야 한다
  public boolean checkPassword(String 암호화_안된_비밀번호, String loginId) {
    Member member = memberDao.findByUsername(loginId);
    String 암호화된_비밀번호 = member.getPassword();
    return encoder.matches(암호화_안된_비밀번호, 암호화된_비밀번호);
  }

  public Member readme(String loginId) {
    return memberDao.findByUsername(loginId);
  }
}
