package edu.nju.umr.vo;

import java.util.ArrayList;

public class CountVO {
	private String id;
	private ArrayList<OrgVO> organizations;
	private ArrayList<WorkVO> workers;
	private ArrayList<VanVO> vans;
	private ArrayList<StockVO> stocks;
	private ArrayList<AccountVO> accounts;
	public CountVO(String id,ArrayList<OrgVO> orgas,ArrayList<WorkVO> workers,ArrayList<VanVO> vans,ArrayList<StockVO> stocks,ArrayList<AccountVO> accounts) {
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
	public ArrayList<OrgVO> getOrganizations() {
		return organizations;
	}
	public ArrayList<WorkVO> getWorkers() {
		return workers;
	}
	public ArrayList<VanVO> getVans() {
		return vans;
	}
	public ArrayList<StockVO> getStocks() {
		return stocks;
	}
	public ArrayList<AccountVO> getAccounts() {
		return accounts;
	}
	
}
