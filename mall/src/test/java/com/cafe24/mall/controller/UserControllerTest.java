package com.cafe24.mall.controller;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

import com.cafe24.mall.MemberEnum;
import com.cafe24.mall.config.AppConfig;
import com.cafe24.mall.config.TestWebConfig;
import com.cafe24.mall.service.UserService;
import com.cafe24.mall.vo.UserVo;
import com.google.gson.Gson;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class, TestWebConfig.class })
@WebAppConfiguration
public class UserControllerTest {
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Autowired
	private UserService userService;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testDIUserService() {
		assertNotNull(userService);
	}

	// 회원가입 Test
	@Test
	public void testUserJoin() throws Exception {
		UserVo vo = new UserVo();
		vo.setNo(1);
		vo.setAccount_number("1111-222-333333");
		vo.setBirthday("901006");
		vo.setCell_ph("010-3333-7777");
		vo.setEmail("tmdwlgk0109@naver.com");
		vo.setEmail_recv(false);
		vo.setGrade(MemberEnum.BRONZE);
		vo.setId("tmdwlgk0109");
		vo.setIslogin(false);
		vo.setJoin_date("2019-07-09");
		vo.setMassive_mount(999999);
		vo.setName("하지승");
		vo.setNickname("Nomacs");
		vo.setPoint(0);
		vo.setPurchase_cnt(0);
		vo.setPw("1234");
		vo.setSaving(0);
		vo.setSms_recv(false);
		vo.setTell_ph(null);

		ResultActions resultActions = mockMvc
				.perform(post("/api/user/join").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions.andExpect(status().isOk()).andDo(print()).andExpect(jsonPath("$.data.no", is(vo.getNo())));
	}

	// 로그인 Test
	@Test
	public void testUserLogin() throws Exception {
		UserVo vo = new UserVo();
		vo.setNo(1);
		vo.setId("hajiseung");
		vo.setPw("1234");
		ResultActions resultActions = mockMvc.perform(
				post("/api/user/login").contentType(MediaType.APPLICATION_JSON).content(new Gson().toJson(vo)));

		resultActions
		.andExpect(status().isOk()).andDo(print())
		.andExpect(jsonPath("$.data.no", is(vo.getNo())))
		.andExpect(jsonPath("$.data.id", is(vo.getId())))
		.andExpect(jsonPath("$.data.pw", is(vo.getPw())));

	}
}
