package com.cyt.authority.service;

import com.cyt.authority.core.service.CrudService;
import com.cyt.authority.model.SysLoginLog;

/**
 * @author Chenyt7
 * @Time 2021/5/21
 * @describe: 登录日志
 **/
public interface SysLoginLogService extends CrudService<SysLoginLog> {
    //记录登录日志
    int writeLoginLog(String userName, String ip);
}
