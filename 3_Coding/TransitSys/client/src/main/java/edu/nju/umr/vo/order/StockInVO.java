package edu.nju.umr.vo.order;

import java.util.Calendar;

import edu.nju.umr.po.enums.Part;
import edu.nju.umr.ui.FunctionFrame;
import edu.nju.umr.ui.orderNewUI.StockInPanel;

public class StockInVO implements ShowOrder{
	private String id;
	private String expressId;
	private Calendar date;
	private String arrivePlace;
	private Part part;
	private String shelfId;
	private int row;
	private int place;
	private String opName;
	private String stockId;
	private String userId;
	public StockInVO(String id,String expressId,Calendar date,String arrivePlace,Part part,String shelfId,int row,int place,String opName,String stockId,String userId) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.expressId = expressId;
		this.date = date;
		this.arrivePlace = arrivePlace;
		this.part = part;
		this.shelfId = shelfId;
		this.row = row;
		this.place = place;
		this.opName = opName;
		this.stockId = stockId;
		this.userId = userId;
	}
	public String getId() {
		return id;
	}
	public String getStockId() {
		return stockId;
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
	public String getOpName() {
		return opName;
	}
	public String getUserId() {
		return userId;
	}
	public void Show(boolean isEnabled) {
		FunctionFrame ffr = new FunctionFrame("入库单");
		StockInPanel panel=new StockInPanel(ffr,this);
		panel.setEnabled(isEnabled);
		ffr.setContentPane(panel);
	}
	
}
