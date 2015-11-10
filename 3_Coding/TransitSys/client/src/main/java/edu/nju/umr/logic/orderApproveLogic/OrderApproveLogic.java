package edu.nju.umr.logic.orderApproveLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.dataService.dataFactory.OrderApproveDFacSer;
import edu.nju.umr.dataService.orderApproveDSer.OrderApproveDSer;
import edu.nju.umr.logicService.orderApproveLogicSer.OrderApproveLSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.order.OrderPO;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.OrderVO;
import edu.nju.umr.vo.order.PaymentVO;

public class OrderApproveLogic implements OrderApproveLSer{
	OrderApproveDFacSer dataFac;
	OrderApproveDSer approveData;
	public OrderApproveLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (OrderApproveDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			approveData = dataFac.getOrderApprove();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public ResultMessage askExamine() {
		// TODO 自动生成的方法存根
		ArrayList<OrderVO> orders = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderPO> orderList = approveData.getExamine();
			for(OrderPO order:orderList){
				OrderVO vo = new OrderVO(order.getId(), order.getKind(), order.getOperator(), order.getTime(), order.isPassed());
				orders.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(true, orders);
	}

	public boolean examine(boolean approve, ArrayList<String> id) {
		// TODO 自动生成的方法存根
		boolean isSuc = false;
		try {
			isSuc = approveData.update(approve,id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return isSuc;
	}

	public ResultMessage chooseOrder(String id,Order kind) {
		// TODO 自动生成的方法存根
		PaymentVO order = null;
		try {
			PaymentPO orderpo = (PaymentPO) approveData.getOrder(id,kind);
			System.out.println(orderpo.getId());
			order = new PaymentVO(orderpo.getId(), orderpo.getDate(), orderpo.getPayer(), orderpo.getAccount(), orderpo.getKind(), orderpo.getAmount(), orderpo.getRemarks());
			
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(true, order);
	}
	
}
