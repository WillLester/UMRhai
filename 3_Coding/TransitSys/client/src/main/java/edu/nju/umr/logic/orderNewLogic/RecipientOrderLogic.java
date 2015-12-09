package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.RecipientOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.RecipientOrderDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.RecipientOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.RecipientVO;

public class RecipientOrderLogic implements RecipientOrderLSer{
	private RecipientOrderDFacSer dataFac;
	private RecipientOrderDSer recipientData;
	private UtilityLogic uti=new UtilityLogic();
	private UpdateTransitInfoLogic infoLogic;
	private DiaryUpdateLSer diarySer;
	public RecipientOrderLogic(){
		try{
			dataFac=(RecipientOrderDFacSer)Naming.lookup(Url.URL);
			recipientData=dataFac.getRecipientOrder();
			uti=new UtilityLogic();
		} catch(Exception e) {
			e.printStackTrace();
		}
		infoLogic = new UpdateTransitInfoLogic();
		diarySer = new DiaryUpdateLogic();
	}
	public Result create(RecipientVO order,String org) {
		// TODO 自动生成的方法存根
		Result isSuc=Result.SUCCESS;
		try{
			RecipientPO orderPO=VPFactory.toRecipientPO(order, "");
			isSuc=recipientData.create(orderPO);
			if(isSuc.equals(Result.SUCCESS)){
				for(String express:recipientData.getExpressList(order.getTransitId())){
					infoLogic.update(express, DateFormat.TIME.format(Calendar.getInstance().getTime()
							+" "+org+" 已收入"));
				}
			}
			isSuc = diarySer.addDiary("接收了中转单"+order.getTransitId(), order.getOpName());
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
			List<String> list = (List<String>) message.getMessage();
			String[] cityList = new String[list.size()];
			for(int i = 0;i < list.size();i++){
				cityList[i] = list.get(i);
			}
			return new ResultMessage(Result.SUCCESS, cityList);
		} else {
			return new ResultMessage(message.getReInfo(), null);
		}
		
	}
	@Override
	public boolean isTransitValid(String id) {
		// TODO 自动生成的方法存根
		return uti.isTransitValid(id);
	}
	@Override
	public List<String> expressList(String id) {
		// TODO 自动生成的方法存根
		LinkedList<String> list = new LinkedList<String>();
		try {
			ArrayList<String> express = recipientData.getExpressList(id);
			for(String ex:express){
				list.add(ex);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return list;
		}
		return list;
	}

}
