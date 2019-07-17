package com.cafe24.mall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mall.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;

	public UserVo checkId(UserVo userVo) {
		return sqlSession.selectOne("user.userIdCheck", userVo);
	}

	public void modifyUser(UserVo userVo) {

	}

	// 회원 가입
	public UserVo joinUser(UserVo userVo) {
		sqlSession.insert("user.insert", userVo);
		return userVo;
	}
	
	// 유저 로그인
	public UserVo loginUser(UserVo userVo) {
		return sqlSession.selectOne("user.loginUser",userVo);
	}
}
