package edu.nju.umr.vo;

public class CitiesVO {
	private String city1;
	private String city2;
	private int distance;
	private double price;
	public CitiesVO(String city1,String city2,int distance,double price) {
		// TODO 自动生成的构造函数存根
		this.city1 = city1;
		this.city2 = city2;
		this.distance = distance;
		this.price = price;
	}
	public String getCity1() {
		return city1;
	}
	public String getCity2() {
		return city2;
	}
	public int getDistance() {
		return distance;
	}
	public double getPrice() {
		return price;
	}
}
