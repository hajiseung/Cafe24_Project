package com.cafe24.mall.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.mall.dto.JSONResult;
import com.cafe24.mall.service.UserService;
import com.cafe24.mall.vo.UserVo;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	// 회원 가입 폼 이동
	@RequestMapping(value = "/joinform", method = RequestMethod.GET)
	public String joinFormUser() {
		return "api/user/join";
	}

	// 회원 가입
	@ApiOperation(value = "회원 가입")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "1234", value = "5678", required = true, dataType = "string", defaultValue = "") })
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public JSONResult joinUser(UserVo userVo) {
		UserVo result = userService.joinUser(userVo);
		return JSONResult.success(result);
	}

	// 회원 로그인 폼
	@RequestMapping(value = "/loginform", method = RequestMethod.GET)
	public String loginFormUser() {
		return "api/user/login";
	}

	// 회원 로그인
	@ApiOperation(value = "회원 로그인")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "Login", required = true, dataType = "string", defaultValue = "") })
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public JSONResult loginUser(UserVo userVo) {
		UserVo result = userService.loginUser(userVo);
		return JSONResult.success(result);
	}

	// 회원 아이디 중복 체크 및 유효성 검사
	@ResponseBody
	@RequestMapping(value = "/checkuserid", method = RequestMethod.POST)
	public JSONResult checkuserId(@ModelAttribute @Valid String Id) {
		boolean result = userService.checkUserId(Id);
		return JSONResult.success(result);
	}

	// 회원정보 수정
	@RequestMapping(value = "/modifyuser", method = RequestMethod.POST)
	public String modifyUser(UserVo userVo) {
		userService.modifyUser(userVo);
		return "redirect:/";
	}

	// 회원 로그아웃 (인터페이스로 옮길 예정)
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}
}
