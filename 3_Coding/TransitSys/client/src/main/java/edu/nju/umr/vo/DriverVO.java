package edu.nju.umr.vo;

import java.util.Date;

import edu.nju.umr.po.enums.Sex;

public class DriverVO {
	private String id;
	private String name;
	private Date birthday;
	private String idNum;
	private String mobile;
	private Sex sex;
	private Date driveLimit;
	public DriverVO(String id,String name,Date birthday,String idNum,String mobile,Sex sex,Date driveLimit) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.idNum = idNum;
		this.mobile = mobile;
		this.sex = sex;
		this.driveLimit = driveLimit;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public String getIdNum() {
		return idNum;
	}
	public String getMobile() {
		return mobile;
	}
	public Sex getSex() {
		return sex;
	}
	public Date getDriveLimit() {
		return driveLimit;
	}
	
}
