package com.cyt.authority.controller;

import com.cyt.authority.core.http.HttpResult;
import com.cyt.authority.core.page.PageRequest;
import com.cyt.authority.model.SysLog;
import com.cyt.authority.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author Chenyt7
 * @Time 2021/5/21
 * @describe: 操作日志控制器
 **/
@RestController
@RequestMapping("log")
public class SysLogController {
	@Autowired
	private SysLogService sysLogService;
	@PreAuthorize("hasAuthority('sys:log:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysLogService.findPage(pageRequest));
	}
	@PreAuthorize("hasAuthority('sys:log:delete')")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysLog> records) {
		return HttpResult.ok(sysLogService.delete(records));
	}
}