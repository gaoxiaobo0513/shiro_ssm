package com.gaoxiaobo.test;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gaoxiaobo.shiro.dao.UserDaoI;
import com.gaoxiaobo.shiro.entity.User;

public class DaoTest {
	
	@Test
	public void userDaoTest(){
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
		UserDaoI userDao=applicationContext.getBean(UserDaoI.class);
		CredentialsMatcher credentialsMatcher=new HashedCredentialsMatcher();
	}
}
