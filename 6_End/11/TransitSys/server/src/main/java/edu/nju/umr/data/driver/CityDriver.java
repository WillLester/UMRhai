package edu.nju.umr.data.driver;

import java.rmi.RemoteException;

import edu.nju.umr.data.cityData.CityData;
import edu.nju.umr.dataService.cityDSer.CityDSer;
import edu.nju.umr.po.enums.Result;

public class CityDriver {
	private CityDSer serv;
	public CityDriver() {
		// TODO 自动生成的构造函数存根
		try {
			serv = CityData.getCity();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		
		try {
			Result r = serv.isCityUsed("南京", "025");
			System.out.println(r);
			r = serv.isCityUsed("呼和浩特", "0211");
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
