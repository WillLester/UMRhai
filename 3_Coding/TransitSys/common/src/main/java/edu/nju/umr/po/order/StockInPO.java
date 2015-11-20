package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Part;

public class StockInPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5439986688631572343L;
	private String id;
	private String expressId;
	private Calendar date;
	private String arrivePlace;
	private Part part;
	private String shelfId;
	private int row;
	private int place;
	private Calendar opTime;
	
	public StockInPO(String id, String expressId, Calendar date,
			String arrivePlace, Part part, String shelfId, int row, int place,
			Calendar opTime) {
		super();
		this.id = id;
		this.expressId = expressId;
		this.date = date;
		this.arrivePlace = arrivePlace;
		this.part = part;
		this.shelfId = shelfId;
		this.row = row;
		this.place = place;
		this.opTime = opTime;
	}
	public String getId() {
		return id;
	}
	public String getExpressId() {
		return expressId;
	}
	public Calendar getDate() {
		return date;
	}
	public String getArrivePlace() {
		return arrivePlace;
	}
	public Part getPart() {
		return part;
	}
	public String getShelfId() {
		return shelfId;
	}
	public int getRow() {
		return row;
	}
	public int getPlace() {
		return place;
	}
	public Calendar getOpTime() {
		return opTime;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into stockinorderwaiting values"+"("+id+",'"+expressId+"','"+arrivePlace+"',"+part.ordinal()+","+shelfId+","+row+","+place+","+DateFormat.DATE.format(date.getTime())+","+DateFormat.TIME.format(opTime.getTime())+")";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
}
