package com.cafe24.mall.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.mall.repository.BasketDao;
import com.cafe24.mall.repository.UserDao;
import com.cafe24.mall.vo.BasketVo;
import com.cafe24.mall.vo.ItemVo;
import com.cafe24.mall.vo.NonUserVo;

@Service
@Transactional
public class BasketService {

	@Autowired
	private BasketDao basketDao;

	@Autowired
	private UserDao userDao;

	// 장바구니 속성 저장
	public BasketVo addItemToBasket(BasketVo basketVo) {
		return basketDao.addItemToBasket(basketVo);
	}

	// 장바구니 리스트
	public List<ItemVo> getBasketList(BasketVo basketVo) {
		return basketDao.getBasketList(basketVo);
	}

	// 장바구니 물품 삭제
	public int deleteItemFromBasket(BasketVo basketVo) {
		return basketDao.deleteItemToBasket(basketVo);
	}

	// 장바구니에서 주문하기
	public void orderFromBasket() {
	}

	// 즉시 구매
	public void immediatelyPurchase(ItemVo itemVo) {
	}

	// 비회원이 장바구니 추가 전 비회원 번호 생성
	public NonUserVo addNonMember(String nonMemberAddr) {
		NonUserVo macAddr = new NonUserVo();
		macAddr.setMac_addr(nonMemberAddr);
		return userDao.insertNonMember(macAddr);
	}

	// 비회원 PK값 가져오기
	public NonUserVo getNonMemberNo(String nonMemberAddr) {
		NonUserVo macAddr = new NonUserVo();
		macAddr.setMac_addr(nonMemberAddr);
		return userDao.getNonMemberNo(macAddr);
	}

}
