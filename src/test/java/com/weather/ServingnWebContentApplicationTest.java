/*
 * Copyright 2012-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.weather;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

import com.weather.config.ApplicationConfig;
import com.weather.controller.WeatherDashboardController;
import com.weather.model.WeatherForecast;
import com.weather.service.WeatherForecastService;

@SpringBootTest
@Import(ApplicationConfig.class)
public class ServingnWebContentApplicationTest {


	@MockBean
	protected WeatherForecastService weatherForecastService;
	
	@Autowired
	WeatherDashboardController weatherDashboardController;

	@MockBean
	WeatherForecast weatherForecast;

	@Test
	public void weatherControllerIsCreated() throws Exception {
		assertThat(weatherDashboardController).isNotNull();
	}

}
