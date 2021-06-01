package com.cyt.authority.dao;

import java.util.List;
import com.cyt.authority.model.SysUserRole;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Long id);
    int insert(SysUserRole record);
    int insertSelective(SysUserRole record);
    SysUserRole selectByPrimaryKey(Long id);
    int updateByPrimaryKeySelective(SysUserRole record);
    int updateByPrimaryKey(SysUserRole record);
	List<SysUserRole> findUserRoles(@Param(value="userId") Long userId);
	int deleteByUserId(@Param(value="userId") Long userId);
}