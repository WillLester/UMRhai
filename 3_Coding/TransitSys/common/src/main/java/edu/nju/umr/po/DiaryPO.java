package edu.nju.umr.po;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.enums.MysqlOperation;

public class DiaryPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1403096551316019080L;
	private String operation;
	private Calendar time;
	private String operator;
	
	public DiaryPO(String operation, Calendar time, String operator) {
		super();
		this.operation = operation;
		this.time = time;
		this.operator = operator;
	}
	public String getOperation() {
		return operation;
	}
	public Calendar getTime() {
		return time;
	}
	public String getOperator() {
		return operator;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:command="insert into diary values"+"("+DateFormat.TIME.format(time.getTime())+","+"'"+operation+"','"+operator+"')";break;
		case DELETE:break;
		case FIND:break;
		case UPDATE:break;
		}
		return command;
	}
}
