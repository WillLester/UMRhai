package edu.nju.umr.po.order;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.PO;
import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.order.function.GetToday;
import edu.nju.umr.po.order.function.KindGetter;
import edu.nju.umr.po.order.function.OrderOper;

public class StockInPO extends PO implements Serializable,KindGetter,OrderOper,GetToday{
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
	private String opName;
	private String stockId;
	private String userId;
	
	public StockInPO(String id, String expressId, Calendar date,
			String arrivePlace, Part part, String shelfId, int row, int place,
			Calendar opTime, String opName, String stockId,String userId) {
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
		this.opName = opName;
		this.stockId = stockId;
		this.userId = userId;
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
	
	public String getOpName() {
		return opName;
	}
	public String getStockId() {
		return stockId;
	}
	public String getUserId() {
		return userId;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into stockinorderwaiting values"+"("+id+",'"+expressId+"','"+arrivePlace+"',"+
		part.ordinal()+","+shelfId+","+row+","+place+",'"+DateFormat.DATE.format(date.getTime())+"','"+
				DateFormat.TIME.format(opTime.getTime())+"','"+opName+"','"+stockId+"','"+userId+"')";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
	@Override
	public Order getOrderKind() {
		// TODO 自动生成的方法存根
		return Order.STOCKIN;
	}
	@Override
	public String getApprove(boolean isPassed) {
		// TODO 自动生成的方法存根
		if(isPassed){
			return "insert into stockinorderpassed select * from stockinorderwaiting where id="+id;
		} else {
			return "insert into stockinorderunpassed select * from stockinorderwaiting where id="+id;
		}
	}
	@Override
	public String getDeleteWaiting() {
		// TODO 自动生成的方法存根
		return "delete from stockinorderwaiting where id="+id;
	}
	@Override
	public String getDeleteUnpassed() {
		// TODO 自动生成的方法存根
		return "delete from stockinorderunpassed where userId='"+userId+"'";
	}
	@Override
	public String getDetail() {
		// TODO 自动生成的方法存根
		return "select * from stockinorderwaiting where id="+id;
	}
	@Override
	public String getUnpassed() {
		// TODO 自动生成的方法存根
		return "select * from stockinorderunpassed where userId='"+userId+"'";
	}
	@Override
	public String getToday() {
		// TODO 自动生成的方法存根
		return "select * from stockinorderwaiting,stockinorderpassed,stockinorderunpassed "
				+ "where stockinorderwaiting.id like '%"+id+"%' or stockinorderpassed.id like '%"+id+"%' "
						+ "or stockinorderunpassed.id like '%"+id+"%'";
	}
}
