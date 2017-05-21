package com.gaoxiaobo.test;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gaoxiaobo.shiro.entity.User;
import com.gaoxiaobo.shiro.service.UserServiceI;

/**
 * Created by Mr_Gao on 2017/5/16.
 */
public class Log4JTest {

    @Test
    public void log4jTest(){
        Logger log= LoggerFactory.getLogger(Log4JTest.class);
        log.info("log4f正常运行了！");
    }
    
    @Test
    public void userServiceTest(){
    	ApplicationContext ac=new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    	UserServiceI userService=(UserServiceI)ac.getBean("userService");
    	User user = userService.findByUsername("aaa");
    	System.out.println(user);
    }
}
