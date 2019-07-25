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

	public ItemVo addItem(ItemVo itemVo) {

		return adminDao.addItem(itemVo);
	}

	public List<UserVo> memberList() {
		return adminDao.getUserList();
	}

	public void orderList() {
		// TODO Auto-generated method stub

	}

	public void itemList() {
		// TODO Auto-generated method stub

	}
}
