package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.ArriveOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.ArriveOrderDSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.ArriveOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ArriveVO;

public class ArriveOrderLogic implements ArriveOrderLSer{
	private ArriveOrderDFacSer dataFac;
	private ArriveOrderDSer arriveData;
	private UtilityLogic uti=new UtilityLogic();
	public ArriveOrderLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (ArriveOrderDFacSer)Naming.lookup(Url.URL);
			arriveData = dataFac.getArriveOrder();
			uti=new UtilityLogic();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public Result create(ArriveVO order,String org) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.SUCCESS;
		try {
			isSuc = arriveData.create(VPFactory.toArrivePO(order, ""));
			if(isSuc.equals(Result.SUCCESS))
			{
				
				ArrayList<String> expresses=arriveData.getExpressList(order.getId());
				for(String express:expresses)
				{
					UpdateTransitInfoLogic.update(express, order.getDate()+"位于"+org);
				}
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		
		return isSuc;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
//		ArrayList<String> cities = null;
//		try {
//			cities = arriveData.getCities();
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		return new ResultMessage(Result.SUCCESS, cities);
		
		ResultMessage rm=uti.getCities();
		if(rm.getReInfo()!=Result.SUCCESS){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		
		@SuppressWarnings("unchecked")
		ArrayList<CityVO> city=(ArrayList<CityVO>)rm.getMessage();
		CityVO[] cityArray=new CityVO[city.size()];
		for(int i=0;i<city.size();i++){
			cityArray[i]=city.get(i);
		}
		return new ResultMessage(Result.SUCCESS,cityArray);
	}
	@Override
	public ResultMessage getLocalHallsAndAllCenter(String orgId) {
		return uti.getLocalHallAndAllCenter(orgId);
	}
	
}
