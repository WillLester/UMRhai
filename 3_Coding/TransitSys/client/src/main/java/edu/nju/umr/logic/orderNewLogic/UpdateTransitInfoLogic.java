package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;

import edu.nju.umr.dataService.orderNewDSer.UpdateTransitInfoDSer;
import edu.nju.umr.dataService.dataFactory.UpdateTransitInfoDFacSer;
import edu.nju.umr.po.TransitInfoPO;

public class UpdateTransitInfoLogic {
	UpdateTransitInfoDFacSer dataFac;
	UpdateTransitInfoDSer data;
	public UpdateTransitInfoLogic() {
		// TODO 自动生成的构造函数存根
		try {
			dataFac=(UpdateTransitInfoDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			data=dataFac.getUpdateTransitInfoDSer();
//			isSuc=data.update(new TransitInfoPO(id, info));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static boolean update(String id,String info){
		boolean isSuc=false;
		return isSuc;
	}
	public static boolean addInfo(String id,String info){
		boolean isSuc = false;
		return isSuc;
	}
}
