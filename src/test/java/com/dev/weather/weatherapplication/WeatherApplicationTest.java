package com.dev.weather.weatherapplication;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author Devaraj
 *Sep 26, 2020
 * 
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WeatherApplication.class)
public class WeatherApplicationTest {

	
	@Test
	public void testWeatherAPI() {
	    UriComponents uriComponents = UriComponentsBuilder.newInstance()
	      .scheme("http").host("api.openweathermap.org/data/2.5/weather")
	      .path("").query("q={keyword}&appid={appid}").buildAndExpand("chicago","ba2e26157dd2d87c9ac4ff1a959d8e8c");
	 
	     assertEquals("http://api.openweathermap.org/data/2.5/weather?q=chicago&appid=ba2e26157dd2d87c9ac4ff1a959d8e8c", uriComponents.toUriString());

	}
}
	