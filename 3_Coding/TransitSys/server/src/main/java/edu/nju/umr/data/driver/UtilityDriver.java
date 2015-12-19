package edu.nju.umr.data.driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.data.utilityData.UtilityData;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;
import edu.nju.umr.po.WorkPO;

public class UtilityDriver {
	private UtilityDSer serv;
	public UtilityDriver() {
		try {
			serv = UtilityData.getUtility();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		try {
			ArrayList<WorkPO> works = serv.getCouriers("025000");
			for(WorkPO work:works){
				System.out.println(work.getName());
				System.out.println(work.getMobile());
				System.out.println(work.getOrg());
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
