import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.demo.restaurant.api.RestaurantService;
import com.demo.restaurant.controller.RestaurantController;
import com.demo.restaurant.init.RestaurantApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=RestaurantApplication.class)
@WebMvcTest(controllers = RestaurantController.class)
public class RestaurantControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RestaurantService restaurantService;

	@Test
	public void testFindMaximumSatisfaction() throws Exception {
		ClassPathResource classPathResource = new ClassPathResource("data.txt");
		try {
			given(this.restaurantService.findMaximumSatisfaction(classPathResource.getFile())).willReturn(new Long(2493893));
			this.mockMvc.perform(get("/findMaximumSatisfaction").accept(MediaType.ALL)).andExpect(status().isOk()).andExpect(content().string("2493893"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

}
