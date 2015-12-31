package edu.nju.umr.vo;

import java.util.ArrayList;
import java.util.Calendar;

public class CountVO {
	private int id;
	private ArrayList<OrgVO> organizations;
	private ArrayList<WorkVO> workers;
	private ArrayList<VanVO> vans;
	private ArrayList<StockVO> stocks;
	private ArrayList<AccountVO> accounts;
	private Calendar time;
	
	public CountVO(int id, ArrayList<OrgVO> organizations,
			ArrayList<WorkVO> workers, ArrayList<VanVO> vans,
			ArrayList<StockVO> stocks, ArrayList<AccountVO> accounts,
			Calendar time) {
		super();
		this.id = id;
		this.organizations = organizations;
		this.workers = workers;
		this.vans = vans;
		this.stocks = stocks;
		this.accounts = accounts;
		this.time = time;
	}
	public int getId() {
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
	public Calendar getTime() {
		return time;
	}
	
}
