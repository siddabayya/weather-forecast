package com.weather.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.weather.exceptions.WeatherRequestException;
import com.weather.model.ForecastResponse;
import com.weather.service.WeatherForecastService;

@Controller
public class WeatherDashboardController {

	private static final Logger logger = LogManager.getLogger(WeatherDashboardController.class);

	@Autowired
	protected WeatherForecastService weatherForecastService;

	@GetMapping("/weather/{latitude}/{longitude}")
	public String greeting(@PathVariable(name = "latitude", required = true) Double latitude,
			@PathVariable(name = "longitude", required = true) Double longitude, Model model)
			throws WeatherRequestException {

		ForecastResponse forecast = weatherForecastService.getWeatherForecastByApi(latitude, longitude);
		model.addAttribute("forecast", forecast);
		return "dashboard";
	}

	// Exception handler for API service
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Application has encountered an error")
	@ExceptionHandler({ WeatherRequestException.class, Exception.class })
	public void apiError(HttpServletRequest req, Exception ex) {
		logger.error("Request: " + req.getRequestURL() + " raised " + ex);
	}
}
