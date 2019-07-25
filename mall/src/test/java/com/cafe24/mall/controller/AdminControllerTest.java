package com.cafe24.mall.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.mall.config.AppConfig;
import com.cafe24.mall.config.TestWebConfig;
import com.cafe24.mall.service.AdminService;
import com.cafe24.mall.vo.ItemVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, TestWebConfig.class })
@WebAppConfiguration
public class AdminControllerTest {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private AdminService adminService;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testDIAdminService() {
		assertNotNull(adminService);
	}

	// 물품 등록 Test
	@Test
	public void testAdminInsertItem() throws Exception {
		List<String> option = new ArrayList<>();
		List<String> subphoto = new ArrayList<>();
		List<Boolean> isSubPhoto = new ArrayList<Boolean>();
		option.add("빨강");
		option.add("노랑");
		subphoto.add("사진1");
		subphoto.add("사진2");
		isSubPhoto.add(true);
		isSubPhoto.add(false);

		ItemVo vo = new ItemVo();

		// Item Add 성공
		vo.setTitle("티셔츠");
		vo.setAmount(100);
		vo.setAvailable_amount(100);
		vo.setDesc("설명");
		vo.setDisplaystatus(false);
		vo.setIs_sub_photo(isSubPhoto);
		vo.setLow_category("상의");
		vo.setMain_photo("메인포토");
		vo.setName(option);
		vo.setNon_amount(false);
		vo.setPrice(10000);
		vo.setReg_date("2019-07-10 00:00:00");
		vo.setSalestatus(true);
		vo.setSub_photo(subphoto);
		vo.setTop_category("옷");

		ResultActions resultActions = mockMvc.perform(
				post("/api/admin/item/add").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isOk()).andDo(print());

		// Item Add 실패
		vo.setTitle(null);
		vo.setAmount(100);
		vo.setAvailable_amount(100);
		vo.setDesc("설명");
		vo.setDisplaystatus(false);
		vo.setIs_sub_photo(isSubPhoto);
		vo.setLow_category("상의");
		vo.setMain_photo("메인포토");
		vo.setName(option);
		vo.setPrice(10000);
		vo.setReg_date("2019-07-10 00:00:00");
		vo.setSalestatus(true);
		vo.setSub_photo(subphoto);
		vo.setTop_category("옷");

		resultActions = mockMvc.perform(
				post("/api/admin/item/add").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isBadRequest()).andDo(print());
	}

	// 사용자 출력 Test
	@Test
	public void testUserList() throws Exception {

		ResultActions resultActions = mockMvc.perform(get("/api/admin/memberlist"));

		resultActions.andExpect(status().isOk()).andDo(print());
	}
}
