package edu.nju.umr.data.transitInfoData;

import java.awt.Image;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.Part;

public class CourierData extends UnicastRemoteObject implements CountDSer{

	protected CourierData() throws RemoteException {
		super();
		// TODO 自动生成的构造函数存根
	}

	public boolean addCount(CountPO count) throws RemoteException {
		// TODO 自动生成的方法存根
		return true;
	}

	public CountPO findInitInfo() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<OrgPO> ar1=new ArrayList<OrgPO>();
		ar1.add(new OrgPO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityPO("南京","1")));
		ar1.add(new OrgPO("2","组织2",Organization.HALL,"南京大学鼓楼校区",new CityPO("南京","1")));
		ArrayList<WorkPO> ar2=new ArrayList<WorkPO>();
		ar2.add(new WorkPO("Worker1","11111111111","1","1",Jurisdiction.ADMIN));
		ar2.add(new WorkPO("Worker2","22222222222","2","2",Jurisdiction.COURIER));
		ArrayList<VanPO> ar3=new ArrayList<VanPO>();
		ar3.add(new VanPO("1","11111",new Date(),null,"1"));
		ar3.add(new VanPO("2","22222",new Date(),null,"2"));
		ArrayList<StockPO> ar4=new ArrayList<StockPO>();
		StockPO sp1=new StockPO(new ArrayList<GoodPO>());
		sp1.getGoods().add(new GoodPO("1",new Date(),"南京",Part.PLANE,"shelf1",1,1));
		sp1.getGoods().add(new GoodPO("2",new Date(),"上海",Part.TRAIN,"shelf2",3,4));
		StockPO sp2=new StockPO(new ArrayList<GoodPO>());
		sp2.getGoods().add(new GoodPO("3",new Date(),"北京",Part.VAN,"shelf3",5,6));
		sp2.getGoods().add(new GoodPO("4",new Date(),"天津",Part.MANEUVER,"shelf4",7,8));
		ar4.add(sp1);
		ar4.add(sp2);
		AccountPO account1 = new AccountPO("00001", "Excited", 25000);
		AccountPO account2 = new AccountPO("00002", "Too Young",30000);
		ArrayList<AccountPO> ar5 = new ArrayList<AccountPO>();
		ar5.add(account1);
		ar5.add(account2);
		return new CountPO("1",ar1,ar2,ar3,ar4,ar5);
	}

	public ArrayList<OrgPO> findOrg() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<OrgPO> ar1=new ArrayList<OrgPO>();
		ar1.add(new OrgPO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityPO("南京","1")));
		ar1.add(new OrgPO("2","组织2",Organization.HALL,"南京大学鼓楼校区",new CityPO("南京","1")));
		return ar1;
	}

	public ArrayList<WorkPO> getWorkers(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<WorkPO> ar2=new ArrayList<WorkPO>();
		ar2.add(new WorkPO("Worker1","11111111111","1","1",Jurisdiction.ADMIN));
		ar2.add(new WorkPO("Worker2","22222222222","2","2",Jurisdiction.COURIER));
		return ar2;
	}

	public ArrayList<VanPO> getVans(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<VanPO> ar3=new ArrayList<VanPO>();
		ar3.add(new VanPO("1","11111",new Date(),null,"1"));
		ar3.add(new VanPO("2","22222",new Date(),null,"2"));
		return ar3;
	}

	public ArrayList<StockPO> getStock(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<StockPO> ar4=new ArrayList<StockPO>();
		StockPO sp1=new StockPO(new ArrayList<GoodPO>());
		sp1.getGoods().add(new GoodPO("1",new Date(),"南京",Part.PLANE,"shelf1",1,1));
		sp1.getGoods().add(new GoodPO("2",new Date(),"上海",Part.TRAIN,"shelf2",3,4));
		StockPO sp2=new StockPO(new ArrayList<GoodPO>());
		sp2.getGoods().add(new GoodPO("3",new Date(),"北京",Part.VAN,"shelf3",5,6));
		sp2.getGoods().add(new GoodPO("4",new Date(),"天津",Part.MANEUVER,"shelf4",7,8));
		ar4.add(sp1);
		ar4.add(sp2);
		return ar4;
	}

	public ArrayList<AccountPO> getAccount(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		AccountPO account1 = new AccountPO("00001", "Excited", 25000);
		AccountPO account2 = new AccountPO("00002", "Too Young",30000);
		ArrayList<AccountPO> ar5 = new ArrayList<AccountPO>();
		ar5.add(account1);
		ar5.add(account2);
		return ar5;
	}

}
