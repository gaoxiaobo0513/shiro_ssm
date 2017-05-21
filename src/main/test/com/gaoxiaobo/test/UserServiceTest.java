package com.gaoxiaobo.test;

import java.util.Collections;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gaoxiaobo.shiro.entity.User;
import com.gaoxiaobo.shiro.service.UserServiceI;
import com.gaoxiaobo.shiro.service.impl.UserServiceImpl;

public class UserServiceTest {
	private ApplicationContext applicationContext;
	private UserServiceI userService;
	
	@Before
	public void init(){
		applicationContext=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		userService=applicationContext.getBean(UserServiceImpl.class);
	}
	
	/**
	 * 创建账户
	 * aaa---123456
	 * bbb---123456
	 * ccc---123456
	 */
	@Test
	public void createUserTest(){
		User user=new User();
		user.setLocked(false);
		user.setUsername("eee");
		user.setPassword("123456");
		userService.createUser(user);
	}
	
	@Test
	public void changePasswordTest(){
		userService.changePassword((long) 1, "123456");
	}
	
	@Test
	public void correlationRolesTest(){
		userService.correlationRoles((long)1, (long)2,(long)3);
	}
	
	@Test
	public void uncorrelationRolesTest(){
		userService.uncorrelationRoles((long)1, (long)2,(long)3);
	}
	
	@Test
	public void findByUsernameTest(){
		User user = userService.findByUsername("  ");
		System.out.println(user);
	}
	
	@Test
	public void findRolesTest(){
		Set<String> roles = userService.findRoles("aaa");
		System.out.println(roles.toString());
	}
	
	@Test
	public void findPermissionsTest(){
		Set<String> permissions = userService.findPermissions("aaa");
		System.out.println(permissions);
	}
}
