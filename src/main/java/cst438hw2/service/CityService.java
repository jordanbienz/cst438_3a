package cst438hw2.service;

import cst438hw2.domain.City;
import cst438hw2.domain.CityInfo;
import cst438hw2.domain.CityRepository;
import cst438hw2.domain.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private WeatherService weatherService;

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

    public CityService(){}


    public CityService(CityRepository cityRepo, CountryRepository countryRepo, WeatherService weatherService){

        this.cityRepository = cityRepo;
        this.countryRepository = countryRepo;
        this.weatherService = weatherService;

    }


}