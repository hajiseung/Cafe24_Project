package com.cafe24.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cafe24.mall.service.ItemService;
import com.cafe24.mall.vo.ItemVo;

@RestController
@RequestMapping(value = "/api/item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(value = "/search/{no}", method = RequestMethod.GET)
	public void itemSearch(ItemVo itemVo, @PathVariable(value = "no") long no) {

	}

}
