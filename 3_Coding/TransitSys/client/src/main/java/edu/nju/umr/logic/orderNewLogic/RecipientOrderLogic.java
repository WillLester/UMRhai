package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Calendar;

import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.RecipientOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.RecipientVO;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.RecipientOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.RecipientOrderDSer;

public class RecipientOrderLogic implements RecipientOrderLSer{
	RecipientOrderDFacSer dataFac;
	RecipientOrderDSer recipientData;
	UtilityLogic uti=new UtilityLogic();
	public RecipientOrderLogic(){
		try{
		dataFac=(RecipientOrderDFacSer)Naming.lookup(Url.URL);
		recipientData=dataFac.getRecipientOrder();
		uti=new UtilityLogic();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Result create(RecipientVO order) {
		// TODO 自动生成的方法存根
//		boolean isSuccessful=false;
		Result isSuc=Result.SUCCESS;
		try{
			RecipientPO orderPO=VPFactory.toRecipientPO(order, "");
			isSuc=recipientData.create(orderPO);
//			isSuccessful=true;
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuc;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
//		ArrayList<String> ar= null;
//		try{
//			ar=recipientData.getCities();
//		}
//		catch(RemoteException e){
//			e.printStackTrace();
//		}
//		ArrayList<String> arVO=new ArrayList<String>();
//		for(int i=0;i<ar.size();i++)
//		{
//			arVO.add(ar.get(i));
//		}
//		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
//		return message;
		return uti.getCities();
		
	}

}
