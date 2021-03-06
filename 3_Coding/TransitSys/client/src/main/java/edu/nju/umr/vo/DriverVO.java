package edu.nju.umr.vo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
	private String hallId;
	public DriverVO(String id,String name,Calendar birthday,String idNum,String mobile,Gender sex,Calendar driveStart,Calendar driveEnd,String hallId) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.idNum = idNum;
		this.mobile = mobile;
		this.sex = sex;
		this.driveStart = driveStart;
		this.driveEnd = driveEnd;
		this.hallId = hallId;
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
	public String getHallId() {
		return hallId;
	}
	public String[] getData(){
		String gen=null;
		if(sex.equals(Gender.MAN))
			gen="男";
		else gen="女";
		SimpleDateFormat myFmt=new SimpleDateFormat("yyyy年MM月dd日 ");
		String [] data={id,name,myFmt.format(birthday.getTime()),idNum,mobile,gen,myFmt.format(driveStart.getTime()),myFmt.format(driveEnd.getTime()),hallId};
		return data;
	}
	
}
