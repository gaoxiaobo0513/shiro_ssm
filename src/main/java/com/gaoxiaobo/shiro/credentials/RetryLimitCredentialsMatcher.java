package com.gaoxiaobo.shiro.credentials;

import java.util.concurrent.atomic.AtomicInteger;


import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

public class RetryLimitCredentialsMatcher extends HashedCredentialsMatcher {
    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

	
	@Override
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		String username=(String)token.getPrincipal();
		
		 AtomicInteger retryCount = passwordRetryCache.get(username);
		if(retryCount==null){
			retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
		}
		
		//失败次数大于5则锁定账户
		if(retryCount.incrementAndGet()>5){
			throw new ExcessiveAttemptsException();
		}
		
		//真正的校验由父类HashedCredentialsMatcher去做
		boolean result = super.doCredentialsMatch(token, info);
		
		//校验成功，清除缓存登录次数
		if(result){
			passwordRetryCache.remove(username);
		}
		return result;
	}
	
}
