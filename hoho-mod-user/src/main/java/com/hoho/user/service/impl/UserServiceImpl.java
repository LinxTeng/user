/*
 * Copyright (c) 2014-2015, Yunnex and/or its affiliates. All rights reserved. Use, Copy is subject
 * to authorized license.
 */
package com.hoho.user.service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import com.hoho.user.dao.UserMapper;
import com.hoho.user.dto.UserDto;
import com.hoho.user.service.UserService;



/**
 * User Service实现
 * 
 * @author linxiang
 * @date 2017-04-17
 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private UserMapper userMapper;

  @Override
  public UserDto getUseJdbc(Long id) {
    UserDto user = this.jdbcTemplate.queryForObject("select * from user where id = ?",
        new Object[] {id}, new RowMapper<UserDto>() {
          @Override
          public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserDto user = new UserDto();
            user.setId(Long.parseLong(rs.getString("id")));
            user.setUsername(rs.getString("username"));
            return user;
          }
        });
    return user;
  }

  @Override
  public UserDto get(Object id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public UserDto save(UserDto user) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public int update(UserDto user) {
    // TODO Auto-generated method stub
    return 0;
  }

  @Override
  public int delete(Object id) {
    return userMapper.delete(id);
  }


}
