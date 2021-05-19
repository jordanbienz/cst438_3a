package cst438hw3a.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.core.FanoutExchange;

import cst438hw3a.domain.City;
import cst438hw3a.domain.CityInfo;
import cst438hw3a.domain.CityRepository;
import cst438hw3a.domain.CountryRepository;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    
    @Autowired
    private CountryRepository countryRepository;
    
    @Autowired
    private WeatherService weatherService;
    
    @Autowired
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    private FanoutExchange fanout;
    
    public CityService(){}

    public CityService(CityRepository cityRepo, CountryRepository countryRepo, WeatherService weatherService){
        this.cityRepository = cityRepo;
        this.countryRepository = countryRepo;
        this.weatherService = weatherService;
    }

    public CityInfo getCityInfo(String cityName) {
        List<City> cities = cityRepository.findByName(cityName);
        if(cities.size()==0) {
            return null;
        } else  {
            City city = cities.get(0);

            return new CityInfo(city.getID(), city.getName(), city.getCountry().getName(),
                    city.getCountry().getCode(), city.getDistrict(), city.getPopulation(),
                    weatherService.getTimeAndTemp(cityName));
        }
    }
    
    public void requestReservation(
    		String cityName,
    		String level,
    		String email) {

    		String msg = "{\"cityName\": \""+ cityName +
    		"\" \"level\": \""+level+
    		"\" \"email\": \""+email+"\"}" ;
    		
    		System.out.println("Sending message:"+msg);
    		
    		rabbitTemplate.convertSendAndReceive(
    		fanout.getName(),
    		"", // routing key none.
    		msg);
    }
    
}