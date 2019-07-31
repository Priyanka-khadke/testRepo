package gateway.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import gateway.GreetingController;

@RunWith(SpringRunner.class)
@WebMvcTest(value = GreetingController.class, secure = false)
public class GreetingControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testController() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/greeting/helloworld")
				.accept(MediaType.APPLICATION_JSON);
		for(int i=0; i<10; i++) {
			System.out.println(System.currentTimeMillis());
			mockMvc.perform(requestBuilder).andExpect(status().isOk());
		}
	}

}
