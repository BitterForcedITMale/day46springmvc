package com.itheima.dao.impl;

import com.itheima.dao.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoimpl implements UserDao {
    @Override
    public void queryUser() {
        System.out.println("dao层曾查询用户");
    }
}
