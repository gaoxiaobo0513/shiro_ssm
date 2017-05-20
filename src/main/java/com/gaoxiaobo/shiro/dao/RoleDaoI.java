package com.gaoxiaobo.shiro.dao;

import com.gaoxiaobo.shiro.entity.Role;

public interface RoleDaoI {
	 public Role createRole(Role role);
	    public void deleteRole(Long roleId);
	    public void correlationPermissions(Long roleId, Long... permissionIds);
	    public void uncorrelationPermissions(Long roleId, Long... permissionIds);
}
