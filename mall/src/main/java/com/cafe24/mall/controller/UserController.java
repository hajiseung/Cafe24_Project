package com.cafe24.mall.controller;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@Autowired
	private MessageSource messageSource;

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
	public ResponseEntity<JSONResult> joinUser(@RequestBody @Valid UserVo userVo, BindingResult result) {

		// 가입 오류시 에러 출력
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}

		UserVo userNo = userService.joinUser(userVo);

		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(userNo));
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
	public ResponseEntity<JSONResult> loginUser(@RequestBody UserVo userVo) {
		UserVo result = userService.loginUser(userVo);
		if (result == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail("로그인에 실패 하였습니다."));
		}
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(result));
	}

	// 회원 아이디 중복 체크
	@RequestMapping(value = "/checkuserid", method = RequestMethod.POST)
	public ResponseEntity<JSONResult> checkuserId(@RequestBody UserVo userVo) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<UserVo>> validatorResults = validator.validateProperty(userVo, "id");
		
		if (validatorResults.isEmpty() == false) {
			for (ConstraintViolation<UserVo> validatorResult : validatorResults) {
				String message = messageSource.getMessage("NotEmpty.userVo.id", null, LocaleContextHolder.getLocale());
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(message));
			}
		}

		boolean resultB = userService.checkUserId(userVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(resultB));
	}

	// 회원정보 수정
	@RequestMapping(value = "/modifyuser", method = RequestMethod.POST)
	public String modifyUser(UserVo userVo) {
		userService.modifyUser(userVo);
		return "redirect:/";
	}

	// 회원 로그아웃 (인터페이스로 옮길 예정)
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("authUser");
		session.invalidate();
		return "redirect:/";
	}

	// 회원 탈퇴
	@RequestMapping(value = "/secession", method = RequestMethod.POST)
	public void secessionUser(UserVo userVo) {
		userService.secessionUser(userVo);
	}

}
