package edu.nju.umr.po;

import java.io.Serializable;
import java.util.ArrayList;

public class CountPO implements Serializable{
	private String id;
	private ArrayList<OrgPO> organizations;
	private ArrayList<WorkPO> workers;
	private ArrayList<VanPO> vans;
	private ArrayList<StockPO> stocks;
	private ArrayList<AccountPO> accounts;
	public CountPO(String id,ArrayList<OrgPO> orgas,ArrayList<WorkPO> workers,ArrayList<VanPO> vans,ArrayList<StockPO> stocks,ArrayList<AccountPO> accounts) {
		// TODO 自动生成的构造函数存根
		this.id = id;
		this.organizations = orgas;
		this.workers = workers;
		this.vans = vans;
		this.stocks = stocks;
		this.accounts = accounts;
	}
	public String getId() {
		return id;
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
}
