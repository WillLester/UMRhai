package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.IncomeOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.IncomeOrderDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.IncomeOrderLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public class IncomeOrderLogic implements IncomeOrderLSer{
	private IncomeOrderDFacSer dataFac;
	private IncomeOrderDSer incomeData;
	private UtilityLogic uti=new UtilityLogic();
	private DiaryUpdateLSer diarySer;
	public IncomeOrderLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (IncomeOrderDFacSer)Naming.lookup(Url.URL);
			incomeData = dataFac.getIncomeOrder();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		diarySer = new DiaryUpdateLogic();
	}
	public Result create(IncomeVO order) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.DATA_NOT_FOUND;
		try {
			isSuc = incomeData.create(VPFactory.toIncomePO(order, 0));
			isSuc = diarySer.addDiary("生成了收款单", order.getOpName());
		} catch (RemoteException e) {
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}catch (Exception e) { 
            e.printStackTrace();   
        } 

		return isSuc;
	}

	public ResultMessage getCouriers(String id) {
		// TODO 自动生成的方法存根
		ArrayList<String> couriers = null;
		Result isSuc = Result.DATA_NOT_FOUND;
		try {
			couriers = uti.getCouriers(id);
			String[] cour= new String[couriers.size()];//这里代码貌似并不需要
			for(int i = 0;i < cour.length;i++){
				cour[i] = couriers.get(i);
			}
			isSuc=Result.SUCCESS;
			return new ResultMessage(isSuc, cour);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		} catch (Exception e) { 
            e.printStackTrace();   
        } 
		return new ResultMessage(isSuc, couriers);
	}

}
