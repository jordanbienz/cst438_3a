package cst438hw2.domain;

public class CityInfo {
	
	private int cityId;
	private String cityName;
	private String countryCode;
	private String countryName;
	private String cityDistrict;
	private int cityPopulation;
	private String temp;
	private String time;
	private TempAndTime cityTempAndTime;
	
	public CityInfo () {
		
	}
	
	public CityInfo(int cityId, String cityName, String countryCode, String countryName, String cityDistrict,
			int cityPopulation, String temp, String time, TempAndTime cityTempAndTime) {
		this.cityId = cityId;
		this.cityName = cityName;
		this.countryCode = countryCode;
		this.countryName = countryName;
		this.cityDistrict = cityDistrict;
		this.cityPopulation = cityPopulation;
		this.temp = temp;
		this.time = time;
		this.cityTempAndTime = cityTempAndTime;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCityDistrict() {
		return cityDistrict;
	}

	public void setCityDistrict(String cityDistrict) {
		this.cityDistrict = cityDistrict;
	}

	public int getCityPopulation() {
		return cityPopulation;
	}

	public void setCityPopulation(int cityPopulation) {
		this.cityPopulation = cityPopulation;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public TempAndTime getCityTempAndTime() {
		return cityTempAndTime;
	}

	public void setCityTempAndTime(TempAndTime cityTempAndTime) {
		this.cityTempAndTime = cityTempAndTime;
	}

}
