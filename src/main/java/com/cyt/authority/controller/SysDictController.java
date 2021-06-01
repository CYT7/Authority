package com.cyt.authority.controller;

import com.cyt.authority.core.http.HttpResult;
import com.cyt.authority.core.page.PageRequest;
import com.cyt.authority.model.SysDict;
import com.cyt.authority.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author Chenyt7
 * @Time 2021/5/21
 * @describe: 字典控制器
 **/
@RestController
@RequestMapping("dict")
public class SysDictController {
	@Autowired
	private SysDictService sysDictService;
	@PreAuthorize("hasAuthority('sys:dict:add') AND hasAuthority('sys:dict:edit')")
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysDict record) {
		return HttpResult.ok(sysDictService.save(record));
	}
	@PreAuthorize("hasAuthority('sys:dict:delete')")
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysDict> records) {
		return HttpResult.ok(sysDictService.delete(records));
	}
	@PreAuthorize("hasAuthority('sys:dict:view')")
	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysDictService.findPage(pageRequest));
	}
	@PreAuthorize("hasAuthority('sys:dict:view')")
	@GetMapping(value="/findByLable")
	public HttpResult findByLable(@RequestParam String lable) {
		return HttpResult.ok(sysDictService.findByLable(lable));
	}
}