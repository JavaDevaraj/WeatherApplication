package com.dev.weather.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;

/**
 * @author Devaraj
 *Sep 26, 2020
 * 
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {

	private static final long serialVersionUID = -6749989232657092106L;
	private String weatherDescription;
	private double minTemp;
	private double maxTemp;
	private String name;
	
	
	@Bean
	public Weather weather() {
		return new Weather();
	}
	
	public Weather() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Weather(Weather weather) {
		// TODO Auto-generated constructor stub
	}

	public String getWeatherDescription() {
		return weatherDescription;
	}

	public void setWeatherDescription(String weatherDescription) {
		this.weatherDescription = weatherDescription;
	}

	public double getMinTemp() {
		return minTemp;
	}

	@JsonProperty("temp_min")
	public void setMinTemp(double minTemp) {
		this.minTemp = minTemp;
	}

	public double getMaxTemp() {
		return maxTemp;
	}

	@JsonProperty("temp_max")
	public void setMaxTemp(double maxTemp) {
		this.maxTemp = maxTemp;
	}

	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	
	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setWeatherDescription((String) weather.get("description"));
	}
	
	@JsonProperty("main")
	public void setMain(Map<String, Object> main) {
		setMinTemp((double) main.get("temp_min"));
		setMaxTemp((double) main.get("temp_max"));
		
	}
	
}
