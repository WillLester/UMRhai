package edu.nju.umr.po;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.po.enums.Sex;

public class DriverPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4935237408049381962L;
	private String id;
	private String name;
	private Calendar birthday;
	private String idNum;
	private String mobile;
	private Sex sex;
	private Calendar driveStart;
	private Calendar driveEnd;
	
	public DriverPO(String id, String name, Calendar birthday, String idNum,
			String mobile, Sex sex, Calendar driveStart, Calendar driveEnd) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.idNum = idNum;
		this.mobile = mobile;
		this.sex = sex;
		this.driveStart = driveStart;
		this.driveEnd = driveEnd;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public Calendar getBirthday() {
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
	public Calendar getDriveStart() {
		return driveStart;
	}
	public Calendar getDriveEnd() {
		return driveEnd;
	}
	
}
