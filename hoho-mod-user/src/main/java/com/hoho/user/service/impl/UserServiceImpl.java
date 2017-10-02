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

  @Override
  public UserDto get(Long id) {
    UserDto user = this.jdbcTemplate.queryForObject("select * from user where id = ?",
        new Object[] {id}, new RowMapper<UserDto>() {
          @Override
          public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserDto user = new UserDto();
            user.setId(Integer.parseInt(rs.getString("id")));
            user.setUsername(rs.getString("username"));
            return user;
          }
        });
    return user;
  }

}
