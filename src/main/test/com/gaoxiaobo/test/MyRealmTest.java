package com.gaoxiaobo.test;

import junit.framework.TestCase;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gaoxiaobo.shiro.entity.User;
import com.gaoxiaobo.shiro.realms.UserRealm;
import com.gaoxiaobo.shiro.service.UserServiceI;
import com.gaoxiaobo.shiro.service.impl.UserServiceImpl;



public class MyRealmTest {
	
	@Test
	public void loginTest(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		SecurityManager securityManager =(SecurityManager) ac.getBean("securityManager");
		SecurityUtils.setSecurityManager(securityManager);
		
		UsernamePasswordToken token = new UsernamePasswordToken("aaa", "123456");
		
		Subject subject = SecurityUtils.getSubject();
		
		subject.login(token);
		
		TestCase.assertTrue(subject.isAuthenticated());
	}
}
