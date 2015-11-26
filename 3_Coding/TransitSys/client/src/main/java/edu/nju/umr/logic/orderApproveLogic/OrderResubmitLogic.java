package edu.nju.umr.logic.orderApproveLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.OrderResubmitDFacSer;
import edu.nju.umr.dataService.orderApproveDSer.OrderResubmitDSer;
import edu.nju.umr.logicService.orderApproveLogicSer.OrderResubmitLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.PaymentVO;

public class OrderResubmitLogic implements OrderResubmitLSer{
	OrderResubmitDFacSer dataFac;
	OrderResubmitDSer resubmitData;
	public OrderResubmitLogic() {
		try{
			dataFac = (OrderResubmitDFacSer)Naming.lookup(Url.URL);
			resubmitData = dataFac.getOrderResubmit();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public ResultMessage getOrders(String id) {
		// TODO 自动生成的方法存根
		ArrayList<Object> orders = null;
		ArrayList<Object> newOrders = new ArrayList<Object>();
		try {
			orders = resubmitData.getOrders(id);

			for(Object order:orders){
				PaymentPO po = (PaymentPO)order;
				PaymentVO vo = new PaymentVO( po.getDate(), po.getPayer(), po.getAccount(), po.getKind(), po.getAmount(), po.getRemarks(),po.getOpName());
				newOrders.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(Result.SUCCESS, newOrders);
	}

}
