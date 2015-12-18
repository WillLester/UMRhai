package edu.nju.umr.data.driver;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.data.dataFactory.DataFactory;
import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Wage;

public class CountDriver {
	private CountDSer serv;
	public CountDriver() {
		// TODO 自动生成的构造函数存根
		DataFactory fac;
		try {
			fac = new DataFactory();
			serv = fac.getCountData();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		OrgPO org = new OrgPO("021000", "赛艇", Organization.HALL, "谜", "上海", "021");
		ArrayList<OrgPO> orgs = new ArrayList<OrgPO>();
		orgs.add(org);
		WorkPO work = new WorkPO("蛤", "12314131421", "总部", "0", 5, Jurisdiction.MANAGER, Wage.MONTH, 5000, 0);
		ArrayList<WorkPO> works = new ArrayList<WorkPO>();
		works.add(work);
		ArrayList<VanPO> vans = new ArrayList<VanPO>();
		VanPO van = new VanPO("02100000000", "沪A-00000", Calendar.getInstance(), null, "021000");
		vans.add(van);
		GoodPO good = new GoodPO("1111111111", "0210", Calendar.getInstance(), "赛艇", Part.PLANE, "021000000", 3, 6);
		ArrayList<GoodPO> goods = new ArrayList<GoodPO>();
		goods.add(good);
		StockPO stock = new StockPO("0210", goods);
		ArrayList<StockPO> stocks = new ArrayList<StockPO>();
		stocks.add(stock);
		AccountPO account = new AccountPO(6, "批判一番", new BigDecimal(300));
		ArrayList<AccountPO> accounts = new ArrayList<AccountPO>();
		accounts.add(account);
		CountPO count = new CountPO(3, orgs, works, vans, stocks, accounts, Calendar.getInstance());
		Result re ;
		try {
			re = serv.addCount(count);
			System.out.println(re);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		ArrayList<CountPO> counts;
		try {
			counts = serv.getCount();
			CountPO c = counts.get(0);
			System.out.println(c.getId());
			System.out.println(c.getAccounts().get(0).getName());
			System.out.println(c.getOrganizations().get(0).getName());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
