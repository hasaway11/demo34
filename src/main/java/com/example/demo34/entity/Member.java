package com.example.demo34.entity;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
  // 필수입력. 소문자와 숫자 6~10글자
  @Pattern(regexp="^[a-z0-9]{6,10}$")
  @NotEmpty
  private String username;

  // 필수입력. 영숫자 6~10글자
  @Pattern(regexp="^[A-Za-z0-9]{6,10}$")
  @NotEmpty
  private String password;

  // 필수입력. 이메일 형식
  @Email
  @NotEmpty
  private String email;
  private LocalDate joinDay = LocalDate.now();
  private String role = "USER";
}
