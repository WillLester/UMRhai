package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.TransitOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.TransitOrderDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.TransitOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.po.order.TransitPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.TransitVO;

public class TransitOrderLogic implements TransitOrderLSer{
	private TransitOrderDFacSer dataFac;
	private TransitOrderDSer transitData;
	private UtilityLogic uti=new UtilityLogic();
	private DiaryUpdateLSer diarySer;
	public TransitOrderLogic(){
		try{
			dataFac=(TransitOrderDFacSer)Naming.lookup(Url.URL);
			transitData=dataFac.getTransitOrder();
			uti=new UtilityLogic();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		diarySer = new DiaryUpdateLogic();
	}

	public Result create(TransitVO order) {
		// TODO 自动生成的方法存根
//		boolean isSuccessful=false;
		try{
			TransitPO orderPO=VPFactory.toTransitPO(order, "");
			Result result=transitData.create(orderPO);
			if(result.equals(Result.SUCCESS)){
				result = diarySer.addDiary("生成了中转单"+order.getId(), order.getOpName());
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
		return uti.getCities();
	}

	@Override
	public ResultMessage getCenters() {
		
		return uti.getCenter();
	}

	@Override
	public int isExpressValid(List<String> expressList) {
		// TODO 自动生成的方法存根
		return uti.isExpressListValid(expressList);
	}

	@Override
	public ResultMessage getPrice(String org1, String org2, int tran,
			List<String> expressList) {
		return uti.getPrice(org1, org2, Transit.values()[tran], expressList);
	}

}
