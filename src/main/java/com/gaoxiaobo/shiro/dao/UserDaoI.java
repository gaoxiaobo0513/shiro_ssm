package com.gaoxiaobo.shiro.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Param;
import com.gaoxiaobo.shiro.entity.User;

public interface UserDaoI {
    public Long createUser(User user);
    public void updateUser(User user);
    public void deleteUser(Long userId);

    //添加用户-角色关系
    public void correlationRoles(@Param("userId")Long userId, @Param("roleIds")Long... roleIds);
    //移除用户-角色关系
    public void uncorrelationRoles(@Param("userId")Long userId, @Param("roleIds")Long... roleIds);

    User findOne(Long userId);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
    
}
