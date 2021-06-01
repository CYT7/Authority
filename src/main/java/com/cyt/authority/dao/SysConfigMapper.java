package com.cyt.authority.dao;

import java.util.List;
import com.cyt.authority.model.SysConfig;
import org.apache.ibatis.annotations.Param;

public interface SysConfigMapper {
    int deleteByPrimaryKey(Long id);
    int insert(SysConfig record);
    int insertSelective(SysConfig record);
    SysConfig selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(SysConfig record);
    int updateByPrimaryKey(SysConfig record);
    List<SysConfig> findPage();
    List<SysConfig> findPageByLabel(@Param(value="label") String label);
    List<SysConfig> findByLable(@Param(value="label") String label);
}