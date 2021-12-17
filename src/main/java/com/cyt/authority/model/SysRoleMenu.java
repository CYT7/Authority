package com.cyt.authority.model;
/**
 * @author Chenyt7
 * @date  2021/5/20
 **/
public class SysRoleMenu extends BaseModel {
	private Long roleId;
    private Long menuId;

	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getMenuId() {
		return menuId;
	}
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
}