package com.cyt.authority.service;

import com.cyt.authority.core.service.CrudService;
import com.cyt.authority.model.SysMenu;
import java.util.List;

/**
 * @author Chenyt7
 * @Time 2021/5/21
 * @describe: 菜单管理
 **/
public interface SysMenuService extends CrudService<SysMenu> {
	/**
	 * 查询菜单树,用户ID和用户名为空则查询全部
	 * @param menuType 获取菜单类型，0：获取所有菜单，包含按钮，1：获取所有菜单，不包含按钮
	 * @param userName
	 */
	List<SysMenu> findTree(String userName, int menuType);
	//根据用户名查找菜单列表
	List<SysMenu> findByUser(String userName);
}