package edu.nju.umr.data.driver;

import java.rmi.RemoteException;

import edu.nju.umr.data.orderNewData.CenterLoadingOrderData;
import edu.nju.umr.dataService.orderNewDSer.CenterLoadingOrderDSer;

public class CenterLoadDriver {
	private CenterLoadingOrderDSer serv;
	public CenterLoadDriver() {
		// TODO 自动生成的构造函数存根
		try {
			serv = CenterLoadingOrderData.getCenterLoading();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		try {
			int size = serv.getOrderSize("025020151218");
			System.out.println(size);
			size = serv.getOrderSize("025020151216");
			System.out.println(size);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
