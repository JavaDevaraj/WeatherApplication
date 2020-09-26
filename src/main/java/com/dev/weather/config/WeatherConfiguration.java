package com.dev.weather.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.dev.weather.model.WeatherUrl;

/**
 * @author Devaraj
 *Sep 26, 2020
 * 
 */

@Configuration
@PropertySource("classpath:wealthapplication.yml")
@ComponentScan
public class WeatherConfiguration {
	
	@Value("${weather.url}")
	private String url;
	
	@Value("${weather.apikey}")
	private String apikey;
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {

		PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
		c.setIgnoreUnresolvablePlaceholders(true);
		return c;
	}

	@Bean
	public WeatherUrl weatherUrl() {
		
		WeatherUrl weatherUrl = new WeatherUrl();
		weatherUrl.setUrl(url);
		weatherUrl.setApiKey(apikey);
		return weatherUrl;
	}
	
}

