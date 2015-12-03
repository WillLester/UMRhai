package edu.nju.umr.vo.order;

import java.util.Calendar;

import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.Parse;

public class ExpressVO {
	protected String id;
	protected String sender;
	protected String sendLoc;
	protected String receiver;
	protected String receiveLoc;
	protected String sendMobile;
	protected String receiveMobile;
	protected String sendPhone;
	protected String receivePhone;
	protected String sendUnit;
	protected String receiveUnit;
	protected int num;
	protected String name;
	protected double length;
	protected double width;
	protected double height;
	protected double weight;
	protected double volumn;
//	protected String id;
	protected Calendar arrive;
	protected Calendar createDate;
	protected Express kind;
	protected double cost;
	protected String opName;
	protected Parse parse;
	protected String sendProvince;
	protected String sendCity;
	protected String receiveProvince;
	protected String receiveCity;
	protected String userId;
	
	
	public ExpressVO(String id, String sender, String sendLoc, String receiver,
			String receiveLoc, String sendMobile, String receiveMobile,
			String sendPhone, String receivePhone, String sendUnit,
			String receiveUnit, int num, String name, double length,
			double width, double height, double weight, double volumn,
			Calendar arrive, Calendar createDate, Express kind, double cost,
			String opName,Parse parse,String sendProvince,String sendCity,
			String receiveProvince,String receiveCity,String userId) {
		super();
		this.id = id;
		this.sender = sender;
		this.sendLoc = sendLoc;
		this.receiver = receiver;
		this.receiveLoc = receiveLoc;
		this.sendMobile = sendMobile;
		this.receiveMobile = receiveMobile;
		this.sendPhone = sendPhone;
		this.receivePhone = receivePhone;
		this.sendUnit = sendUnit;
		this.receiveUnit = receiveUnit;
		this.num = num;
		this.name = name;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.volumn = volumn;
		this.arrive = arrive;
		this.createDate = createDate;
		this.kind = kind;
		this.cost = cost;
		this.opName = opName;
		this.parse = parse;
		this.sendProvince = sendProvince;
		this.sendCity = sendCity;
		this.receiveProvince = receiveProvince;
		this.receiveCity = receiveCity;
		this.userId = userId;
	}
	public String getId(){
		return id;
	}
	public String getSender() {
		return sender;
	}
	public String getSendLoc() {
		return sendLoc;
	}
	public String getReceiver() {
		return receiver;
	}
	public String getReceiveLoc() {
		return receiveLoc;
	}
	public String getSendMobile() {
		return sendMobile;
	}
	public String getReceiveMobile() {
		return receiveMobile;
	}
	public int getNum() {
		return num;
	}
	public String getName() {
		return name;
	}
	public double getLength() {
		return length;
	}
	public double getWidth() {
		return width;
	}
	public double getHeight() {
		return height;
	}
	public double getWeight() {
		return weight;
	}
	public double getVolumn() {
		return volumn;
	}
	public Calendar getArrive() {
		return arrive;
	}
	public Express getKind() {
		return kind;
	}
	public double getCost() {
		return cost;
	}
	public String getSendPhone() {
		return sendPhone;
	}
	public String getReceivePhone() {
		return receivePhone;
	}
	public String getSendUnit() {
		return sendUnit;
	}
	public String getReceiveUnit() {
		return receiveUnit;
	}
	public String getOpName(){
		return opName;
	}
	public Calendar getCreateDate() {
		return createDate;
	}
	public Parse getParse() {
		return parse;
	}
	public String getSendProvince() {
		return sendProvince;
	}
	public String getSendCity() {
		return sendCity;
	}
	public String getReceiveProvince() {
		return receiveProvince;
	}
	public String getReceiveCity() {
		return receiveCity;
	}
	public String getUserId() {
		return userId;
	}
	
	
}
