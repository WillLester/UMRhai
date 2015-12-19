package edu.nju.umr.data.driver;

import java.rmi.RemoteException;

import edu.nju.umr.data.utilityData.OrderCalcuData;
import edu.nju.umr.dataService.utilityDSer.OrderCalcuDSer;
import edu.nju.umr.po.CitiesPO;

public class OrderCalcuDriver {
	private OrderCalcuDSer serv;
	public OrderCalcuDriver() {
		try {
			serv = OrderCalcuData.getOrderCalcu();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		try {
			CitiesPO cities = serv.getCitesPO("北京", "南京");
			System.out.println(cities.getDistance());
			System.out.println(cities.getCity1());
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
