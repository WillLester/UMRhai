package edu.nju.umr.po;

import java.io.Serializable;

import edu.nju.umr.po.enums.MysqlOperation;

public class CitiesPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2284621881561095776L;
	private String city1;
	private String city2;
	private double distance;
	public CitiesPO(String city1,String city2,double distance) {
		// TODO 自动生成的构造函数存根
		this.city1 = city1;
		this.city2 = city2;
		this.distance = distance;
	}
	public String getCity1() {
		return city1;
	}
	public String getCity2() {
		return city2;
	}
	public double getDistance() {
		return distance;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command = "insert into citiesInfo values"+"('"+city1+"','"+city2+"',"+distance+")";break;
		case DELETE:
			if(city2 == null)
				command = "delete from citiesInfo where city1='" + city1+"'";
			else
				command = "delete from citiesInfo where city2='" + city2+"'";
			break;
		case FIND:break;
		case UPDATE:command = "update citiesInfo set distance ="+distance+" where city1 = '"+city1+"' and city2 = '"+city2+"'";break;
		}
		return command;
	}
}
