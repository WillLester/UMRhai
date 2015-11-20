package edu.nju.umr.logic.utilityLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.GoodVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.StockVO;
import edu.nju.umr.vo.VanVO;
import edu.nju.umr.vo.WorkVO;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.UtilityDFacSer;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;

public class UtilityLogic {
	private UtilityDSer utilityData;
	private UtilityDFacSer dataFac;
	public UtilityLogic() {
		// TODO 自动生成的构造函数存根
		try {
			dataFac = (UtilityDFacSer) Naming.lookup(Url.URL);
			utilityData = dataFac.getUtility();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        }  
	}
	public ResultMessage getCities(){
		ArrayList<CityVO> cityList = new ArrayList<CityVO>();
		try {
			ArrayList<CityPO> cities = utilityData.getCities();
			for(CityPO city:cities){
				CityVO vo = new CityVO(city.getName(), city.getId(),city.getProvince());
				cityList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(Result.SUCCESS, cityList);
	}
	public ResultMessage getOrgs(){
		ArrayList<OrgPO> ar= null;
		Result isSuccessful=Result.NET_INTERRUPT;
		try{
			ar=utilityData.getOrgs();
			isSuccessful=Result.SUCCESS;
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		ArrayList<OrgVO> arVO=new ArrayList<OrgVO>();
		for(int i=0;i<ar.size();i++)
		{
			OrgPO Org=ar.get(i);
			arVO.add(new OrgVO(Org.getId(),Org.getName(),Org.getKind(),Org.getLocation(),new CityVO(Org.getCity().getId(),Org.getCity().getName(),Org.getCity().getProvince())));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}
	public ResultMessage getHall() {
		// TODO 自动生成的方法存根
		ArrayList<OrgVO> hallList = new ArrayList<OrgVO>();
		Result re=Result.NET_INTERRUPT;
		try {
			ArrayList<OrgPO> halls = utilityData.getHall();
			re=Result.SUCCESS;
			for(OrgPO hall:halls){
				CityVO city = new CityVO(hall.getCity().getName(), hall.getCity().getId(),hall.getCity().getProvince());
				OrgVO vo = new OrgVO(hall.getId(), hall.getName(), hall.getKind(), hall.getLocation(), city);
				hallList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(re, hallList);
	}
	public ResultMessage getWorkers(String orgId){
		ArrayList<WorkPO> ar= null;
		Result isSuccessful=Result.NET_INTERRUPT;
		try{
			ar=utilityData.getWorkers("");
			isSuccessful=Result.SUCCESS;
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		ArrayList<WorkVO> arVO=new ArrayList<WorkVO>();
		for(int i=0;i<ar.size();i++)
		{
			WorkPO Work=ar.get(i);
			arVO.add(new WorkVO(Work.getName(),Work.getMobile(),Work.getOrgId(),Work.getJuri(),Work.getKind(),Work.getMoney(),Work.getCommission()));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}
	public ResultMessage getVans(String orgId){
		ArrayList<VanVO> vanList = new ArrayList<VanVO>();
		try {
			ArrayList<VanPO> van = utilityData.getVans(orgId);
			for(VanPO po:van){
				VanVO vo = new VanVO(po.getId(), po.getPlateNum(), po.getServTime(), po.getPhoto(), po.getOrgId());
				vanList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return new ResultMessage(Result.SUCCESS, vanList);
	}
	public ResultMessage getStocks(){
		ArrayList<StockVO> stockList = new ArrayList<StockVO>();
		ArrayList<StockPO> stock;
		try {
			stock = utilityData.getStocks();
			for(StockPO po:stock){
				ArrayList<GoodVO> goodList = new ArrayList<GoodVO>();
				for(GoodPO gPo:po.getGoods()){
					GoodVO gVo = new GoodVO(gPo.getId(), gPo.getDate(), gPo.getCity(), gPo.getPart(), gPo.getShelf(), gPo.getRow(), gPo.getPlace());
					goodList.add(gVo);
				}
				StockVO vo = new StockVO(goodList);
				stockList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(Result.SUCCESS, stockList);
	}
	public ResultMessage getAccount() {
		ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();
		Result re=Result.NET_INTERRUPT;
		try {
			ArrayList<AccountPO> account = utilityData.getAccount();
			re=Result.SUCCESS;
			for(AccountPO po:account){
				AccountVO vo = new AccountVO(po.getName(), po.getBalance());
				accountList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return new ResultMessage(re, accountList);
	}

	public static Result setRecord(Calendar cal,String op,String opt){
		Result isSuc=Result.SUCCESS;
		try
		{
			UtilityDFacSer dataFac=(UtilityDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			UtilityDSer data=dataFac.getUtility();
			isSuc=data.setRecord(cal, op, opt);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuc;
	}
}
