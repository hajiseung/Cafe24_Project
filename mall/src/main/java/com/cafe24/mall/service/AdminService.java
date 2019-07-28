package com.cafe24.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mall.repository.AdminDao;
import com.cafe24.mall.vo.ItemVo;
import com.cafe24.mall.vo.UserVo;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	// 물품추가 
	public ItemVo addItem(ItemVo itemVo) {

		return adminDao.addItem(itemVo);
	}

	// 사용자 List 출력
	public List<UserVo> memberList() {
		return adminDao.getUserList();
	}

	public void orderList() {
	}

	public void itemList() {
	}
}
