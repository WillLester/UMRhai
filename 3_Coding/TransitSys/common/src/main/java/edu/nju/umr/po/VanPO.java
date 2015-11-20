package edu.nju.umr.po;

import java.awt.Image;
import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.enums.MysqlOperation;

public class VanPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6047653171693221715L;
	private String id;
	private String plateNum;
	private Calendar servTime;
	private Image photo;
	private String orgId;
	public VanPO(String id,String plateNum,Calendar servTime,Image photo,String orgId) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.plateNum = plateNum;
		this.servTime = servTime;
		this.photo = photo;
		this.orgId = orgId;
	}
	public String getId() {
		return id;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public Calendar getServTime() {
		return servTime;
	}
	public Image getPhoto() {
		return photo;
	}
	public String getOrgId() {
		return orgId;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into van values"+"("+"'"+id+"','"+plateNum+"','"+DateFormat.DATE.format(servTime.getTime())+"','"+photo+"','"+orgId+"'"+")";break;
		case DELETE:command="delete from van where id='"+id+"'";break;
		case FIND:break;
		case UPDATE:command="update van set plateNum='"+plateNum+"' servTime='"+DateFormat.DATE.format(servTime.getTime())+"' orgId='"+orgId+"' where id='"+id+"'";break;
		}
		return command;
	}
}
