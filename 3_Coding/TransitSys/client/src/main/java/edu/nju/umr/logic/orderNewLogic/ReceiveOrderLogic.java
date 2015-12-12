package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.CourierDFacSer;
import edu.nju.umr.dataService.dataFactory.ReceiveOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.ReceiveOrderDSer;
import edu.nju.umr.dataService.transitInfoDSer.CourierDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.ReceiveOrderLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ReceiveVO;

public class ReceiveOrderLogic implements ReceiveOrderLSer{
	
	private ReceiveOrderDFacSer dataFac;
	private ReceiveOrderDSer receiveData;
	private CourierDFacSer cDataFac;
	private CourierDSer cData;
	private ExpressPO express;
	private UpdateTransitInfoLogic infoLogic;
	private DiaryUpdateLSer diarySer;
	public ReceiveOrderLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (ReceiveOrderDFacSer)Naming.lookup(Url.URL);
			receiveData = dataFac.getReceiveOrder();
			cDataFac = (CourierDFacSer) Naming.lookup(Url.URL);
			cData = cDataFac.getCourier();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		infoLogic = new UpdateTransitInfoLogic();
		diarySer = new DiaryUpdateLogic();
	}
	
	public Result create(ReceiveVO receive,String org,String name) {
		// TODO Auto-generated method stub
		express.setRealReceiver(receive.getRealReceiver());
		express.setReceiveTime(receive.getReceiveTime());
		try {
			Result result =  receiveData.create(express);
			if(result == Result.SUCCESS){
				result = infoLogic.update(express.getId(), DateFormat.TIME.format(Calendar.getInstance().getTime())
						+" "+org+" 已签收 签收人 "+receive.getRealReceiver());
				if(result == Result.SUCCESS){
					result = diarySer.addDiary(express.getId()+"收件", name);
				}
			}
			return result;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return Result.NET_INTERRUPT;
		}
	}

	@Override
	public ResultMessage getExpress(String id) {
		// TODO 自动生成的方法存根
		try {
			express = cData.find(id);
			if(express != null){
				return new ResultMessage(Result.SUCCESS, VPFactory.toExpressVO(express));
			} else {
				return new ResultMessage(Result.DATA_NOT_FOUND, null);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ResultMessage(Result.NET_INTERRUPT, null);
		} 
	}

}
