package com.cyt.authority.service;

import com.cyt.authority.core.service.CrudService;
import com.cyt.authority.model.SysConfig;
import java.util.List;

/**
 * @author Chenyt7
 * @Time 2021/5/21
 * @describe: 系统配置管理
 **/
public interface SysConfigService extends CrudService<SysConfig> {
	//根据名称查询
	List<SysConfig> findByLable(String lable);
}