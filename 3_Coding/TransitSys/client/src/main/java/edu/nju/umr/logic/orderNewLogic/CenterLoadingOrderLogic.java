package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.CenterLoadingOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.CenterLoadingOrderDSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.orderNewLogic.CenterLoadingOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.CenterLoadingVO;

public class CenterLoadingOrderLogic implements CenterLoadingOrderLSer{
	CenterLoadingOrderDFacSer dataFac;
	CenterLoadingOrderDSer centerData;
	UtilityLogic uti=new UtilityLogic();
	public CenterLoadingOrderLogic() {
		try{
			dataFac = (CenterLoadingOrderDFacSer)Naming.lookup(Url.URL);
			centerData = dataFac.getCenterLoadingOrder();
			uti=new UtilityLogic();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public Result create(CenterLoadingVO order) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.SUCCESS;
		try {
			isSuc = centerData.create(new CenterLoadingPO(order.getDate(), "s", order.getTarget(), order.getVanId(), order.getSupervision(), order.getEscort(), order.getExpress(),Calendar.getInstance(),order.getOpName()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		
		return isSuc;
	}

	public ResultMessage getHalls() {
		// TODO 自动生成的方法存根
//		ArrayList<String> halls = null;
//		try {
//			halls = centerData.getHalls();
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		return new ResultMessage(Result.SUCCESS, halls);
		ResultMessage rm=uti.getHall();
		if(rm.getReInfo()!=Result.SUCCESS){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		ArrayList<OrgVO> halls=(ArrayList<OrgVO>)rm.getMessage();
		OrgVO hallArray[]=new OrgVO[halls.size()];
		for(int i=0;i<halls.size();i++){
			hallArray[i]=halls.get(i);
		}
		return new ResultMessage(Result.SUCCESS,hallArray);
	}

}
