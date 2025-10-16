package com.example.demo34.entity;

import lombok.*;

import java.time.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Member {
  private String username;
  private String password;
  private String email;
  private LocalDate joinDay;
}
