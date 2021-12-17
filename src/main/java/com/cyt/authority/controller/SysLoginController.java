package com.cyt.authority.controller;

import com.cyt.authority.core.http.HttpResult;
import com.cyt.authority.model.SysUser;
import com.cyt.authority.security.JwtAuthenticatioToken;
import com.cyt.authority.service.SysLoginLogService;
import com.cyt.authority.service.SysUserService;
import com.cyt.authority.utils.IoUtils;
import com.cyt.authority.utils.IpUtils;
import com.cyt.authority.utils.PasswordUtils;
import com.cyt.authority.utils.SecurityUtils;
import com.cyt.authority.vo.LoginBean;
import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Chenyt7
 * @date  2021/5/21
 * @describe 登录控制器
 **/
@RestController
public class SysLoginController {

	@Autowired
	private Producer producer;
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysLoginLogService sysLoginLogService;
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("captcha.jpg")
	public void captcha(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setHeader("Cache-Control", "no-store, no-cache");
		response.setContentType("image/jpeg");
		// 生成文字验证码
		String text = producer.createText();
		// 生成图片验证码
		BufferedImage image = producer.createImage(text);
		// 保存到验证码到 session
		request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(image, "jpg", out);
		IoUtils.closeQuietly(out);
	}

	/**登录接口*/
	@PostMapping(value = "/login")
	public HttpResult login(@RequestBody LoginBean loginBean, HttpServletRequest request) throws IOException {
		String username = loginBean.getAccount();
		String password = loginBean.getPassword();
		String captcha = loginBean.getCaptcha();
		//从session中获取之前保存的验证码跟前台传来的验证码进行匹配
		Object kaptcha = request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(kaptcha == null){ return HttpResult.error("验证码已失效"); }
		if(!captcha.equals(kaptcha)){ return HttpResult.error("验证码不正确"); }
		//用户信息
		SysUser user = sysUserService.findByName(username);
		//账号不存在、密码错误
		if (user == null) {
			return HttpResult.error("账号不存在");
		}
		if (PasswordUtils.matchPassword(user.getSalt(), password, user.getPassword())) {
			return HttpResult.error("密码不正确");
		}
		//账号锁定
		if (user.getStatus() == 0) {
			return HttpResult.error("账号已被锁定,请联系管理员");
		}
		//系统登录认证
		JwtAuthenticatioToken token = SecurityUtils.login(request, username, password, authenticationManager);
		//记录登录日志
		sysLoginLogService.writeLoginLog(username, IpUtils.getIpAddr(request));
		return HttpResult.ok(token);
	}
}