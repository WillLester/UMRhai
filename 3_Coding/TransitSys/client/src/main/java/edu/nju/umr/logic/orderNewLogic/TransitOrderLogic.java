package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.TransitOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.TransitOrderDSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.TransitOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.TransitPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.TransitVO;

public class TransitOrderLogic implements TransitOrderLSer{
	private TransitOrderDFacSer dataFac;
	private TransitOrderDSer transitData;
	private UtilityLogic uti=new UtilityLogic();
	
	public TransitOrderLogic(){
		try{
			dataFac=(TransitOrderDFacSer)Naming.lookup(Url.URL);
			transitData=dataFac.getTransitOrder();
			uti=new UtilityLogic();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public Result create(TransitVO order,String org) {
		// TODO 自动生成的方法存根
//		boolean isSuccessful=false;
		try{
			TransitPO orderPO=VPFactory.toTransitPO(order, "");
			Result result=transitData.create(orderPO);
			if(result.equals(Result.SUCCESS))
			{
				for(String express:order.getExpress())
				UpdateTransitInfoLogic.update(express,DateFormat.TIME.format(Calendar.getInstance().getTime())
						+" "+org+" 已发出 下一站 "+order.getArrivePlace());
			}
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return Result.SUCCESS;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
//		ArrayList<String> ar= null;
//		boolean isSuccessful=false;
//		try{
//			ar=transitData.getCities();
//			isSuccessful=true;
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

	@Override
	public ResultMessage getCenters() {
		
		return uti.getCenter();
	}

}
