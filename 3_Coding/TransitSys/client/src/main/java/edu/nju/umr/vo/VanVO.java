package edu.nju.umr.vo;

import java.awt.Image;
import java.util.Calendar;

public class VanVO {
	private String id;
	private String plateNum;
	private Calendar servTime;
	private Image photo;
	private String hallId;
	public VanVO(String id,String plateNum,Calendar servTime,Image photo,String hallId) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.plateNum = plateNum;
		this.servTime = servTime;
		this.photo = photo;
		this.hallId = hallId;
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
	public String getHallId() {
		return hallId;
	}
}
