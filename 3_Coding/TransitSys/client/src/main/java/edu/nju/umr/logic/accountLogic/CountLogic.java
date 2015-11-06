package edu.nju.umr.logic.accountLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.dataService.dataFactory.CountDFacSer;
import edu.nju.umr.logicService.accountLogicSer.CountLSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.CountVO;
import edu.nju.umr.vo.GoodVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.StockVO;
import edu.nju.umr.vo.VanVO;
import edu.nju.umr.vo.WorkVO;

public class CountLogic implements CountLSer{
	CountDFacSer countFac;
	CountDSer countData;
	public CountLogic() {
		// TODO 自动生成的构造函数存根
		try{
			countFac = (CountDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			countData = countFac.getCountData();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public boolean newCount() {
		// TODO 自动生成的方法存根
		boolean isSuccessful = false;
		ArrayList<OrgPO> orgList= new ArrayList<OrgPO>();
		ArrayList<WorkPO> workList = new ArrayList<WorkPO>();
		ArrayList<VanPO> vanList = new ArrayList<VanPO>();
		ArrayList<StockPO> stockList = new ArrayList<StockPO>();
		ArrayList<AccountPO> accountList = new ArrayList<AccountPO>();
//		for(OrgVO vo:count.getOrganizations()){
//			CityPO citypo = new CityPO(vo.getCity().getName(), vo.getCity().getId());
//			OrgPO po = new OrgPO(vo.getId(), vo.getName(), vo.getKind(), vo.getLocation(), citypo);
//			orgList.add(po);
//		}
//		for(WorkVO vo:count.getWorkers()){
//			WorkPO po = new WorkPO(vo.getName(), vo.getMobile(), vo.getOrgId(), vo.getId(), vo.getJuri());
//			workList.add(po);
//		}
//		for(VanVO vo:count.getVans()){
//			VanPO po = new VanPO(vo.getId(), vo.getPlateNum(), vo.getServTime(), vo.getPhoto(), vo.getOrgId());
//			vanList.add(po);
//		}
//		for(StockVO vo:count.getStocks()){
//			ArrayList<GoodPO> goodList = new ArrayList<GoodPO>();
//			for(GoodVO gVo:vo.getGoods()){
//				GoodPO gPo = new GoodPO(gVo.getId(), gVo.getDate(), gVo.getCity(), gVo.getPart(), gVo.getShelf(), gVo.getRow(), gVo.getPlace());
//				goodList.add(gPo);
//			}
//			StockPO po = new StockPO(goodList);
//			stockList.add(po);
//		}
//		for(AccountVO vo:count.getAccounts()){
//			AccountPO po = new AccountPO(vo.getId(), vo.getName(), vo.getBalance());
//			accountList.add(po);
//		}
//		try {
//			isSuccessful = countData.addCount(new CountPO(count.getId(), orgList, workList, vanList, stockList, accountList));
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
		return isSuccessful;
	}

	public ResultMessage checkInitInfo(String id) {
		// TODO 自动生成的方法存根
		CountPO count = null;
		CountVO countVo = null;
		try {
			count = countData.findInitInfo("1");
			ArrayList<OrgVO> orgList= new ArrayList<OrgVO>();
			ArrayList<WorkVO> workList = new ArrayList<WorkVO>();
			ArrayList<VanVO> vanList = new ArrayList<VanVO>();
			ArrayList<StockVO> stockList = new ArrayList<StockVO>();
			ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();
			for(OrgPO po:count.getOrganizations()){
				CityVO cityvo = new CityVO(po.getCity().getName(), po.getCity().getId(),po.getCity().getProvince());
				OrgVO vo = new OrgVO(po.getId(), po.getName(), po.getKind(), po.getLocation(), cityvo);
				orgList.add(vo);
			}
			for(WorkPO po:count.getWorkers()){
				WorkVO vo = new WorkVO(po.getName(), po.getMobile(), po.getOrgId(), po.getId(), po.getJuri(),po.getKind(),po.getMoney());
				workList.add(vo);
			}
			for(VanPO po:count.getVans()){
				VanVO vo = new VanVO(po.getId(), po.getPlateNum(), po.getServTime(), po.getPhoto(), po.getOrgId());
				vanList.add(vo);
			}
			for(StockPO po:count.getStocks()){
				ArrayList<GoodVO> goodList = new ArrayList<GoodVO>();
				for(GoodPO gPo:po.getGoods()){
					GoodVO gVo = new GoodVO(gPo.getId(), gPo.getDate(), gPo.getCity(), gPo.getPart(), gPo.getShelf(), gPo.getRow(), gPo.getPlace());
					goodList.add(gVo);
				}
				StockVO vo = new StockVO(goodList);
				stockList.add(vo);
			}
			for(AccountPO po:count.getAccounts()){
				AccountVO vo = new AccountVO(po.getId(), po.getName(), po.getBalance());
				accountList.add(vo);
			}
			countVo = new CountVO(count.getId(), orgList, workList, vanList, stockList, accountList);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return new ResultMessage(true, countVo);
	}

//	public ResultMessage orgList() {
//		// TODO 自动生成的方法存根
//		ArrayList<OrgVO> orgList = new ArrayList<OrgVO>();
//		ArrayList<OrgPO> orgs = null;
//		try {
//			orgs = countData.findOrg();
//			for(OrgPO po:orgs){
//				CityVO city = new CityVO(po.getCity().getName(), po.getCity().getId());
//				OrgVO vo = new OrgVO(po.getId(), po.getName(), po.getKind(), po.getLocation(), city);
//				orgList.add(vo);
//			}
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		return new ResultMessage(true, orgList);
//	}

//	public ResultMessage getWorkers(String id) {
//		// TODO 自动生成的方法存根
//		ArrayList<WorkVO> workList = new ArrayList<WorkVO>();
//		ArrayList<WorkPO> work;
//		try {
//			work = countData.getWorkers(id);
//			for(WorkPO po:work){
//				WorkVO vo = new WorkVO(po.getName(), po.getMobile(), po.getOrgId(), po.getId(), po.getJuri());
//				workList.add(vo);
//			}
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		return new ResultMessage(true, workList);
//	}

//	public ResultMessage getVans(String id) {
//		// TODO 自动生成的方法存根
//		ArrayList<VanVO> vanList = new ArrayList<VanVO>();
//		try {
//			ArrayList<VanPO> van = countData.getVans(id);
//			for(VanPO po:van){
//				VanVO vo = new VanVO(po.getId(), po.getPlateNum(), po.getServTime(), po.getPhoto(), po.getOrgId());
//				vanList.add(vo);
//			}
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		
//		return new ResultMessage(true, vanList);
//	}

//	public ResultMessage getStocks() {
//		// TODO 自动生成的方法存根
//		ArrayList<StockVO> stockList = new ArrayList<StockVO>();
//		ArrayList<StockPO> stock;
//		try {
//			stock = countData.getStocks();
//			for(StockPO po:stock){
//				ArrayList<GoodVO> goodList = new ArrayList<GoodVO>();
//				for(GoodPO gPo:po.getGoods()){
//					GoodVO gVo = new GoodVO(gPo.getId(), gPo.getDate(), gPo.getCity(), gPo.getPart(), gPo.getShelf(), gPo.getRow(), gPo.getPlace());
//					goodList.add(gVo);
//				}
//				StockVO vo = new StockVO(goodList);
//				stockList.add(vo);
//			}
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		
//		return new ResultMessage(true, stockList);
//	}

//	public ResultMessage getAccount() {
//		// TODO 自动生成的方法存根
//		ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();
//		try {
//			ArrayList<AccountPO> account = countData.getAccount();
//			for(AccountPO po:account){
//				AccountVO vo = new AccountVO(po.getId(), po.getName(), po.getBalance());
//				accountList.add(vo);
//			}
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		
//		return new ResultMessage(true, accountList);
//	}

}
