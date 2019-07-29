package com.cafe24.mall.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.mall.dto.JSONResult;
import com.cafe24.mall.service.AdminService;
import com.cafe24.mall.vo.ItemVo;
import com.cafe24.mall.vo.UserVo;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// 관리자 로그인 페이지
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String adminLogin() {
		return "login";
	}

	// 물품 등록 페이지
	@RequestMapping(value = "/form/item", method = RequestMethod.GET)
	public String getaddItemForm() {
		return "api/admin/form/item";
	}

	// 물품 등록
	@RequestMapping(value = "/item/add", method = RequestMethod.POST)
	public ResponseEntity<JSONResult> addItem(@RequestBody @Valid ItemVo itemVo, BindingResult result) {
		// 가입 오류시 에러 출력
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JSONResult.fail(error.getDefaultMessage()));
			}
		}
		ItemVo vo = adminService.addItem(itemVo);
		return ResponseEntity.status(HttpStatus.OK).body(JSONResult.success(vo));
	}

	// 회원 관리 페이지
	@RequestMapping(value = "/form/memberlist", method = RequestMethod.GET)
	public String getMemberList() {
		return "api/admin/form/memberlist";
	}

	// 회원 관리
	@RequestMapping(value = "/memberlist", method = RequestMethod.GET)
	public void memberList() {
		List<UserVo> list = adminService.memberList();
		System.out.println(list);
	}

	// 주문 관리 페이지 호출
	@RequestMapping(value = "/form/orderlist", method = RequestMethod.GET)
	public String getorderListForm() {
		return "api/admin/form/orderlist";
	}

	// 주문 관리 페이지 변경시
	@RequestMapping(value = "/orderlist", method = RequestMethod.POST)
	public void orderList() {
		adminService.orderList();
	}

	// 재고 관리 페이지 호출
	@RequestMapping(value = "/form/itemlist", method = RequestMethod.GET)
	public String getitemListForm() {
		return "api/admin/form/itemlist";
	}

	// 재고 관리
	@RequestMapping(value = "/itemlist", method = RequestMethod.GET)
	public void itemList() {
		adminService.itemList();
	}
}
