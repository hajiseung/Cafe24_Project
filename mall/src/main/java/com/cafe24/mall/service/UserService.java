package com.cafe24.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mall.repository.UserDao;
import com.cafe24.mall.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;

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

	// 회원 아이디 중복 체크 및 유효성 검사
	public boolean checkUserId(String id) {
		String returnId = userDao.checkId(id);
		if (returnId.equals(id)) {
			return false;
		}
		return true;
	}

	// 회원 정보 수정
	public void modifyUser(UserVo userVo) {
		userDao.modifyUser(userVo);
	}

}
