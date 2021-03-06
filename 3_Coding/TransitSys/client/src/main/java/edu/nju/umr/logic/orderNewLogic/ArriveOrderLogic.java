package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.orderNew.ArriveOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.ArriveOrderDSer;
import edu.nju.umr.logic.orderApproveLogic.UpdateTranStateLogic;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderApproveLogicSer.UpdateTranStateLSer;
import edu.nju.umr.logicService.orderNewLogic.ArriveOrderLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.utilityLogicSer.UtilityLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ArriveVO;

public class ArriveOrderLogic implements ArriveOrderLSer{
	private ArriveOrderDFacSer dataFac;
	private ArriveOrderDSer arriveData;
	private UtilityLSer uti;
	private DiaryUpdateLSer diarySer;
	private UpdateTranStateLSer orderState;
	public ArriveOrderLogic() throws RemoteException {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (ArriveOrderDFacSer)Naming.lookup(Url.URL);
			arriveData = dataFac.getArriveOrder();
			uti=new UtilityLogic();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        }
		diarySer = new DiaryUpdateLogic();
		orderState=new UpdateTranStateLogic();
	}
	public Result create(ArriveVO order) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.SUCCESS;
		try {
			isSuc = arriveData.create(VPFactory.toArrivePO(order));
			if(isSuc.equals(Result.SUCCESS)){
				String id=order.getId();
					orderState.updateHallLoadingState(id, true);
					orderState.updateTransitState(id, true);
			}
			if(isSuc == Result.SUCCESS){
				isSuc = diarySer.addDiary("生成了到达单"+order.getId(), order.getOpName());
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		
		return isSuc;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
		
		ResultMessage rm=uti.getCities();
		if(rm.getReInfo()!=Result.SUCCESS){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		
		@SuppressWarnings("unchecked")
		ArrayList<CityVO> city=(ArrayList<CityVO>)rm.getMessage();
		CityVO[] cityArray=new CityVO[city.size()];
		for(int i=0;i<city.size();i++){
			cityArray[i]=city.get(i);
		}
		return new ResultMessage(Result.SUCCESS,cityArray);
	}
	@Override
	public ResultMessage getLocalHallsAndAllCenter(String orgId) {
		return uti.getLocalHallAndAllCenter(orgId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage getArriveOrders(String org) {
		// TODO Auto-generated method stub
		ArrayList<String> ar =new ArrayList<String>();
		ResultMessage message=orderState.getHallLoadingHere(org, false);
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			return message;
		}
		ar.addAll((ArrayList<String>)message.getMessage());
		message=orderState.getTransitHere(org, false);
		result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			return message;
		}
		ar.addAll((ArrayList<String>)message.getMessage());
		return new ResultMessage(Result.SUCCESS,ar);
	}
	
}
