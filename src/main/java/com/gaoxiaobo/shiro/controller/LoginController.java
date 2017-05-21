package com.gaoxiaobo.shiro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response){
		System.out.println("LoginController.login()");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		String error=null;
		try {
			SecurityUtils.getSubject().login(token);
		} catch (UnknownAccountException e) {
			error="用户名不存在！";
		}catch (IncorrectCredentialsException e) {
			error="密码错误！";
		}catch (AuthenticationException e) {
			error=e.getMessage();
		}
		
		if(error!=null){
			request.setAttribute("error", error);
			return "login";
		}
		request.setAttribute("user", username);
		return "success";
	}
}
