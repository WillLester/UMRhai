package edu.nju.umr.data.driver;

import java.util.List;
import java.rmi.RemoteException;

import edu.nju.umr.data.utilityData.OrderInfoData;
import edu.nju.umr.dataService.utilityDSer.OrderInfoDSer;

public class OrderInfoDriver {
	private OrderInfoDSer serv;
	public OrderInfoDriver() {
		try {
			serv = OrderInfoData.getOrderInfo();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		try {
			List<String> expresses = serv.getTransitExp("0250201512150000000");
			for(String exp:expresses){
				System.out.println(exp);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
