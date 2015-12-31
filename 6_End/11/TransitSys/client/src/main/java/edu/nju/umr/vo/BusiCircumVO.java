package edu.nju.umr.vo;

import java.math.BigDecimal;
import java.util.Calendar;

import edu.nju.umr.po.enums.Pay;

public class BusiCircumVO {
	private int type;//0代表收款单，1代表付款单
	private Calendar date;
	private BigDecimal amount;
	private Pay kind;
	
	/**
	 * 经营情况表用的VO
	 * @param kind 0代表收款单，1代表付款单
	 * @param date 时间
	 * @param amount 数额
	 * @param remark 备注
	 */
	public BusiCircumVO(int kind,Calendar date,BigDecimal amount,Pay remark){
		this.type=kind;
		this.date=date;
		this.amount=amount;
		this.kind=remark;
	}
	
	public int getKind(){
		return type;
	}
	
	public Calendar getDate(){
		return date;
	}
	
	public BigDecimal getAmount(){
		return amount;
	}
	
	public Pay getRemark(){
		return kind;
	}
}
