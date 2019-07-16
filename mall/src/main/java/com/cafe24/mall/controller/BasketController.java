package com.cafe24.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.mall.service.BasketService;
import com.cafe24.mall.vo.ItemVo;

@RestController
@RequestMapping(value = "/api/basket")
public class BasketController {
	@Autowired
	private BasketService basketService;

	// 바로구매
	@RequestMapping(value = "/immediate")
	public void immediatelyPurchase(ItemVo itemVo) {
		basketService.immediatelyPurchase(itemVo);
	}
	
	// 장바구니 저장
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addItemToBasket(ItemVo itemVo) {
		basketService.addItemToBasket(itemVo);
	}

	// 장바구니 리스트 호출
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public void getBasketList() {
		basketService.getBasketList();
	}

	// 장바구니 물품 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void deleteItemFromBasket() {
		basketService.deleteItemFromBasket();
	}

	// 장바구니 물품 주문 페이지
	@RequestMapping(value = "/form/orderfrombasket", method = RequestMethod.GET)
	public String getOrderFromBasket() {
		return "api/basket/form/orderfrombasket";
	}

	// 장바구니 물품 주문
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public void orderFromBasket() {
		basketService.orderFromBasket();
	}
}
