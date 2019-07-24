package com.cafe24.mall.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cafe24.mall.vo.BasketVo;

@Repository
public class BasketDao {

	@Autowired
	private SqlSession sqlSession;

	// 장바구니 추가
	public BasketVo addItemToBasket(BasketVo basketVo) {
		sqlSession.insert("basket.addItemToBasket", basketVo);
		return basketVo;
	}

	// 장바구니 품목 삭제
	public int deleteItemToBasket(BasketVo basketVo) {
		return sqlSession.delete("basket.deleteItemToBasket", basketVo);
	}

}
