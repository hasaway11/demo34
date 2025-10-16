package com.example.demo34.dao;

import com.example.demo34.entity.*;
import org.apache.ibatis.annotations.*;

@Mapper
public interface MemberDao {
  @Insert("insert into member values(#{username}, #{password}, #{email}, #{joinDay})")
  public int insert(Member member);

  @Select("select username, password, email, join_day as joinDay from member where username=#{username}")
  public Member findByUsername(String username);
}
