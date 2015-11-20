package edu.nju.umr.po;

import java.io.Serializable;

import edu.nju.umr.po.enums.MysqlOperation;
import edu.nju.umr.po.enums.Part;

public class ShelfPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8063864393327534721L;
	private String id;
	private String stockId;
	private int row;
	private int place;
	private Part part;
	
	public ShelfPO(String id, String stockId, int row, int place, Part part) {
		super();
		this.id = id;
		this.stockId = stockId;
		this.row = row;
		this.place = place;
		this.part = part;
	}

	public String getId() {
		return id;
	}
	
	public String getStockId() {
		return stockId;
	}
	public int getRow() {
		return row;
	}
	public int getPlace() {
		return place;
	}
	public Part getPart() {
		return part;
	}

	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into shelf values"+"('"+id+"','"+stockId+"',"+row+","+place+","+part.ordinal()+")";break;
		case DELETE:command="delete from shelf where id='"+id+"'";break;
		case FIND:break;
		case UPDATE:command="update shelf set stockId='"+stockId+"' row="+row+" place="+place+" part="+part.ordinal()+" where id='"+id+"'";break;
		}
		return command;
	}
}
