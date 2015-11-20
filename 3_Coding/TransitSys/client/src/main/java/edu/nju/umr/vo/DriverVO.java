package edu.nju.umr.vo;

import java.util.Calendar;
import java.util.Date;

import edu.nju.umr.po.enums.Gender;

public class DriverVO {
	private String id;
	private String name;
	private Calendar birthday;
	private String idNum;
	private String mobile;
	private Gender sex;
	private Calendar driveStart;
	private Calendar driveEnd;
	public DriverVO(String id,String name,Calendar birthday,String idNum,String mobile,Gender sex,Calendar driveStart,Calendar driveEnd) {
		// TODO 自动生成的构造函数存根
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
	public Gender getSex() {
		return sex;
	}
	public Calendar getDriveStart() {
		return driveStart;
	}
	public Calendar getDriveEnd() {
		return driveEnd;
	}
	public String[] getData(){
		String gen=null;
		if(sex.equals(Gender.MAN))
			gen="男";
		else gen="女";
		String [] data={id,name,birthday.toString(),idNum,mobile,gen,driveStart.toString(),driveEnd.toString()};
		return data;
	}
	
}
