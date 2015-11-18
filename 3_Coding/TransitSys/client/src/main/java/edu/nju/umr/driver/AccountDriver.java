package edu.nju.umr.driver;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.logic.accountLogic.AccountLogic;
import edu.nju.umr.logic.accountLogic.CountLogic;
import edu.nju.umr.logicService.accountLogicSer.AccountLSer;
import edu.nju.umr.logicService.accountLogicSer.CountLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Wage;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.CountVO;
import edu.nju.umr.vo.GoodVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.StockVO;
import edu.nju.umr.vo.VanVO;
import edu.nju.umr.vo.WorkVO;

public class AccountDriver {
	private AccountLSer account = new AccountLogic();
	private CountLSer count = new CountLogic();
	public static void main(String[] args) {
		AccountDriver driver = new AccountDriver();
		System.out.println(driver.account.addAccount(new AccountVO("00001", "赛艇", 233)));
		System.out.println(driver.account.deleteAccount("00001"));
		System.out.println(driver.account.reviseAccount(new AccountVO("00001", "赛艇", 233)));
//		AccountVO account = (AccountVO) driver.account.checkAccount("00001").getMessage();
//		System.out.println(account.getName() + " " + account.getBalance());
//		@SuppressWarnings("unchecked")
//		ArrayList<AccountVO> accountList = (ArrayList<AccountVO>) driver.account.accountList().getMessage();
//		for(int i = 0;i < accountList.size();i++){
//			System.out.println(accountList.get(i).getName() + " " + accountList.get(i).getBalance());
//		}
		@SuppressWarnings("unchecked")
		ArrayList<AccountVO> accountList2 = (ArrayList<AccountVO>) driver.account.searchAccount("蛤").getMessage();
		for(int i = 0;i < accountList2.size();i++){
			System.out.println(accountList2.get(i).getName() + " " + accountList2.get(i).getBalance());
		}
		driver.driveCount();
	}
	private void driveCount(){
		CityVO city = new CityVO("北京", "010","北京");
		OrgVO org = new OrgVO("00001", "HaHa", Organization.HALL, "香港记者", city);
		ArrayList<OrgVO> orgList = new ArrayList<OrgVO>();
		orgList.add(org);
		WorkVO work = new WorkVO("宝华", "12345678901","00001", Jurisdiction.COURIER,Wage.MONTH,2500);
		ArrayList<WorkVO> workerList = new ArrayList<WorkVO>();
		workerList.add(work);
		VanVO van = new VanVO("00001", "苏A-12345", Calendar.getInstance(), null, "00001");
		ArrayList<VanVO> vanList = new ArrayList<VanVO>();
		vanList.add(van);
		GoodVO good = new GoodVO("00001", Calendar.getInstance(), "北京", Part.TRAIN, "T00001", 3, 5);
		ArrayList<GoodVO> goodList = new ArrayList<GoodVO>();
		goodList.add(good);
		StockVO stock = new StockVO(goodList);
		ArrayList<StockVO> stockList = new ArrayList<StockVO>();
		stockList.add(stock);
		AccountVO account = new AccountVO("00001", "Excited", 25000);
		ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();
		accountList.add(account);
		this.checkInfo();
//		this.orgList();
//		this.getWorkers();
//		this.getVans();
//		this.getStock();
//		this.getAccount();
	}
	private void checkInfo(){
		CountVO vo = (CountVO) count.checkInitInfo("1").getMessage();
		System.out.println(vo.getId());
		for(OrgVO org:vo.getOrganizations()){
			System.out.println(org.getName() + " " + org.getLocation() + " " + org.getCity().getName() + " " + org.getCity().getId() + " "+ org.getKind());
		}
		for(WorkVO work:vo.getWorkers()){
			System.out.println(work.getName() + " " + work.getOrgId() + " " + work.getMobile() + " " + work.getJuri());
		}
		for(VanVO van:vo.getVans()){
			System.out.println(van.getId() + " " + van.getOrgId() + " " + van.getPlateNum() + " " + van.getServTime());
		}
		for(StockVO stock:vo.getStocks()){
			for(GoodVO good:stock.getGoods()){
				System.out.println(good.getId() + " " + good.getCity() + " " + good.getDate() + " " + good.getPart() + " " + good.getShelf() + " " + good.getRow() + " " + good.getPlace());
			}
		}
		for(AccountVO account:vo.getAccounts()){
			System.out.println(account.getName() + " " + account.getBalance());
		}
	}
//	private void orgList(){
//		for(OrgVO org:(ArrayList<OrgVO>)count.orgList().getMessage()){
//			System.out.println(org.getName() + " " + org.getLocation() + " " + org.getCity().getName() + " " + org.getCity().getId() + " "+ org.getKind());
//		}
//	}
//	private void getWorkers(){
//		ArrayList<WorkVO> workers = (ArrayList<WorkVO>) count.getWorkers("00001").getMessage();
//		for(WorkVO work:workers){
//			System.out.println(work.getName() + " " + work.getOrgId() + " " + work.getMobile() + " " + work.getJuri());
//		}
//	}
//	private void getVans(){
//		ArrayList<VanVO> vans = (ArrayList<VanVO>) count.getVans("00001").getMessage();
//		for(VanVO van:vans){
//			System.out.println(van.getId() + " " + van.getOrgId() + " " + van.getPlateNum() + " " + van.getServTime());
//		}
//	}
//	private void getStock(){
//		ArrayList<StockVO> stocks = (ArrayList<StockVO>) count.getStocks().getMessage();
//		for(StockVO stock:stocks){
//			for(GoodVO good:stock.getGoods()){
//				System.out.println(good.getId() + " " + good.getCity() + " " + good.getDate() + " " + good.getPart() + " " + good.getShelf() + " " + good.getRow() + " " + good.getPlace());
//			}
//		}
//	}
//	private void getAccount(){
//		ArrayList<AccountVO> accounts = (ArrayList<AccountVO>) count.getAccount().getMessage();
//		for(AccountVO account:accounts){
//			System.out.println(account.getName() + " " + account.getBalance());
//		}
//	}
}
