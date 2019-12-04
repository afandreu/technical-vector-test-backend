package com.vector.tests.wallet.api;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.vector.tests.wallet.WalletApplication;
import com.vector.tests.wallet.service.impl.MonederoDto;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WalletApplication.class)
@WebAppConfiguration
public class WalletControllerTest {

	protected MockMvc mvc;
	
	@Autowired
	WebApplicationContext webApplicationContext;
	   
	@Before   
	public void setUp() {
	   mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void getOneOk() throws Exception {
		String uri = "/wallet/1234";
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		   
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		
	}
	
	@Test
	public void thirdPartyOk() throws Exception {
		
		String uri = "/wallet/third_party";
				
		String inputJson = "{\r\n" + 
				"    \"identificador\": \"1234\",\r\n" + 
				"    \"saldo\": 9,\r\n" + 
				"    \"thirdParty\" : \"paypal\"\r\n" + 
				"}";
		
	    MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
	       .contentType(MediaType.APPLICATION_JSON_VALUE)
	       .content(inputJson)).andReturn();	
		   
		int status = mvcResult.getResponse().getStatus();
		assertEquals(202, status);
	}
}
