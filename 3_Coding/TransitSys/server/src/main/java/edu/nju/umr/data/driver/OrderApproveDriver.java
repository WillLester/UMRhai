package edu.nju.umr.data.driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.data.orderApproveData.OrderApproveData;
import edu.nju.umr.dataService.orderApproveDSer.OrderApproveDSer;
import edu.nju.umr.po.order.OrderPO;

public class OrderApproveDriver {
	private OrderApproveDSer serv;
	public OrderApproveDriver() {
		// TODO 自动生成的构造函数存根
		try {
			serv = OrderApproveData.getOrderApprove();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		try {
			ArrayList<OrderPO> orders = serv.getExamine();
			for(OrderPO order:orders){
				System.out.println(order.getOperator());
				System.out.println(order.getKind());
				System.out.println(order.getTime().getTime());
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
}
