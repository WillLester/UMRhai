package edu.nju.umr.data.driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.data.orderApproveData.OrderResubmitData;
import edu.nju.umr.dataService.orderApproveDSer.OrderResubmitDSer;
import edu.nju.umr.po.order.function.KindGetter;

public class OrderResubmitDriver {
	private OrderResubmitDSer serv;
	public OrderResubmitDriver() {
		// TODO 自动生成的构造函数存根
		try {
			serv = OrderResubmitData.getOrderResubmit();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		try {
			ArrayList<KindGetter> orders = serv.getOrders("baohua");
			for(KindGetter order:orders){
				System.out.println(order.getOrderKind());
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
