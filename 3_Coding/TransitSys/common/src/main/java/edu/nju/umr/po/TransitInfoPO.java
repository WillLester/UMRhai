package edu.nju.umr.po;

import java.io.Serializable;
import java.util.ArrayList;

import edu.nju.umr.po.enums.MysqlOperation;

public class TransitInfoPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6853655204724204655L;
	private String expressid;
	private ArrayList<String> info;
	public TransitInfoPO(String expressid, ArrayList<String> info) {
		super();
		this.expressid = expressid;
		this.info = info;
	}
	public String getExpressid() {
		return expressid;
	}
	public ArrayList<String> getInfo() {
		return info;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command = null;
		switch(op){
		case INSERT:	
			String info = "";
			for(String inf:this.info){
				info = info + inf + ";";
			}
			command = "insert into transitinfo values" + "(" + "'" + expressid + "','" + info +"')";
			break;
		case UPDATE:
			info = "";
			for(String inf:this.info){
				info = info + inf + ";";
			}
			command = "update transitinfo set info='"+info+"' where id='"+expressid+"'";break;
		case FIND:
			command = "select * from transitinfo where id='"+expressid+"'";
			break;
		case DELETE:
			break;
		}
		return command;
	}
	
}
