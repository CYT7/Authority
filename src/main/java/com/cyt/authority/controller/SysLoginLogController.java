package com.cyt.authority.controller;

import com.cyt.authority.core.http.HttpResult;
import com.cyt.authority.core.page.PageRequest;
import com.cyt.authority.model.SysLoginLog;
import com.cyt.authority.service.SysLoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author Chenyt7
 * @date  2021/5/21
 * @describe 登录日志控制器
 **/
@RestController
@RequestMapping("loginlog")
public class SysLoginLogController {
	@Autowired
	private SysLoginLogService sysLoginLogService;
	@PreAuthorize("hasAuthority('sys:loginlog:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
	}
	@PreAuthorize("hasAuthority('sys:loginlog:delete')")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysLoginLog> records) {
		return HttpResult.ok(sysLoginLogService.delete(records));
	}
}