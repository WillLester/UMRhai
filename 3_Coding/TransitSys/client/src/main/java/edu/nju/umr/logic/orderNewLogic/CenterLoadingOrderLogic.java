package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.orderNew.CenterLoadingOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.CenterLoadingOrderDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.OrderCalcuLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.CenterLoadingOrderLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderCalcuLSer;
import edu.nju.umr.logicService.utilityLogicSer.UtilityLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.CenterLoadingVO;

public class CenterLoadingOrderLogic implements CenterLoadingOrderLSer{
	private CenterLoadingOrderDFacSer dataFac;
	private CenterLoadingOrderDSer centerData;
	private UtilityLSer uti;
	private DiaryUpdateLSer diarySer;
	private OrderCalcuLSer orderCalcu;
	public CenterLoadingOrderLogic() {
		try{
			dataFac = (CenterLoadingOrderDFacSer)Naming.lookup(Url.URL);
			centerData = dataFac.getCenterLoadingOrder();	
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		uti=new UtilityLogic();
		orderCalcu = new OrderCalcuLogic();
		diarySer = new DiaryUpdateLogic();
	}
	public Result create(CenterLoadingVO order) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.SUCCESS;
		try {
			isSuc = centerData.create(VPFactory.toCenterLoadPO(order));
			if(isSuc.equals(Result.SUCCESS)){
				isSuc = diarySer.addDiary("生成了中转中心装车单"+order.getTransitId(), order.getOpName());
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		
		return isSuc;
	}

	public ResultMessage getHalls() {
		// TODO 自动生成的方法存根
		return uti.getHallNames();
	}
	public ResultMessage getPrice(String org1,String org2,List<String> expressList)
	{
		return orderCalcu.getPrice(org1, org2, Transit.VAN,expressList);
	}
	@Override
	public ResultMessage getNextId(String orgId) {
		try{
			String date=DateFormat.DATESTRING.format(Calendar.getInstance().getTime());
			return new ResultMessage(Result.SUCCESS,centerData.getOrderSize(orgId+date));
		}catch(RemoteException e)
		{
			return new ResultMessage(Result.DATABASE_ERROR,null);
		}
	}

}
