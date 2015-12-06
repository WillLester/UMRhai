package edu.nju.umr.vo;

public class LocVO {
	private String cityName;
	private String province;
	public LocVO(String cityName, String province) {
		super();
		this.cityName = cityName;
		this.province = province;
	}
	public String getCityName() {
		return cityName;
	}
	public String getProvince() {
		return province;
	}
	
}
