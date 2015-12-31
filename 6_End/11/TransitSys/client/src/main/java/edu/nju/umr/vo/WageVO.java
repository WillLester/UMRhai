package edu.nju.umr.vo;

import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Wage;

public class WageVO {
	private String name;
	private Jurisdiction juri;
	private Wage kind;
	private int wage;
	private int commission;
	public WageVO(String name, Jurisdiction juri, Wage kind, int wage,
			int commission) {
		super();
		this.name = name;
		this.juri = juri;
		this.kind = kind;
		this.wage = wage;
		this.commission = commission;
	}
	public String getName() {
		return name;
	}
	public Jurisdiction getJuri() {
		return juri;
	}
	public Wage getKind() {
		return kind;
	}
	public int getWage() {
		return wage;
	}
	public int getCommission() {
		return commission;
	}
	
}
