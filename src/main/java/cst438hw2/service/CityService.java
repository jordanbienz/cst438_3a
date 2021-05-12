package cst438hw2.service;

import cst438hw2.domain.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private WeatherService weatherService;

    private CityInfo cityInfo;

    public CityInfo getCityInfo(String cityName) {
    	List<City> cities = cityRepository.findByName(cityName);
		if (cities.size() == 0) {
			return new CityInfo();
		}
		City city = cities.get(0);
		CityInfo cityInfo = new CityInfo();
		TempAndTime TempAndTime = weatherService.getTempAndTime(cityName);
		
        Country country = countryRepository.findByCode(city.getCountry());
        TempAndTime tempAndTime = weatherService.getTempAndTime(cityName);

        this.cityInfo = new CityInfo(city.getID(), city.getName(), city.getCountryCode(),
                country.getName(), city.getDistrict(),
                city.getPopulation(), tempAndTime );

        return this.cityInfo;

    }

    public CityService(){}


    public CityService(CityRepository cityRepo, CountryRepository countryRepo, WeatherService weatherService){

        this.cityRepository = cityRepo;
        this.countryRepository = countryRepo;
        this.weatherService = weatherService;

    }
}