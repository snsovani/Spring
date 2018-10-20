package com.kp.SpringBootRest;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@WebMvcTest(Application.class)
public class ApplicationTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private Application appController;
	
	@Test
	   public void getHello() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/hello").accept(MediaType.TEXT_PLAIN);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		

		System.out.println("RESULT :"+result.getResponse().getContentAsString());
		String expected = "Hello spring boot rest World";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		assertEquals(expected, result.getResponse().getContentAsString());
		
	   }

}
