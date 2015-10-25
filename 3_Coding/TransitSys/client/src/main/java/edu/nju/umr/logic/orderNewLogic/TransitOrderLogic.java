package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.logicService.orderNewLogic.TransitOrderLSer;
import edu.nju.umr.po.order.TransitPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.TransitVO;
import edu.nju.umr.dataService.dataFactory.TransitOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.TransitOrderDSer;

public class TransitOrderLogic implements TransitOrderLSer{
	TransitOrderDFacSer dataFac;
	TransitOrderDSer transitData;
	
	public TransitOrderLogic(){
		try{
			dataFac=(TransitOrderDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			transitData=dataFac.getTransitOrder();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean create(TransitVO order) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try{
			TransitPO orderPO=new TransitPO(order.getId(),order.getPlaneId(),order.getStartPlace(),order.getArrivePlace(),order.getContainerId(),order.getSupervision(),order.getExpress());
			transitData.create(orderPO);
			isSuccessful=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
		ArrayList<String> ar= null;
		boolean isSuccessful=false;
		try{
			ar=transitData.getCities();
			isSuccessful=true;
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		ArrayList<String> arVO=new ArrayList<String>();
		for(int i=0;i<ar.size();i++)
		{
			arVO.add(ar.get(i));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}

}
