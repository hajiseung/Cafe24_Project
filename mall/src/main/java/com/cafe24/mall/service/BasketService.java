package com.cafe24.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mall.repository.BasketDao;
import com.cafe24.mall.vo.ItemVo;

@Service
public class BasketService {

	@Autowired
	private BasketDao basketDao;

	// 장바구니 저장
	public void addItemToBasket(ItemVo itemVo) {
		basketDao.addItemToBasket();
	}

	// 장바구니 리스트
	public void getBasketList() {
	}

	// 장바구니 물품 삭제
	public void deleteItemFromBasket() {
	}

	// 장바구니에서 주문하기
	public void orderFromBasket() {
	}

	// 즉시 구매
	public void immediatelyPurchase(ItemVo itemVo) {
	}
}
