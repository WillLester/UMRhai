package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Transit;

public class StockOutPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2102785279404595176L;
	private int id;
	private String expressId;
	private Calendar date;
	private Transit kind;
	private String transitId;
	private Calendar opTime;
	private String opName;
	private String stockId;
	
	public StockOutPO(int id, String expressId, Calendar date, Transit kind,
			String transitId, Calendar opTime, String opName, String stockId) {
		super();
		this.id = id;
		this.expressId = expressId;
		this.date = date;
		this.kind = kind;
		this.transitId = transitId;
		this.opTime = opTime;
		this.opName = opName;
		this.stockId = stockId;
	}
	public int getId() {
		return id;
	}
	public String getExpressId() {
		return expressId;
	}
	public Calendar getDate() {
		return date;
	}
	public Transit getKind() {
		return kind;
	}
	public String getTransitId() {
		return transitId;
	}
	public Calendar getOpTime() {
		return opTime;
	}
	public String getOpName() {
		return opName;
	}
	public String getStockId() {
		return stockId;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into stockoutwaiting values"+"("+id+",'"+expressId+"',"+kind.ordinal()+",'"+transitId+"','"+DateFormat.DATE.format(date.getTime())+"','"+DateFormat.TIME.format(opTime.getTime())+"','"+opName+"','"+stockId+"')";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
}
