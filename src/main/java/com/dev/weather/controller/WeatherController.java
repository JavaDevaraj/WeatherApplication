package com.dev.weather.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.dev.weather.model.City;
import com.dev.weather.model.Weather;
import com.dev.weather.model.WeatherUrl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Devaraj
 *Sep 26, 2020
 * 
 */

@ComponentScan("com.dev.weather.config")
	@Controller
	public class WeatherController {
		
		@Autowired
		RestTemplate restTemp;
		
		@Autowired
		private WeatherUrl weatherData;
		
		@GetMapping("/weather")
		public String CityForm(Model model) {
			
			model.addAttribute("city", new City());
			return "homePage";
		}
		
		@PostMapping(path = "/weather")
		public String getWeather(Model model, @ModelAttribute City city) 
				throws JsonParseException, JsonMappingException, IOException {
			
			UriComponents uriComponents = UriComponentsBuilder
					.newInstance()
					.scheme("http")
					.host(weatherData.getUrl())
				    .path("")
				    .query("q={keyword}&appid={appid}")
				    .buildAndExpand(city.getCityName(),weatherData.getApiKey());
			
			String uri = uriComponents.toUriString();
			
			ResponseEntity<String> resp= restTemp.exchange(uri, HttpMethod.GET, null, String.class);
			
			ObjectMapper mapper = new ObjectMapper();
			Weather weather = mapper.readValue(resp.getBody(), Weather.class);
			model.addAttribute("weatherData", weather);	
			
			return "weatherDetails";
		}
		
		
	}
