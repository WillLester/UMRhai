package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.cityDSer.CityDSer;
import edu.nju.umr.dataService.cityDSer.ConstantDSer;
import edu.nju.umr.dataService.dataFactory.HallLoadingOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.HallLoadingOrderDSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.HallLoadingOrderLSer;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.ConstantPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.HallLoadingVO;

public class HallLoadingOrderLogic implements HallLoadingOrderLSer{
	HallLoadingOrderDFacSer dataFac;
	HallLoadingOrderDSer hallData;
	CityDSer cityData;
	ConstantDSer constantData;
	UtilityLogic uti=new UtilityLogic();
	ArrayList<OrgPO> orgs=uti.orgs();
	public HallLoadingOrderLogic() {
		try{
			dataFac = (HallLoadingOrderDFacSer)Naming.lookup(Url.URL);
			hallData = dataFac.getHallLoadingOrder();
			uti=new UtilityLogic();
			orgs=uti.orgs();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		// TODO 自动生成的构造函数存根
	}
	public Result create(HallLoadingVO order) {
		// TODO 自动生成的方法存根
		Result isSuc=Result.DATABASE_ERROR;
		try{
			isSuc=hallData.create(new HallLoadingPO("",order.getHallId(),order.getConvertId(),order.getArriveLoc(),order.getVanId(),order.getSupervision(),order.getEscort(),order.getExpress(),order.getDate(),Calendar.getInstance(),order.getOpName(),order.getCost()));
		} catch (RemoteException e) { 
            return Result.NET_INTERRUPT;
        } catch(Exception e){
			e.printStackTrace();
		}
		return isSuc;
	}

	public ResultMessage getOrgs() {
//		ArrayList<String> orgs = null;
//		try {
//			orgs = hallData.getOrgs();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		return new ResultMessage(Result.SUCCESS, orgs);
		return uti.getOrgs();
	}

	public ResultMessage getVans(String orgId) {
		// TODO 自动生成的方法存根
//		ArrayList<String> vans = null;
//		try {
//			vans = hallData.getVans();
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		return new ResultMessage(Result.SUCCESS, vans);
		return uti.getVans(orgId);
	}
	
	@Override
	public ResultMessage getPrice(String org1, String org2) {		
		if(orgs==null)
			return new ResultMessage(Result.NET_INTERRUPT,null);
		if(orgs.size()==0)
			return new ResultMessage(Result.DATA_NOT_FOUND,null);
		String city1=null;
		String city2=null;
		for(OrgPO po:orgs){
			if(po.getName()==org1)
				city1=po.getCity();
			break;
		}
		for(OrgPO po:orgs){
			if(po.getName()==org2)
				city2=po.getCity();
			break;
		}
		if(city1.equals(city2))
			return new ResultMessage(Result.SUCCESS,100);//固定值暂定为100
		ArrayList<CitiesPO> citiespo=new ArrayList<CitiesPO>();
		try {
			citiespo=cityData.getCitiesInfo();
			if(citiespo.size()==0)
				return new ResultMessage(Result.DATA_NOT_FOUND, null);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		double distance=0;
		for(CitiesPO po:citiespo){
			if((po.getCity1().equals(city1)&&po.getCity2().equals(city2))||(po.getCity1().equals(city2)&&po.getCity2().equals(city1))){
				distance=po.getDistance();
			}
			break;
		}
		ConstantPO constant=null;
		try {
			constant=constantData.getConstant();
			if(constant==null)
				return new ResultMessage(Result.DATA_NOT_FOUND,null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		double price=constant.getPriceVan();
		return new ResultMessage(Result.SUCCESS,price*distance);
	}
	@Override
	public ResultMessage getLocalHallAndAllCenter(String orgId) {
		ArrayList<OrgPO> halls=uti.halls();
		ArrayList<OrgVO> localHalls=new ArrayList<OrgVO>();
		if(halls==null)
			return new ResultMessage(Result.NET_INTERRUPT,null);
		String city=null;
		for(OrgPO po:orgs){
			if(po.getId().equals(orgId))
				city=po.getCity();
			break;
		}
		for(OrgPO hall:halls){
			if(hall.getCity().equals(city)){
				OrgVO vo=VPFactory.toOrgVO(hall);
				localHalls.add(vo);
			}		
		}
		ArrayList<OrgVO> centers=new ArrayList<OrgVO>();
		centers=(ArrayList<OrgVO>)uti.getCenter().getMessage();
		return new ResultMessage(Result.SUCCESS,localHalls.addAll(centers));
	}

}
