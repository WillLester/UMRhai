package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.TransitOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.TransitOrderDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.OrderCalcuLogic;
import edu.nju.umr.logic.utilityLogic.OrderInfoLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.TransitOrderLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderCalcuLSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.logicService.utilityLogicSer.UtilityLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.po.order.TransitPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.TransitVO;

public class TransitOrderLogic implements TransitOrderLSer{
	private TransitOrderDFacSer dataFac;
	private TransitOrderDSer transitData;
	private UtilityLSer uti;
	private DiaryUpdateLSer diarySer;
	private OrderInfoLSer orderInfo;
	private OrderCalcuLSer orderCalcu;
	public TransitOrderLogic(){
		try {
			dataFac = (TransitOrderDFacSer)Naming.lookup(Url.URL);
			transitData = dataFac.getTransitOrder();
		} catch (Exception e){
			e.printStackTrace();
		}
		uti = new UtilityLogic();
		diarySer = new DiaryUpdateLogic();
		orderInfo = new OrderInfoLogic();
		orderCalcu = new OrderCalcuLogic();
	}

	public Result create(TransitVO order) {
		// TODO 自动生成的方法存根
		try {
			TransitPO orderPO = VPFactory.toTransitPO(order);
			Result result = transitData.create(orderPO);
			if(result == Result.SUCCESS){
				result = diarySer.addDiary("生成了中转单"+order.getId(), order.getOpName());
			}
		} catch (RemoteException e){
			return Result.NET_INTERRUPT;
		} catch (Exception e){
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
		return uti.getCenterNames();
	}

	@Override
	public int isExpressValid(List<String> expressList) {
		// TODO 自动生成的方法存根
		return orderInfo.isExpressListValid(expressList);
	}

	@Override
	public ResultMessage getPrice(String org1, String org2, int tran,
			List<String> expressList) {
		return orderCalcu.getPrice(org1, org2, Transit.values()[tran], expressList);
	}

	@Override
	public ResultMessage getNextId(String orgId) {
		// TODO Auto-generated method stub
		String time=DateFormat.DATESTRING.format(Calendar.getInstance().getTime());
		try{
			int num = transitData.getOrderSize(orgId+time);
			if(num==-1)
			{
				return new ResultMessage(Result.DATABASE_ERROR,null);
			}
			return new ResultMessage(Result.SUCCESS,num);
		}catch(RemoteException e)
		{
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
	}

}
