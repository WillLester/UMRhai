package edu.nju.umr.po.order;

import java.util.Date;

import edu.nju.umr.po.enums.Express;

public class ExpressPO {
	private String sender;
	private String sendLoc;
	private String receiver;
	private String receiveLoc;
	private String sendMobile;
	private String receiveMobile;
	private int num;
	private String name;
	private double length;
	private double width;
	private double height;
	private double weight;
	private double volumn;
	private String id;
	private Date arrive;
	private Express kind;
	private double cost;
	public ExpressPO(String sender,String sendLoc,String receiver,String receiveLoc,String sendMobile,String receiveMobile,
			int num,String name,double length,double width, double height, double weight,double volumn,String id,Date arrive,Express kind,double cost) {
		// TODO 自动生成的构造函数存根
		this.sender = sender;
		this.sendLoc = sendLoc;
		this.receiver = receiver;
		this.receiveLoc = receiveLoc;
		this.sendMobile = sendMobile;
		this.receiveMobile = receiveMobile;
		this.num = num;
		this.name = name;
		this.length = length;
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.volumn = volumn;
		this.id = id;
		this.arrive = arrive;
		this.kind = kind;
		this.cost = cost;
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
	public String getId() {
		return id;
	}
	public Date getArrive() {
		return arrive;
	}
	public Express getKind() {
		return kind;
	}
	public double getCost() {
		return cost;
	}
}
