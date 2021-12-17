package com.cyt.authority.model;
/**
 * @author Chenyt7
 * @date  2021/5/20
 **/
public class SysRoleDept extends BaseModel {
    private Long roleId;
    private Long deptId;

	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
}