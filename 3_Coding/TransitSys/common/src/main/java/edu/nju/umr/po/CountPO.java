package edu.nju.umr.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

public class CountPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3831768397563399168L;
	private int id;
	private ArrayList<OrgPO> organizations;
	private ArrayList<WorkPO> workers;
	private ArrayList<VanPO> vans;
	private ArrayList<StockPO> stocks;
	private ArrayList<AccountPO> accounts;
	private Calendar opTime;
	
	public CountPO(int id, ArrayList<OrgPO> organizations,
			ArrayList<WorkPO> workers, ArrayList<VanPO> vans,
			ArrayList<StockPO> stocks, ArrayList<AccountPO> accounts,
			Calendar opTime) {
		super();
		this.id = id;
		this.organizations = organizations;
		this.workers = workers;
		this.vans = vans;
		this.stocks = stocks;
		this.accounts = accounts;
		this.opTime = opTime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<OrgPO> getOrganizations() {
		return organizations;
	}
	public ArrayList<WorkPO> getWorkers() {
		return workers;
	}
	public ArrayList<VanPO> getVans() {
		return vans;
	}
	public ArrayList<StockPO> getStocks() {
		return stocks;
	}
	public ArrayList<AccountPO> getAccounts() {
		return accounts;
	}
	public Calendar getOpTime() {
		return opTime;
	}
}
