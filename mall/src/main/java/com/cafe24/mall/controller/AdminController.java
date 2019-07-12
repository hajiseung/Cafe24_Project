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

	// 물품 등록 페이지
	@RequestMapping(value = "/form/item", method = RequestMethod.GET)
	public String addItemForm() {
		return "api/admin/form/item";
	}

	// 물품 등록
	@RequestMapping(value = "/item/add", method = RequestMethod.POST)
	public JSONResult addItem(ItemVo itemVo) {
		ItemVo vo = adminService.addItem(itemVo);
		return JSONResult.success(vo);
	}

	// 회원 관리
	@RequestMapping(value = "/memberlist", method = RequestMethod.GET)
	public void memberList() {
		adminService.memberList();
	}

	// 주문 관리 페이지 호출
	@RequestMapping(value = "/form/orderlist", method = RequestMethod.GET)
	public String orderListForm() {
		return "api/admin/form/orderlist";
	}

	// 주문 관리 페이지 변경시
	@RequestMapping(value = "/orderlist", method = RequestMethod.POST)
	public void orderList() {
		adminService.orderList();
	}

	// 재고 관리 페이지 호출
	@RequestMapping(value = "/form/itemlist", method = RequestMethod.GET)
	public String itemListForm() {
		return "api/admin/form/itemlist";
	}

	// 재고 관리
	@RequestMapping(value = "/itemlist", method = RequestMethod.GET)
	public void itemList() {
		adminService.itemList();
	}
}
