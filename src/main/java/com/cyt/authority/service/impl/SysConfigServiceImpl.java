package com.cyt.authority.service.impl;

import java.util.List;
import com.cyt.authority.core.page.MybatisPageHelper;
import com.cyt.authority.core.page.PageRequest;
import com.cyt.authority.core.page.PageResult;
import com.cyt.authority.dao.SysConfigMapper;
import com.cyt.authority.model.SysConfig;
import com.cyt.authority.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysConfigServiceImpl  implements SysConfigService {

	@Autowired
	private SysConfigMapper sysConfigMapper;

	@Override
	public int save(SysConfig record) {
		if(record.getId() == null || record.getId() == 0) {
			return sysConfigMapper.insertSelective(record);
		}
		return sysConfigMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int delete(SysConfig record) {
		return sysConfigMapper.deleteByPrimaryKey(record.getId());
	}

	@Override
	public int delete(List<SysConfig> records) {
		for(SysConfig record:records) {
			delete(record);
		}
		return 1;
	}

	@Override
	public SysConfig findById(Long id) {
		return sysConfigMapper.selectByPrimaryKey(id);
	}

	@Override
	public PageResult findPage(PageRequest pageRequest) {
		Object label = pageRequest.getParamValue("label");
		if(label != null) {
			return MybatisPageHelper.findPage(pageRequest, sysConfigMapper, "findPageByLabel", label);
		}
		return MybatisPageHelper.findPage(pageRequest, sysConfigMapper);
	}

	@Override
	public List<SysConfig> findByLable(String lable) {
		return sysConfigMapper.findByLable(lable);
	}
}