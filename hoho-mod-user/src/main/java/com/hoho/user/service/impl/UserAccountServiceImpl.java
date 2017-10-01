/*
 * Copyright (c) 2014-2015, Yunnex and/or its affiliates. All rights reserved. Use, Copy is subject
 * to authorized license.
 */
package com.hoho.user.service.impl;

import org.springframework.stereotype.Service;

import com.hoho.user.service.UserAccountService;



/**
 * UserAccount Service实现
 * 
 * @author linxiang
 * @date 2017-04-17
 */
@Service("userAccountService")
public class UserAccountServiceImpl implements UserAccountService {
    @Override
    public void sayHollen() {
        System.out.println("欢迎来到spring的世界");
    }
}
