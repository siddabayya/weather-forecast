package com.weather;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.weather.service.WeatherForecastService;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WeatherForecastServiceTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Autowired
	protected WeatherForecastService weatherForecastService;

	@Test
	public void watherForecastShouldReturnTimezone() throws Exception {
		
		assertThat(weatherForecastService.getWeatherForecastByApi(37.8267, -122.4233)).hasFieldOrProperty("timezone");
	}
}