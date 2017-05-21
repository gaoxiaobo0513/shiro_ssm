package com.gaoxiaobo.shiro.utils;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import com.gaoxiaobo.shiro.entity.User;
/**
 * 密码加密工具类
 * @author Mr_Gao
 *
 */

public class PasswordHelper {
	private RandomNumberGenerator randomNumberGenerator=new SecureRandomNumberGenerator();
	//加密算法
	private String algorithmName="md5";
	//加密次数
	private int hashIterations=2;
	
	public void encryptPassword(User user){
		//明文密码
		String password=user.getPassword();
		
		//盐
		String salt=randomNumberGenerator.nextBytes().toHex();
		
		//加密生成新密码
		String newPassword=new SimpleHash(algorithmName, password.getBytes(), ByteSource.Util.bytes(salt),hashIterations).toString();
		
		user.setPassword(newPassword);
		user.setSalt(salt);
	}
	
}
