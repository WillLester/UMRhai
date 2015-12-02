package edu.nju.umr.logic.orderApproveLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.OrderResubmitDFacSer;
import edu.nju.umr.dataService.orderApproveDSer.OrderResubmitDSer;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderApproveLogicSer.OrderResubmitLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.KindGetter;
import edu.nju.umr.po.order.OrderPO;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.OrderVO;
import edu.nju.umr.vo.order.PaymentVO;

public class OrderResubmitLogic implements OrderResubmitLSer{
	private OrderResubmitDFacSer dataFac;
	private OrderResubmitDSer resubmitData;
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
	
	public ResultMessage toRevise(){
		ArrayList<OrderPO> orderpo=new ArrayList<OrderPO>();
		ArrayList<OrderVO> ordervo=new ArrayList<OrderVO>();
		try {
			orderpo=resubmitData.getRevise();
			for(OrderPO po:orderpo){
				OrderVO vo=VPFactory.toOrderVO(po);
				ordervo.add(vo);
			}
			if(orderpo.size()==0){
				return new ResultMessage(Result.DATA_NOT_FOUND,null);
			}else
				return new ResultMessage(Result.SUCCESS,ordervo);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
	}
	
	public ResultMessage getOrders(String id) {
		// TODO 自动生成的方法存根
		ArrayList<KindGetter> orders = null;
		ArrayList<KindGetter> newOrders = new ArrayList<KindGetter>();
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
