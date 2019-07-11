package com.cafe24.mall.service;

import org.springframework.stereotype.Service;

import com.cafe24.mall.vo.UserVo;

@Service
public class UserService {

	// 회원 가입
	public UserVo joinUser(UserVo userVo) {
		UserVo result = new UserVo();
		result.setNo(1);
		return result;
	}

	// 회원 로그인
	public UserVo loginUser(UserVo userVo) {
		UserVo result = new UserVo();
		result.setNo(1);
		result.setId("hajiseung");
		result.setPw("1234");
		return result;
	}

}
