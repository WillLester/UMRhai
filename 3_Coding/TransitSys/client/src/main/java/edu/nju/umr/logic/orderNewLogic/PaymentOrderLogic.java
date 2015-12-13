package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.PaymentOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.PaymentOrderDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.PaymentOrderLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.utilityLogicSer.UtilityLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.PaymentVO;

public class PaymentOrderLogic implements PaymentOrderLSer{
	private PaymentOrderDFacSer dataFac;
	private PaymentOrderDSer paymentData;
	private UtilityLSer uti;
	private DiaryUpdateLSer diarySer;
	public PaymentOrderLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (PaymentOrderDFacSer)Naming.lookup(Url.URL);
			paymentData = dataFac.getPaymentOrder();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		uti = new UtilityLogic();
		diarySer = new DiaryUpdateLogic();
	}
	public Result create(PaymentVO order) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.SUCCESS;
		try {
			isSuc = paymentData.create(VPFactory.toPaymentPO(order, 0));
			if(isSuc == Result.SUCCESS){
				isSuc = paymentData.updateAccount(order.getAccount(), order.getAmount());
				if(isSuc == Result.SUCCESS){
					isSuc = diarySer.addDiary("生成了付款单", order.getOpName());
				}
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return Result.NET_INTERRUPT;
		} catch (Exception e) { 
            e.printStackTrace();   
        } 
		
		return isSuc;
	}

	public ResultMessage getAccount() {
		return uti.getAccountNames();
	}

}
