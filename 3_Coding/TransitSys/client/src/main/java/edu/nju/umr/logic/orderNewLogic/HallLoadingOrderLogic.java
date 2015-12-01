package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.HallLoadingOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.HallLoadingOrderDSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.orderNewLogic.HallLoadingOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.HallLoadingVO;

public class HallLoadingOrderLogic implements HallLoadingOrderLSer{
	HallLoadingOrderDFacSer dataFac;
	HallLoadingOrderDSer hallData;
	UtilityLogic uti=new UtilityLogic();
	public HallLoadingOrderLogic() {
		try{
			dataFac = (HallLoadingOrderDFacSer)Naming.lookup(Url.URL);
			hallData = dataFac.getHallLoadingOrder();
			uti=new UtilityLogic();
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
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResultMessage getLocalHallAndAllCenter(String orgId) {
		// TODO Auto-generated method stub
		return null;
	}

}
