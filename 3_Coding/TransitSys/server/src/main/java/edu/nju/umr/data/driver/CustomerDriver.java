package edu.nju.umr.data.driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.data.transitInfoData.CustomerData;
import edu.nju.umr.dataService.transitInfoDSer.CustomerDSer;

public class CustomerDriver {
	private CustomerDSer serv;
	public CustomerDriver() {
		try {
			serv = CustomerData.getCustomerData();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		try {
			ArrayList<String> info = serv.findTransit("1000000000");
			for(String in:info){
				System.out.println(in);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
