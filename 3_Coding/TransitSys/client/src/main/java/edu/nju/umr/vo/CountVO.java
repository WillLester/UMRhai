package edu.nju.umr.vo;

import java.util.ArrayList;

public class CountVO {
	private String id;
	private ArrayList<OrgVO> organizations;
	private ArrayList<WorkVO> workers;
	private ArrayList<VanVO> vans;
	private ArrayList<StockVO> stocks;
	private ArrayList<AccountVO> accounts;
	public CountVO(ArrayList<OrgVO> orgas,ArrayList<WorkVO> workers,ArrayList<VanVO> vans,ArrayList<StockVO> stocks,ArrayList<AccountVO> accounts) {
		// TODO 自动生成的构造函数存根
		this.organizations = orgas;
		this.workers = workers;
		this.vans = vans;
		this.stocks = stocks;
		this.accounts = accounts;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ArrayList<OrgVO> getOrganizations() {
		return organizations;
	}
	public void setOrganizations(ArrayList<OrgVO> organizations) {
		this.organizations = organizations;
	}
	public ArrayList<WorkVO> getWorkers() {
		return workers;
	}
	public void setWorkers(ArrayList<WorkVO> workers) {
		this.workers = workers;
	}
	public ArrayList<VanVO> getVans() {
		return vans;
	}
	public void setVans(ArrayList<VanVO> vans) {
		this.vans = vans;
	}
	public ArrayList<StockVO> getStocks() {
		return stocks;
	}
	public void setStocks(ArrayList<StockVO> stocks) {
		this.stocks = stocks;
	}
	public ArrayList<AccountVO> getAccounts() {
		return accounts;
	}
	public void setAccounts(ArrayList<AccountVO> accounts) {
		this.accounts = accounts;
	}
	
}
