package com.gaoxiaobo.shiro.realms;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gaoxiaobo.shiro.entity.User;
import com.gaoxiaobo.shiro.service.UserServiceI;
import com.gaoxiaobo.shiro.service.impl.UserServiceImpl;

/**
 * 自定义Realm 
 * 1.实现用户输入的账号密码和配置信息中的账号密码比对认证 
 * 2.用户权限校验
 * @author Mr_Gao
 * 
 */

public class UserRealm extends AuthorizingRealm {
	private UserServiceI userService;

	public void setUserService(UserServiceI userService){
		this.userService=userService;
	}
	
	
	/**
	 * 权限校验
	 * 通过用户名去数据查询用户对应角色和权限
	 * @return 返回用户角色权限信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authourizationInfo=new SimpleAuthorizationInfo();
		authourizationInfo.setRoles(userService.findRoles(username));
		authourizationInfo.setStringPermissions(userService.findPermissions(username));
		return authourizationInfo;
	}

	/**
	 * 身份认证
	 * 通过用户名去数据库查询用户账户密码信息
	 * 交给HashedCredentialsMatched进行匹配
	 * @param token 包含用户输入的用户名和密码信息
	 * @return 返回用户的认证信息
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		System.out.println(userService);
		User user = userService.findByUsername(username);
		if (user == null) {
			// 账户不存在
			throw new UnknownAccountException();
		}

		if (Boolean.TRUE.equals(user.getLocked())) {
			// 账户被锁定
			throw new LockedAccountException();
		}

		//交给父类AuthorizingRealm使用CredentialsMacther进行密码校验
		AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(),
												user.getPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
		return authenticationInfo;
	}
}
