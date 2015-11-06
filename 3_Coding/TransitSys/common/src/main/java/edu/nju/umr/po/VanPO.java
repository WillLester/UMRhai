package edu.nju.umr.po;

import java.awt.Image;
import java.io.Serializable;
import java.util.Calendar;

public class VanPO implements Serializable{
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
}
