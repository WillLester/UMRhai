package edu.nju.umr.data.driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.data.orderApproveData.UpdateTransitInfoData;
import edu.nju.umr.dataService.orderApproveDSer.UpdateTransitInfoDSer;
import edu.nju.umr.po.TransitInfoPO;
import edu.nju.umr.po.enums.Result;

public class UpdateTransInfoDriver {
	private UpdateTransitInfoDSer serv;
	public UpdateTransInfoDriver() {
		// TODO 自动生成的构造函数存根
		try {
			serv = UpdateTransitInfoData.getUpdateTransit();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		ArrayList<String> info = new ArrayList<String>();
		info.add("您的包裹已经起飞");
		TransitInfoPO po = new TransitInfoPO("1111112312", info);
		try {
			Result re = serv.addInfo(po);
			System.out.println(re);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		info.add("您的包裹已经降落");
		TransitInfoPO po2 = new TransitInfoPO("1111112312", info);
		try {
			Result re = serv.update(po2);
			System.out.println(re);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
