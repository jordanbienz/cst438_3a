package cst438hw2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cst438hw2.domain.City;
import cst438hw2.domain.CityRepository;
import cst438hw2.service.WeatherService;

@Controller
public class CityController {
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	WeatherService weatherService;

    @GetMapping("/cities/{city}")
    public String getCityInfo(@PathVariable("city") String cityName, Model model) {
    	List<City> cities = cityRepository.findByName(cityName);
    	if(cities.size()==0) {
    		return "city_not_found";
    	} else {
    		City city =cities.get(0);
    		
    		CityInfo cityWeather = weatherService.getWeather(city.getName());
    		
    		double tempF = Math.round((cityWeather.getTemp() - 273.35) * 9.0/5.0 + 32.0);
    		
    		cityWeather.setTemp(tempF);
    		city.setWeather(cityWeather);
    		
        	return "city_info";
    	}
    }
}
