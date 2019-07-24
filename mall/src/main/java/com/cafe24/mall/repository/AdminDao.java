package com.cafe24.mall.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.mall.vo.ItemVo;

@Repository
public class AdminDao {

	@Autowired
	private SqlSession sqlSession;

	@Transactional
	public ItemVo addItem(ItemVo itemVo) {

		Map<String, Object> map = new HashMap<>();
		// 카테고리 등록
		sqlSession.insert("admin.addCategory", itemVo);
		// Item 등록
		sqlSession.insert("admin.addItem", itemVo);
		// Item_detail 등록
		sqlSession.insert("admin.addItemDetail", itemVo);

		// Item_option
		for (int i = 0; i < itemVo.getName().size(); i++) {
			map.put("no", itemVo.getNo());
			map.put("option", itemVo.getName().get(i));
			sqlSession.insert("admin.addItemOption", map);
			map.clear();
		}

		// Item_photo
		for (int i = 0; i < itemVo.getSub_photo().size(); i++) {
			map.put("no", itemVo.getNo());
			map.put("main_photo", itemVo.getMain_photo());
			map.put("sub_photo", itemVo.getSub_photo().get(i));
			map.put("is_sub_photo", itemVo.getIs_sub_photo().get(i));
			sqlSession.insert("admin.addItemPhoto", map);
			map.clear();
		}
		return itemVo;
	}

}
