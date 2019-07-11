package com.cafe24.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cafe24.mall.service.UserService;
import com.cafe24.mall.vo.UserVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(value = "/api/user")
public class UserController {

	private UserVo userVo;

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public Boolean joinUser(UserVo userVo) {
		userService.joinUser(userVo);
		return true;
	}

	@ApiOperation(value = "이메일 존재여부 확인")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "email", value = "이메일 주소", required = true, dataType = "string", defaultValue = "") })
	@RequestMapping(value = "/api/login", method = RequestMethod.POST)
	public String test() {
		return "main";
	}
}
