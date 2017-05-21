package com.gaoxiaobo.shiro.service.impl;

import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaoxiaobo.shiro.dao.UserDaoI;
import com.gaoxiaobo.shiro.entity.User;
import com.gaoxiaobo.shiro.service.UserServiceI;
import com.gaoxiaobo.shiro.utils.PasswordHelper;

@Service
public class UserServiceImpl implements UserServiceI {

	@Autowired
	private UserDaoI userDao;
	
	
	@Override
	public User createUser(User user) {
		new PasswordHelper().encryptPassword(user);
		Long id = userDao.createUser(user);
		user.setId(id);
		return user;
	}

	@Override
	public void changePassword(Long userId, String newPassword) {
		User user = userDao.findOne(userId);
		user.setPassword(newPassword);
		new PasswordHelper().encryptPassword(user);
		userDao.updateUser(user);
	}

	@Override
	public void correlationRoles(Long userId, Long... roleIds) {
		if(roleIds.length>0){
			userDao.correlationRoles(userId, roleIds);
		}
	}

	@Override
	public void uncorrelationRoles(Long userId, Long... roleIds) {
		if(roleIds.length>0){
			userDao.uncorrelationRoles(userId, roleIds);
		}

	}

	@Override
	public User findByUsername(String username) {
		return (username==null||username.trim().length()==0)?null:userDao.findByUsername(username);
	}

	@Override
	public Set<String> findRoles(String username) {
		return (username==null||username.trim().length()==0)?null:userDao.findRoles(username);
	}

	@Override
	public Set<String> findPermissions(String username) {
		return (username==null||username.trim().length()==0)?null:userDao.findPermissions(username);
	}

	
}
