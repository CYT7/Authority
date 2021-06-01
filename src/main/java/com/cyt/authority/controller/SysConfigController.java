package com.cyt.authority.controller;

import com.cyt.authority.core.http.HttpResult;
import com.cyt.authority.core.page.PageRequest;
import com.cyt.authority.model.SysConfig;
import com.cyt.authority.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Chenyt7
 * @Time 2021/5/21
 * @describe: 系统配置控制器
 **/
@RestController
@RequestMapping("config")
public class SysConfigController {
	@Autowired
	private SysConfigService sysConfigService;
	@PreAuthorize("hasAuthority('sys:config:add') AND hasAuthority('sys:config:edit')")
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysConfig record) {
		return HttpResult.ok(sysConfigService.save(record));
	}
	@PreAuthorize("hasAuthority('sys:config:delete')")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysConfig> records) {
		return HttpResult.ok(sysConfigService.delete(records));
	}
	@PreAuthorize("hasAuthority('sys:config:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysConfigService.findPage(pageRequest));
	}
	@PreAuthorize("hasAuthority('sys:config:view')")
	@GetMapping(value="/findByLable")
	public HttpResult findByLable(@RequestParam String lable) {
		return HttpResult.ok(sysConfigService.findByLable(lable));
	}
}