package edu.bit.board.controller;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
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

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTest {
	
	@Setter(onMethod_= {@Autowired})
	private WebApplicationContext ctx;//이 ctx는 스프링에서 가져온다(다른말로 IOC컨테이너에서 가져온다)
	
	private MockMvc mocMvc;

	@Before
	public void setup() {
		this.mocMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	/*
	 @GetMapping("/list")
	 public void list(Model model) {	
		 log.info("list");
		 model.addAttribute("list", service.getList());	
	 }*/
	
	
	@Test
	public void testList() throws Exception {
		 mocMvc.perform(get("/list"))
		 .andExpect(status().isOk())//응답검증
		 .andDo(print())
         .andExpect(forwardedUrl("/WEB-INF/views/list.jsp"));
	}

}
