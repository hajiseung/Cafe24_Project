package com.cafe24.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.mall.dto.JSONResult;
import com.cafe24.mall.service.AdminService;
import com.cafe24.mall.vo.ItemVo;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// 물품 등록
	@RequestMapping(value = "/item/add", method = RequestMethod.POST)
	public JSONResult addItem(ItemVo itemVo) {
		ItemVo vo = adminService.addItem(itemVo);
		return JSONResult.success(vo);
	}
}
