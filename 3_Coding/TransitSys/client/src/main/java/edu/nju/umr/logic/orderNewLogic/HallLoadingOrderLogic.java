package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.dataService.dataFactory.HallLoadingOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.HallLoadingOrderDSer;
import edu.nju.umr.logicService.orderNewLogic.HallLoadingOrderLSer;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.HallLoadingVO;
import edu.nju.umr.po.order.HallLoadingPO;

public class HallLoadingOrderLogic implements HallLoadingOrderLSer{
	HallLoadingOrderDFacSer dataFac;
	HallLoadingOrderDSer hallData;
	public HallLoadingOrderLogic() {
		try{
			dataFac = (HallLoadingOrderDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			hallData = dataFac.getHallLoadingOrder();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		// TODO 自动生成的构造函数存根
	}
	public boolean create(HallLoadingVO order) {
		// TODO 自动生成的方法存根
		boolean isSuc=false;
//		try
//		{
//			isSuc=hallData.create(new HallLoadingPO(order.getHallId(),order.getConvertId(),order.getArriveLoc(),order.getVanId(),order.getSupervision(),order.getEscort(),order.getExpress()));
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		return isSuc;
	}

	public ResultMessage getOrgs() {
		// TODO 自动生成的方法存根
		ArrayList<String> orgs = null;
		try {
			orgs = hallData.getOrgs();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(true, orgs);
	}

	public ResultMessage getVans() {
		// TODO 自动生成的方法存根
		ArrayList<String> vans = null;
		try {
			vans = hallData.getVans();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(true, vans);
	}

}
