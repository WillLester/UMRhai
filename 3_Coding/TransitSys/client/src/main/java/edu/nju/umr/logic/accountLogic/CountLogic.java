package edu.nju.umr.logic.accountLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.dataService.dataFactory.CountDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.DriverManDSer;
import edu.nju.umr.dataService.workOrgManDSer.OrgManDSer;
import edu.nju.umr.dataService.workOrgManDSer.VanManDSer;
import edu.nju.umr.dataService.workOrgManDSer.WorkManDSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.accountLogicSer.CountLSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;
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
	UtilityLogic uti=new UtilityLogic();
	ArrayList<CountPO> countPO=new ArrayList<CountPO>();
//	ArrayList<CountPO> countPOs;
	public CountLogic() {
		try{
			countFac = (CountDFacSer)Naming.lookup(Url.URL);
			countData = countFac.getCountData();
			uti=new UtilityLogic();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public Result newCount() {		
		ArrayList<OrgPO> orgList=uti.orgs() ;
		ArrayList<WorkPO> workList = uti.works(null);
		ArrayList<VanPO> vanList = uti.vans(null);
		ArrayList<StockPO> stockList = uti.stocks();
		ArrayList<AccountPO> accountList = uti.accounts();
		CountPO count=new CountPO(0,orgList,workList,vanList,stockList,accountList,Calendar.getInstance());
		try {
			Result result=countData.addCount(count);
			return result;
		} catch (RemoteException e) {
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
	}
	public ResultMessage getCount(){
		Result result=Result.DATA_NOT_FOUND;
		
		try {
			countPO=countData.getCount();
			result=Result.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		return new ResultMessage(result,countPO);
	}
	@Override
	public Result deleteCount(int index) {
		CountPO cp=countPO.get(index);
		Result result=Result.DATA_NOT_FOUND;
		try {
			result=countData.deleteCount(cp.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return result;
	}
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
//		return Result.SUCCESS;
//	}

//	public ResultMessage checkInitInfo(String id) {
//		CountPO count = null;
//		CountVO countVo = null;
//		try {
//			count = countData.findInitInfo(id);
//			ArrayList<OrgVO> orgList= new ArrayList<OrgVO>();
//			ArrayList<WorkVO> workList = new ArrayList<WorkVO>();
//			ArrayList<VanVO> vanList = new ArrayList<VanVO>();
//			ArrayList<StockVO> stockList = new ArrayList<StockVO>();
//			ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();
//			for(OrgPO po:count.getOrganizations()){
////				CityVO cityvo = new CityVO(po.getCity(), po.getCityId(),po.getCity().getProvince());
//				OrgVO vo = new OrgVO(po.getId(), po.getName(), po.getKind(), po.getLocation(), po.getCity(),po.getCityId());
//				orgList.add(vo);
//			}
//			for(WorkPO po:count.getWorkers()){
//				WorkVO vo = new WorkVO(po.getName(), po.getMobile(), po.getOrg(),po.getOrgId(),  po.getJuri(),po.getKind(),po.getMoney());
//				workList.add(vo);
//			}
//			for(VanPO po:count.getVans()){
//				VanVO vo = new VanVO(po.getId(), po.getPlateNum(), po.getServTime(), po.getPhoto(), po.getHallId());
//				vanList.add(vo);
//			}
//			for(StockPO po:count.getStocks()){
//				ArrayList<GoodVO> goodList = new ArrayList<GoodVO>();
//				for(GoodPO gPo:po.getGoods()){
//					GoodVO gVo = new GoodVO(gPo.getId(), gPo.getDate(), gPo.getCity(), gPo.getPart(), gPo.getShelf(), gPo.getRow(), gPo.getPlace());
//					goodList.add(gVo);
//				}
//				StockVO vo = new StockVO(goodList);
//				stockList.add(vo);
//			}
//			for(AccountPO po:count.getAccounts()){
//				AccountVO vo = new AccountVO(po.getName(), po.getBalance());
//				accountList.add(vo);
//			}
//			countVo = new CountVO(count.getId(), orgList, workList, vanList, stockList, accountList);
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		
//		return new ResultMessage(Result.SUCCESS, countVo);
//	}

//	public ResultMessage orgList() {
////		// TODO 自动生成的方法存根
////		ArrayList<OrgVO> orgList = new ArrayList<OrgVO>();
////		ArrayList<OrgPO> orgs = null;
////		try {
////			orgs = countData.findOrg();
////			for(OrgPO po:orgs){
////				CityVO city = new CityVO(po.getCity().getName(), po.getCity().getId());
////				OrgVO vo = new OrgVO(po.getId(), po.getName(), po.getKind(), po.getLocation(), city);
////				orgList.add(vo);
////			}
////		} catch (RemoteException e) {
////			// TODO 自动生成的 catch 块
////			e.printStackTrace();
////		}
////		return new ResultMessage(true, orgList);
//		return uti.getOrgs();
//	}
//
//	public ResultMessage getWorkers(String id) {
////		// TODO 自动生成的方法存根
////		ArrayList<WorkVO> workList = new ArrayList<WorkVO>();
////		ArrayList<WorkPO> work;
////		try {
////			work = countData.getWorkers(id);
////			for(WorkPO po:work){
////				WorkVO vo = new WorkVO(po.getName(), po.getMobile(), po.getOrgId(), po.getId(), po.getJuri());
////				workList.add(vo);
////			}
////		} catch (RemoteException e) {
////			// TODO 自动生成的 catch 块
////			e.printStackTrace();
////		}
////		return new ResultMessage(true, workList);
//		return uti.getWorkers(id);
//	}
//
//	public ResultMessage getVans(String id) {
////		// TODO 自动生成的方法存根
////		ArrayList<VanVO> vanList = new ArrayList<VanVO>();
////		try {
////			ArrayList<VanPO> van = countData.getVans(id);
////			for(VanPO po:van){
////				VanVO vo = new VanVO(po.getId(), po.getPlateNum(), po.getServTime(), po.getPhoto(), po.getOrgId());
////				vanList.add(vo);
////			}
////		} catch (RemoteException e) {
////			// TODO 自动生成的 catch 块
////			e.printStackTrace();
////		}
////		
////		return new ResultMessage(true, vanList);
//		return uti.getVans(id);
//	}
//
//	public ResultMessage getStocks() {
////		// TODO 自动生成的方法存根
////		ArrayList<StockVO> stockList = new ArrayList<StockVO>();
////		ArrayList<StockPO> stock;
////		try {
////			stock = countData.getStocks();
////			for(StockPO po:stock){
////				ArrayList<GoodVO> goodList = new ArrayList<GoodVO>();
////				for(GoodPO gPo:po.getGoods()){
////					GoodVO gVo = new GoodVO(gPo.getId(), gPo.getDate(), gPo.getCity(), gPo.getPart(), gPo.getShelf(), gPo.getRow(), gPo.getPlace());
////					goodList.add(gVo);
////				}
////				StockVO vo = new StockVO(goodList);
////				stockList.add(vo);
////			}
////		} catch (RemoteException e) {
////			// TODO 自动生成的 catch 块
////			e.printStackTrace();
////		}
////		
////		return new ResultMessage(true, stockList);
//		return uti.getStocks();
//	}
//
//	public ResultMessage getAccount() {
////		// TODO 自动生成的方法存根
////		ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();
////		try {
////			ArrayList<AccountPO> account = countData.getAccount();
////			for(AccountPO po:account){
////				AccountVO vo = new AccountVO(po.getId(), po.getName(), po.getBalance());
////				accountList.add(vo);
////			}
////		} catch (RemoteException e) {
////			// TODO 自动生成的 catch 块
////			e.printStackTrace();
////		}
////		
////		return new ResultMessage(true, accountList);
//		return uti.getAccount();
//	}
	

}
