package com.cyt.authority.model;

/**
 * @author Chenyt7
 * @date  2021/5/20
 **/
public class SysUserRole extends BaseModel {
    private Long userId;
    private Long roleId;

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
}