package segezha.AlcoholConverter;

import segezha.AlcoholConverter.Controllers.AlcoholConverterController;
import segezha.AlcoholConverter.Services.AlcoholConverterService;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class AlcoholConverterApplicationTests {

	private MockMvc mockMvc;
	@Autowired
	private AlcoholConverterService service;

	@Before
	@Autowired
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(new AlcoholConverterController(service)).build();
	}

	@Test
	public void testConversion() throws Exception {
		String res = this.mockMvc.perform(get("/convert?firstStrength=5.0&firstVolume=1000.0&secondStrenght=40.0")
						.accept(MediaType.parseMediaType("application/json")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andReturn().getResponse().getContentAsString();

		Assertions.assertEquals(Double.toString(service.alcoholConversion(5.0, 1000.0, 40.0)), res);
	}

	@Test
	public void testAmount() throws Exception {
		String res = this.mockMvc.perform(get("/amount?strength=5.0&volume=1000.0&gender=male&weight=80.0")
						.accept(MediaType.parseMediaType("application/json")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andReturn().getResponse().getContentAsString();

		String ans = String.format("%.3f", (service.alcoholAmount(5.0,
				1000.0, "male", 80.0)));
		Assertions.assertEquals(ans, res.substring(0, res.length() - 3));
	}

	@Test
	public void testElimination() throws Exception {
		String res = this.mockMvc.perform(get("/elimination?strength=5.0&volume=1000.0")
						.accept(MediaType.parseMediaType("application/json")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andReturn().getResponse().getContentAsString();

		Integer ans = service.eliminationTime(5.0, 1000.0);
		Assertions.assertEquals(ans / 60 + "h:" + ans % 60 + "m", res);
	}

	@Test
	public void testRussia() throws Exception {
		String res = this.mockMvc.perform(get("/Russia?strength=5.0&volume=1000.0")
						.accept(MediaType.parseMediaType("application/json")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andReturn().getResponse().getContentAsString();

		Integer ans = service.withdrawalRussia(5.0, 1000.0);
		Assertions.assertEquals(ans / 60 + "h:" + ans % 60 + "m", res);
	}

	@Test
	public void testGeorgia() throws Exception {
		String res = this.mockMvc.perform(get("/Georgia?strength=5.0&volume=1000.0")
						.accept(MediaType.parseMediaType("application/json")))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json"))
				.andReturn().getResponse().getContentAsString();

		Integer ans = service.withdrawalGeorgia(5.0, 1000.0);
		Assertions.assertEquals(ans / 60 + "h:" + ans % 60 + "m", res);
	}
}

