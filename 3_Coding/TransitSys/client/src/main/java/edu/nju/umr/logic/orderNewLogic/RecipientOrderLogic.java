package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.logicService.orderNewLogic.RecipientOrderLSer;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.RecipientVO;
import edu.nju.umr.dataService.dataFactory.RecipientOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.RecipientOrderDSer;

public class RecipientOrderLogic implements RecipientOrderLSer{
	RecipientOrderDFacSer dataFac;
	RecipientOrderDSer recipientData;
	public RecipientOrderLogic(){
		try{
		dataFac=(RecipientOrderDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
		recipientData=dataFac.getRecipientOrder();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean create(RecipientVO order) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try{
			RecipientPO orderPO=new RecipientPO(order.getDate(),order.getId(),order.getTransitId(),order.getStartPlace(),order.getState());
			recipientData.create(orderPO);
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
			ar=recipientData.getCities();
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
