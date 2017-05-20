package com.gaoxiaobo.test.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
/**
 * 自定义Realm
 * 1.实现用户输入的账号密码和配置信息中的账号密码比对认证
 * 2.用户权限校验
 * @author Gao
 * 
 */
public class MyRealm extends AuthorizingRealm{

	/**
	 * 权限校验
	 * @param principals 
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		return null;
	}

	/**
	 * 身份认证
	 * @param token 包含用户输入的用户名和密码信息
	 * @return 返回用户的认证信息
	 * 
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String username = (String)token.getPrincipal();
		
		return null;
	}

}
