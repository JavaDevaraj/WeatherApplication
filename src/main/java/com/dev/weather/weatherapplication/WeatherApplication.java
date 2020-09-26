package com.dev.weather.weatherapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.dev.weather.controller.WeatherController;

/**
 * @author Devaraj
 *Sep 26, 2020
 * 
 */

@ComponentScan(basePackageClasses = WeatherController.class)
@SpringBootApplication
public class WeatherApplication 
{
    public static void main( String[] args )
    {
    	System.setProperty("spring.config.name", "weatherapplication");
    	SpringApplication.run(WeatherApplication.class, args);
    	
    }
}
