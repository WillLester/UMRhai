package edu.nju.umr.vo.order;

import java.util.Calendar;

import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.Parse;

public class ReceiveVO extends ExpressVO{
	private String realReceiver;
	private Calendar receiveTime;
	public ReceiveVO(String id, String sender, String sendLoc, String receiver,
			String receiveLoc, String sendMobile, String receiveMobile,
			String sendPhone, String receivePhone, String sendUnit,
			String receiveUnit, int num, String name, double length,
			double width, double height, double weight, double volumn,
			Calendar arrive, Calendar createDate, Express kind, double cost,
			String opName, Parse parse, String sendProvince, String sendCity,
			String receiveProvince, String receiveCity,String realReceiver,Calendar receiveTime) {
		super(id, sender, sendLoc, receiver, receiveLoc, sendMobile, receiveMobile,
				sendPhone, receivePhone, sendUnit, receiveUnit, num, name, length,
				width, height, weight, volumn, arrive, createDate, kind, cost, opName,
				parse, sendProvince, sendCity, receiveProvince, receiveCity);
		// TODO 自动生成的构造函数存根
		this.realReceiver = realReceiver;
		this.receiveTime = receiveTime;
	}
	public String getRealReceiver() {
		return realReceiver;
	}
	public Calendar getReceiveTime() {
		return receiveTime;
	}

}
