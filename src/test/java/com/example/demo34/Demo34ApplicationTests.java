package com.example.demo34;

import com.example.demo34.dao.*;
import com.example.demo34.entity.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.*;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Demo34ApplicationTests {
  @Autowired
	private MemberDao memberDao;

  //@Test
  public void init() {
    assertNotNull(memberDao);
  }

  //@Test
  public void insertTest() {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String encodedPassword = passwordEncoder.encode("1234");
    Member m = new Member("summer", encodedPassword, "spring@naver.com", LocalDate.now());
    int result = memberDao.insert(m);
    assertEquals(1, result);
  }

  //@Test
  public void 비밀번호비교() {
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    String r1 = passwordEncoder.encode("1234");
    System.out.println(r1);
    System.out.println(passwordEncoder.matches("1234", r1));
  }
}


