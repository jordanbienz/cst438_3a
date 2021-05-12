package cst438hw2.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="city")
public class City {

	@Id
	private int ID;
	private String name;
	private String district;
	private int population;
	
	@Transient
	CityWeather waether;
	
	@ManyToOne
	@JoinColumn(name="countryCode", refrenceCoulmnName="code")
	private Country country;
	
	public City() {}

	public City(int iD, String name, String district, int population, Country country) {
		super();
		ID = iD;
		this.name = name;
		this.district = district;
		this.population = population;
		this.country = country;
	}
	
	
	
	
	
}
