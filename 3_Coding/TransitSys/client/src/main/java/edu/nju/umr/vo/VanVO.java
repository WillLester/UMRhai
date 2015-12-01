package edu.nju.umr.vo;

import java.awt.Image;
import java.util.Calendar;

public class VanVO {
	private String id;
	private String plateNum;
	private Calendar startTime;
	private Calendar endTime;
	private String photoString;
	private String hallId;
	public VanVO(String id,String plateNum,Calendar startTime,Calendar endTime,String photoString,String hallId) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.plateNum = plateNum;
		this.startTime = startTime;
		this.endTime = endTime;
		this.photoString = photoString;
		this.hallId = hallId;
	}
	public String getId() {
		return id;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public Calendar getStartTime() {
		return startTime;
	}
	public Calendar getEndTime(){
		return endTime;
	}
	public String getPhoto() {
		return photoString;
	}
	public String getHallId() {
		return hallId;
	}
}
