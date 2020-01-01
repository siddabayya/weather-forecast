package com.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.weather.exceptions.WeatherRequestException;
import com.weather.model.ForecastResponse;

@Component
public class WeatherForecastService {

	@Autowired
	protected RestTemplate restTemplate;

	@Value("${darksky.api.url}")
	private String apiURL;

	@Value("${darksky.api.key}")
	private String apiKey;

	public ForecastResponse getWeatherForecastByApi(Double latitude, Double longitude) throws WeatherRequestException {

		ResponseEntity<ForecastResponse> responseEntity = restTemplate.getForEntity(
				this.apiURL + "/forecast/" + this.apiKey + "/" + latitude + "," + longitude, ForecastResponse.class);
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			return responseEntity.getBody();
		} else {
			throw new WeatherRequestException("Faild with status code: " + responseEntity.getStatusCodeValue());
		}

	}
}
