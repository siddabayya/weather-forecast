package com.weather.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.weather.domain.GeoLocationRepository;
import com.weather.domain.WeatherForecastRepository;
import com.weather.exceptions.WeatherRequestException;
import com.weather.model.WeatherForecast;

@Component
public class WeatherForecastService {

	@Autowired
	protected RestTemplate restTemplate;

	@Autowired
	protected WeatherForecastRepository weatherForecastRepo;
	
	@Autowired
	protected GeoLocationRepository geoLocationRepo;

	@Value("${darksky.api.url}")
	private String apiURL;

	@Value("${darksky.api.key}")
	private String apiKey;

	public WeatherForecast getWeatherForecastByApi(Double latitude, Double longitude) throws WeatherRequestException {

		WeatherForecast weatherForecast = null;

		ResponseEntity<WeatherForecast> responseEntity = restTemplate.getForEntity(
				this.apiURL + "/forecast/" + this.apiKey + "/" + latitude + "," + longitude, WeatherForecast.class);
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			weatherForecast = responseEntity.getBody();
			weatherForecastRepo.save(weatherForecast);
			return weatherForecast;
		} else {
			throw new WeatherRequestException("Faild with status code: " + responseEntity.getStatusCodeValue());
		}

	}
}
