package edu.nju.umr.po;

import java.util.ArrayList;

public class TransitInfoPO {
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
	
}
