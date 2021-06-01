package com.cyt.authority.service.impl;

import java.util.List;
import com.cyt.authority.core.page.MybatisPageHelper;
import com.cyt.authority.core.page.PageRequest;
import com.cyt.authority.core.page.PageResult;
import com.cyt.authority.dao.SysDictMapper;
import com.cyt.authority.model.SysDict;
import com.cyt.authority.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysDictServiceImpl  implements SysDictService {

	@Autowired
	private SysDictMapper sysDictMapper;

	@Override
	public int save(SysDict record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysDictMapper.insertSelective(record);
		}
		return sysDictMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysDict record) {
		return sysDictMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysDict> records) {
		for(SysDict record:records) {
			delete(record);
		}
		return 1;
	}
	@Override
	public SysDict findById(Long id) {
		return sysDictMapper.selectByPrimaryKey(id);
	}
	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Object label = pageRequest.getParamValue("label");
		if(label != null) {
			return MybatisPageHelper.findPage(pageRequest, sysDictMapper, "findPageByLabel", label);
		}
		return MybatisPageHelper.findPage(pageRequest, sysDictMapper);
	}
	@Override
	public List<SysDict> findByLable(String lable) {
		return sysDictMapper.findByLable(lable);
	}
}