package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.MysqlOperation;

public class ExpressPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6550263182575632776L;
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
	private String id;
	private Calendar arrive;
	private Express kind;
	private double cost;
	private Calendar opTime;
	private String opName;
	
	public ExpressPO(String sender, String sendLoc, String receiver,
			String receiveLoc, String sendMobile, String receiveMobile,
			String sendPhone, String receivePhone, String sendUnit,
			String receiveUnit, int num, String name, double length,
			double width, double height, double weight, double volumn,
			String id, Calendar arrive, Express kind, double cost,
			Calendar opTime, String opName) {
		super();
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
		this.id = id;
		this.arrive = arrive;
		this.kind = kind;
		this.cost = cost;
		this.opTime = opTime;
		this.opName = opName;
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
	public Calendar getOpTime() {
		return opTime;
	}
	public String getOpName() {
		return opName;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command = null;
		switch(op){
		case INSERT:command="insert into expressorderwaiting values"+"("+"'"+id+"','"+sender+"','"+sendLoc+"','"+receiver+"','"+receiveLoc+"','"+sendMobile+"','"+receiveMobile+"','"+sendPhone+"','"+receivePhone+"','"+sendUnit+"','"+receiveUnit+"',"+num+",'"+name+"',"+length+","+width+","+height+","+volumn+","+DateFormat.DATE.format(arrive.getTime())+","+kind.ordinal()+","+cost+",'"+"null"+"',"+"null"+","+DateFormat.TIME.format(opTime.getTime())+"','"+opName+"')";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
}
