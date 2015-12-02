package edu.nju.umr.po;

import java.io.Serializable;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.po.enums.MysqlOperation;

public class VanPO extends PO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6047653171693221715L;
	private String id;
	private String plateNum;
	private Calendar servTime;
	private String photo;
	private String hallId;
	
	public VanPO(String id, String plateNum, Calendar servTime, String photo,
			String hallId) {
		super();
		this.id = id;
		this.plateNum = plateNum;
		this.servTime = servTime;
		this.photo = photo;
		this.hallId = hallId;
	}
	public String getId() {
		return id;
	}
	public String getPlateNum() {
		return plateNum;
	}
	public Calendar getServTime() {
		return servTime;
	}
	public String getPhoto() {
		return photo;
	}
	public String getHallId() {
		return hallId;
	}
	@Override
	public String getCommand(MysqlOperation op) {
		// TODO 自动生成的方法存根
		String command=null;
		switch(op){
		case INSERT:
			command="insert into van values"+"("+"'"+id+"','"+plateNum+"','"+DateFormat.DATE.format(servTime.getTime())+"','"+"vanImage/"+hallId+"/"+id+".jpg"+"','"+hallId+"')";break;
		case DELETE:command="delete from van where id='"+id+"'";break;
		case FIND:
			if(id == null){
				command = "select * from van where hallId = '"+hallId+"'";
			} else {
				command="select * from van where id like '%"+id+"%' or plateNum like '%"+plateNum+"%' and hallId='"+hallId+"'";
			}
			break;
		case UPDATE:command="update van set plateNum='"+plateNum+"',servTime='"+DateFormat.DATE.format(servTime.getTime())+"',photo = 'vanImage/"+hallId+"/"+id+".jpg"+"',hallId = '"+hallId+"' where id='"+id+"'";break;
		}
		return command;
	}
}
