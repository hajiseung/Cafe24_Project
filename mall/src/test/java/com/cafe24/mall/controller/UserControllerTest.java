package com.cafe24.mall.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cafe24.TestUtil;
import com.cafe24.mall.MemberEnum;
import com.cafe24.mall.config.AppConfig;
import com.cafe24.mall.config.TestWebConfig;
import com.cafe24.mall.service.UserService;
import com.cafe24.mall.vo.UserVo;

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

	
	//회원가입 Test
	@Test
	public void testUserJoin() throws Exception {
		UserVo vo = new UserVo();
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

//		Mockito.when(userService.joinUser(any(UserVo.class)));

		mockMvc.perform(post("/api/user/join").contentType(TestUtil.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andDo(print());

	}
}
