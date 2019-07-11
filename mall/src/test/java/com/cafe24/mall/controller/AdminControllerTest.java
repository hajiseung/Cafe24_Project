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

	@Test
	public void testAdminInsertItem() throws Exception {
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

		ResultActions resultActions = mockMvc.perform(
				post("/api/admin/item/add").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isOk()).andDo(print())
				.andExpect(jsonPath("$.result", is("success")))
				.andExpect(jsonPath("$.data.title", is(vo.getTitle())))
				.andExpect(jsonPath("$.data.amount",is(vo.getAmount())))
				.andExpect(jsonPath("$.data.available_amount",is(vo.getAvailable_amount())))
				.andExpect(jsonPath("$.data.category_no",is(vo.getCategory_no())))
				.andExpect(jsonPath("$.data.desc",is(vo.getDesc())))
				.andExpect(jsonPath("$.data.displaystatus",is(vo.isDisplaystatus())))
				.andExpect(jsonPath("$.data.is_sub_photo",is(vo.isIs_sub_photo())))
				.andExpect(jsonPath("$.data.low_category",is(vo.getLow_category())))
				.andExpect(jsonPath("$.data.main_photo",is(vo.getMain_photo())))
				.andExpect(jsonPath("$.data.name",is(vo.getName())))
				.andExpect(jsonPath("$.data.no",is(vo.getNo())))
				.andExpect(jsonPath("$.data.non_amount",is(vo.isNon_amount())))
				.andExpect(jsonPath("$.data.price",is(vo.getPrice())))
				.andExpect(jsonPath("$.data.reg_date",is(vo.getReg_date())))
				.andExpect(jsonPath("$.data.salestatus",is(vo.isSalestatus())))
				.andExpect(jsonPath("$.data.sub_photo",is(vo.getSub_photo())))
				.andExpect(jsonPath("$.data.top_category",is(vo.getTop_category())));
	}

}
