package com.cyt.authority.service;

import com.cyt.authority.core.page.PageRequest;
import com.cyt.authority.core.service.CrudService;
import com.cyt.authority.model.SysUser;
import com.cyt.authority.model.SysUserRole;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * @author Chenyt7
 * @Time 2021/5/21
 * @describe: 用户管理
 **/
public interface SysUserService extends CrudService<SysUser> {
	SysUser findByName(String username);

	SysUser createByName(String username);
	//查找用户的菜单权限标识集合
	Set<String> findPermissions(String userName);
	//查找用户的角色集合
	List<SysUserRole> findUserRoles(Long userId);
	//生成用户信息Excel文件
	File createUserExcelFile(PageRequest pageRequest);

}
