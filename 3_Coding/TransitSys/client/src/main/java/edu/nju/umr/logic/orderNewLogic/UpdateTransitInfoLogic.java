package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.util.ArrayList;

import javax.activation.DataContentHandlerFactory;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.orderNewDSer.UpdateTransitInfoDSer;
import edu.nju.umr.dataService.dataFactory.UpdateTransitInfoDFacSer;
import edu.nju.umr.po.TransitInfoPO;
import edu.nju.umr.po.enums.Result;

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
	public static Result update(String id,ArrayList<String> info){
		Result isSuc=Result.DATABASE_ERROR;
		isSuc=data.update(new TransitInfoPO(id, info));
		return isSuc;
	}
	public static Result addInfo(String id,ArrayList<String> info){
		Result isSuc=Result.DATABASE_ERROR;
		isSuc=data.addInfo(new TransitInfoPO(id, info));
		return isSuc;
	}
}
