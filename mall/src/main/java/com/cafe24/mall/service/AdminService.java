package com.cafe24.mall.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cafe24.mall.vo.ItemVo;

@Service
public class AdminService {

	public ItemVo addItem(ItemVo itemVo) {
		List<String> option = new ArrayList<>();
		List<String> subphoto = new ArrayList<>();
		option.add("빨강");
		option.add("노랑");
		subphoto.add("사진1");
		subphoto.add("사진2");
		ItemVo vo = new ItemVo();
		vo.setTitle("티셔츠");
		vo.setAmount(100);
		vo.setAvailable_amount(100);
		vo.setCategory_no(1);
		vo.setDesc("설명");
		vo.setDisplaystatus(false);
		vo.setIs_sub_photo(false);
		vo.setLow_category("상의");
		vo.setMain_photo("메인포토");
		vo.setName(option);
		vo.setNo(1);
		vo.setNon_amount(false);
		vo.setPrice(10000);
		vo.setReg_date("2019-07-10 00:00:00");
		vo.setSalestatus(true);
		vo.setSub_photo(subphoto);
		vo.setTop_category("옷");
		return vo;
	}
}
