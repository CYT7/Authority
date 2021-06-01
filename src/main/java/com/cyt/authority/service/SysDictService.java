package com.cyt.authority.service;

import com.cyt.authority.core.service.CrudService;
import com.cyt.authority.model.SysDict;
import java.util.List;

/**
 * @author Chenyt7
 * @Time 2021/5/21
 * @describe: 字典管理
 **/
public interface SysDictService extends CrudService<SysDict> {
	//根据名称查询
	List<SysDict> findByLable(String lable);
}
