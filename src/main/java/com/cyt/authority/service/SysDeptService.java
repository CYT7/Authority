package com.cyt.authority.service;

import com.cyt.authority.core.service.CrudService;
import com.cyt.authority.model.SysDept;
import java.util.List;

/**
 * @author Chenyt7
 * @Time 2021/5/21
 * @describe: 机构管理
 **/
public interface SysDeptService extends CrudService<SysDept> {
	//查询机构树
	List<SysDept> findTree();
}
