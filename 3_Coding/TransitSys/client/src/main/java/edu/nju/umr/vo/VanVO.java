package edu.nju.umr.vo;

import java.awt.Image;
import java.util.Date;

public class VanVO {
	private String id;
	private String plateNum;
	private Date servTime;
	private Image photo;
	private String orgId;
	public VanVO(String id,String plateNum,Date servTime,Image photo,String orgId) {
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
	public Date getServTime() {
		return servTime;
	}
	public Image getPhoto() {
		return photo;
	}
	public String getOrgId() {
		return orgId;
	}
}
