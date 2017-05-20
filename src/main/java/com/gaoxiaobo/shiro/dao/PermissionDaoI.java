package com.gaoxiaobo.shiro.dao;

import com.gaoxiaobo.shiro.entity.Permission;

public interface PermissionDaoI {
    public Permission createPermission(Permission permission);

    public void deletePermission(Long permissionId);
}
