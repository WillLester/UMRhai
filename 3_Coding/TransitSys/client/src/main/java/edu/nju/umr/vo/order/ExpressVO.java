package edu.nju.umr.vo.order;

import java.util.Calendar;

import edu.nju.umr.po.enums.Express;

public class ExpressVO {
	private String id;
	private String sender;
	private String sendLoc;
	private String receiver;
	private String receiveLoc;
	private String sendMobile;
	private String receiveMobile;
	private String sendPhone;
	private String receivePhone;
	private String sendUnit;
	private String receiveUnit;
	private int num;
	private String name;
	private double length;
	private double width;
	private double height;
	private double weight;
	private double volumn;
//	private String id;
	private Calendar arrive;
	private Calendar createDate;
	private Express kind;
	private double cost;
	private String opName;
	
	
	public ExpressVO(String id, String sender, String sendLoc, String receiver,
			String receiveLoc, String sendMobile, String receiveMobile,
			String sendPhone, String receivePhone, String sendUnit,
			String receiveUnit, int num, String name, double length,
			double width, double height, double weight, double volumn,
			Calendar arrive, Calendar createDate, Express kind, double cost,
			String opName) {
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
	
	
}
