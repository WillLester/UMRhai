package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.orderNew.RecipientOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.RecipientOrderDSer;
import edu.nju.umr.logic.orderApproveLogic.UpdateTranStateLogic;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.OrderInfoLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderApproveLogicSer.UpdateTranStateLSer;
import edu.nju.umr.logicService.orderNewLogic.RecipientOrderLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.RecipientVO;

public class RecipientOrderLogic implements RecipientOrderLSer{
	private RecipientOrderDFacSer dataFac;
	private RecipientOrderDSer recipientData;
	private UtilityLogic uti=new UtilityLogic();
	private DiaryUpdateLSer diarySer;
	private OrderInfoLSer orderInfoLogic;
	private UpdateTranStateLSer orderState;
	public RecipientOrderLogic()throws RemoteException {
		try{
			dataFac=(RecipientOrderDFacSer)Naming.lookup(Url.URL);
			recipientData=dataFac.getRecipientOrder();
			orderInfoLogic = new OrderInfoLogic();
			uti=new UtilityLogic();
		}catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        }
		diarySer = new DiaryUpdateLogic();
		orderState=new UpdateTranStateLogic();
	}
	public Result create(RecipientVO order) {
		// TODO 自动生成的方法存根
		Result isSuc=Result.SUCCESS;
		try{
			RecipientPO orderPO=VPFactory.toRecipientPO(order);
			isSuc=recipientData.create(orderPO);
			if(isSuc.equals(Result.SUCCESS)){
				isSuc = diarySer.addDiary("接收了中转单"+order.getTransitId(), order.getOpName());
				orderState.updateCenterLoadingState(order.getTransitId(), true);
				orderState.updateHallLoadingState(order.getTransitId(), true);
			}
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuc;
	}

	public ResultMessage getLocalHallAndCenter(String orgId) {
		// TODO 自动生成的方法存根
		return uti.getLocalHallAndAllCenter(orgId);
		
	}
	@Override
	public boolean isLoadValid(String id) {
		// TODO 自动生成的方法存根
		return orderInfoLogic.isCenterLoadValid(id);
	}
	@Override
	public List<String> expressList(String id) {
		// TODO 自动生成的方法存根
		List<String> list = new LinkedList<String>();
		List<String> express = orderInfoLogic.getCenterLoadExp(id);
		if(express.isEmpty()){
			express = orderInfoLogic.getHallLoadExp(id);
		}
		for(String ex:express){
			list.add(ex);
		}
		return list;
	}
	@Override
	public ResultMessage getNextId(String orgId) {
		// TODO 自动生成的方法存根
		try{
			String date = DateFormat.DATESTRING.format(Calendar.getInstance().getTime());
			return new ResultMessage(Result.SUCCESS,recipientData.getOrderSize(orgId+date));
		}catch(RemoteException e){
			return new ResultMessage(Result.DATABASE_ERROR,null);
		}
	}
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage getComingLoadingOrder(String org) {
		// TODO Auto-generated method stub
		ArrayList<String> ar =new ArrayList<String>();
		ResultMessage message=orderState.getCenterLoadingHere(org, false);
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			return new ResultMessage(result,null);
		}
		ar.addAll((ArrayList<String>)message.getMessage());
		message=orderState.getHallLoadingHere(org, false);
		result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			return new ResultMessage(result,null);
		}
		ar.addAll((ArrayList<String>)message.getMessage());
		return new ResultMessage(Result.SUCCESS,ar);
	}

}
