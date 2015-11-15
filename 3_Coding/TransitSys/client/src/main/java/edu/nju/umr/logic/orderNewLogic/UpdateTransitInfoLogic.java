package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;

import edu.nju.umr.dataService.orderNewDSer.UpdateTransitInfoDSer;
import edu.nju.umr.dataService.dataFactory.UpdateTransitInfoDFacSer;
import edu.nju.umr.po.TransitInfoPO;
import edu.nju.umr.url.Url;

public class UpdateTransitInfoLogic {
	UpdateTransitInfoDFacSer dataFac;
	UpdateTransitInfoDSer data;
	public UpdateTransitInfoLogic() {
		// TODO 自动生成的构造函数存根
		try {
			dataFac=(UpdateTransitInfoDFacSer)Naming.lookup(Url.URL);
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
