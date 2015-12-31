package edu.nju.umr.data.driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.data.workOrgManData.VanManData;
import edu.nju.umr.dataService.workOrgManDSer.VanManDSer;
import edu.nju.umr.po.VanPO;

public class VanManDriver {
	private VanManDSer serv;
	public VanManDriver() {
		try {
			serv = VanManData.getVanMan();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		try {
			ArrayList<VanPO> vans = serv.findVan(null, "0250");
			for(VanPO van:vans){
				System.out.println(van.getId());
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
