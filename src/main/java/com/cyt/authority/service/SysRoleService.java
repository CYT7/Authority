package com.cyt.authority.service;

import com.cyt.authority.core.service.CrudService;
import com.cyt.authority.model.SysMenu;
import com.cyt.authority.model.SysRole;
import com.cyt.authority.model.SysRoleMenu;
import java.util.List;

/**
 * @author Chenyt7
 * @Time 2021/5/21
 * @describe: 角色管理
 **/
public interface SysRoleService extends CrudService<SysRole> {
	//查询全部
	List<SysRole> findAll();
	//查询角色菜单集合
	List<SysMenu> findRoleMenus(Long roleId);
	//保存角色菜单
	int saveRoleMenus(List<SysRoleMenu> records);
	//根据名称查询
	List<SysRole> findByName(String name);
}