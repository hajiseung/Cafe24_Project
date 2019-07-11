package com.cafe24.mall.service;

import org.springframework.stereotype.Service;

import com.cafe24.mall.vo.UserVo;

@Service
public class UserService {

	public UserVo joinUser(UserVo userVo) {
		UserVo result = new UserVo();
		result.setNo(1);
		return result;

	}
}
