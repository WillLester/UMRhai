package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.orderNew.SendOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.SendOrderDSer;
import edu.nju.umr.logic.orderApproveLogic.UpdateTranStateLogic;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderApproveLogicSer.UpdateTranStateLSer;
import edu.nju.umr.logicService.orderNewLogic.SendOrderLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.SendVO;

public class SendOrderLogic implements SendOrderLSer{
	private SendOrderDFacSer dataFac;
	private SendOrderDSer sendData;
	private UtilityLogic uti=new UtilityLogic();
	private DiaryUpdateLSer diarySer;
	private UpdateTranStateLSer orderState;
	public SendOrderLogic()throws RemoteException{
		try{
			dataFac=(SendOrderDFacSer)Naming.lookup(Url.URL);
			sendData=dataFac.getSendOrder();
		}catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        }
		diarySer = new DiaryUpdateLogic();
		orderState=new UpdateTranStateLogic();
	}
	public Result create(SendVO order) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATABASE_ERROR;
		try{
			SendPO orderPO=VPFactory.toSendPO(order);
			isSuccessful=sendData.create(orderPO);
			if(isSuccessful.equals(Result.SUCCESS)){
				isSuccessful = diarySer.addDiary("生成了派件单，派出"+order.getExpressId(), order.getOpName());
				orderState.updateExpressState(order.getExpressId(), order.getId().substring(0,6)+"*#");
			}
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage getCouriers(String id) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		List<String> ar= null;
		ar = uti.getCouriers(id);
		isSuccessful=Result.SUCCESS;
		if(ar.isEmpty()){
			isSuccessful = Result.NET_INTERRUPT;
			return new ResultMessage(isSuccessful, null);
		} else {
			String[] list = new String[ar.size()];
			for(int i = 0;i < list.length;i++){
				list[i] = ar.get(i);
			}
			return new ResultMessage(Result.SUCCESS, list);
		}
	}
	@Override
	public ResultMessage getNextId(String orgId) {
		// TODO 自动生成的方法存根
		try{
			String date = DateFormat.DATESTRING.format(Calendar.getInstance().getTime());
			return new ResultMessage(Result.SUCCESS,sendData.getOrderSize(orgId+date));
		}catch(RemoteException e){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
	}
	@Override
	public ResultMessage getGoingExpress(String orgId) {
		// TODO Auto-generated method stub
		return orderState.getExpressHere(orgId);
	}

}
