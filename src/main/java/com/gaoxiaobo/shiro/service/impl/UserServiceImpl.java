package com.gaoxiaobo.shiro.service.impl;

import java.util.Set;
import com.gaoxiaobo.shiro.dao.UserDaoI;
import com.gaoxiaobo.shiro.entity.User;
import com.gaoxiaobo.shiro.service.UserServiceI;
import com.gaoxiaobo.shiro.utils.PasswordHelper;

public class UserServiceImpl implements UserServiceI {

	private UserDaoI userDao;
	
	private PasswordHelper passwordHelper;
	
	
	
	public void setUserDao(UserDaoI userDao) {
		this.userDao = userDao;
	}

	public void setPasswordHelper(PasswordHelper passwordHelper) {
		this.passwordHelper = passwordHelper;
	}

	@Override
	public User createUser(User user) {
		passwordHelper.encryptPassword(user);
		Long id = userDao.createUser(user);
		user.setId(id);
		return user;
	}

	@Override
	public void changePassword(Long userId, String newPassword) {
		User user = userDao.findOne(userId);
		user.setPassword(newPassword);
		passwordHelper.encryptPassword(user);
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
		System.out.println(userDao);
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
