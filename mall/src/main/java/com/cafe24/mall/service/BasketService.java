package com.cafe24.mall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.mall.repository.BasketDao;
import com.cafe24.mall.vo.ItemVo;

@Service
public class BasketService {

	@Autowired
	private BasketDao basketDao;

	public void addItemToBasket(ItemVo itemVo) {
		basketDao.addItemToBasket();
	}

	public void getBasketList() {
	}

	public void deleteItemFromBasket() {
	}

	public void orderFromBasket() {
	}
}
