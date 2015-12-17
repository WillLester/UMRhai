package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.RecipientOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.RecipientOrderDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.OrderInfoLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.RecipientOrderLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.RecipientVO;

public class RecipientOrderLogic implements RecipientOrderLSer{
	private RecipientOrderDFacSer dataFac;
	private RecipientOrderDSer recipientData;
	private UtilityLogic uti=new UtilityLogic();
	private DiaryUpdateLSer diarySer;
	private OrderInfoLSer orderInfoLogic;
	public RecipientOrderLogic(){
		try{
			dataFac=(RecipientOrderDFacSer)Naming.lookup(Url.URL);
			recipientData=dataFac.getRecipientOrder();
			orderInfoLogic = new OrderInfoLogic();
			uti=new UtilityLogic();
		} catch(Exception e) {
			e.printStackTrace();
		}
		diarySer = new DiaryUpdateLogic();
	}
	public Result create(RecipientVO order) {
		// TODO 自动生成的方法存根
		Result isSuc=Result.SUCCESS;
		try{
			RecipientPO orderPO=VPFactory.toRecipientPO(order, "");
			isSuc=recipientData.create(orderPO);
			if(isSuc.equals(Result.SUCCESS)){
				isSuc = diarySer.addDiary("接收了中转单"+order.getTransitId(), order.getOpName());
			}
			
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuc;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
		ResultMessage message = uti.getCities();
		if(message.getReInfo() == Result.SUCCESS){
			@SuppressWarnings("unchecked")
			List<CityVO> list = (List<CityVO>) message.getMessage();
			String[] cityList = new String[list.size()];
			for(int i = 0;i < list.size();i++){
				cityList[i] = list.get(i).getName();
			}
			return new ResultMessage(Result.SUCCESS, cityList);
		} else {
			return new ResultMessage(message.getReInfo(), null);
		}
		
	}
	@Override
	public boolean isTransitValid(String id) {
		// TODO 自动生成的方法存根
		return orderInfoLogic.isTransitValid(id);
	}
	@Override
	public List<String> expressList(String id) {
		// TODO 自动生成的方法存根
		List<String> list = new LinkedList<String>();
		List<String> express = orderInfoLogic.getTransitExp(id);
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
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
	}

}
