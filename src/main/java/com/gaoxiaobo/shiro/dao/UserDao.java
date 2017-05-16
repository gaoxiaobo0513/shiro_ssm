package com.gaoxiaobo.shiro.dao;

import com.gaoxiaobo.shiro.entity.User;

/**
 * Created by Mr_Gao on 2017/5/16.
 */
public interface UserDao {

    public User selectByUsername(String username);
}
