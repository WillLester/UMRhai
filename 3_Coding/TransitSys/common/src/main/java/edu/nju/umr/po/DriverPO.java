package edu.nju.umr.po;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.enums.Gender;
import edu.nju.umr.po.enums.MysqlOperation;

public class DriverPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4935237408049381962L;
	private String id;
	private String name;
	private Calendar birthday;
	private String idNum;
	private String mobile;
	private Gender sex;
	private Calendar driveStart;
	private Calendar driveEnd;
	private String hallId;
	
	public DriverPO(String id, String name, Calendar birthday, String idNum,
			String mobile, Gender sex, Calendar driveStart, Calendar driveEnd,
			String hallId) {
		super();
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
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into driver values"+"("+"'"+id+"','"+name+"','"+idNum+"','"+mobile+"',"+sex.ordinal()+",'"+DateFormat.DATE.format(birthday.getTime())+"','"+DateFormat.DATE.format(driveStart.getTime())+"','"+DateFormat.DATE.format(driveEnd.getTime())+"','"+hallId+"')";break;
		case DELETE:command="delete from driver where id='"+id+"'";break;
		case FIND:
			if(id == null){
				command = "select * from driver where hallId = '"+hallId+"'";
			} else {
				command = "select * from driver where id like %"+id+"% or name like %"+name+"% and hallId ='"+hallId+"'";
			}
			break;
		case UPDATE:command = "update driver set name='"+name+"' idNum='"+idNum+"' mobile='"+mobile+"' sex="+sex.ordinal()+" birthday='"+DateFormat.DATE.format(birthday.getTime())+"' driveStart='"+DateFormat.DATE.format(driveStart.getTime())+"' driveEnd='"+DateFormat.DATE.format(driveEnd.getTime())+"' hallId ='"+hallId+"' where id='"+id+"'";break;
		}
		return command;
	}
	
}
