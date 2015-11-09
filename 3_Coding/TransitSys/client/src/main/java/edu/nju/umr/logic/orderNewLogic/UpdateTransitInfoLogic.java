package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;

import edu.nju.umr.dataService.orderNewDSer.UpdateTransitInfoDSer;
import edu.nju.umr.dataService.dataFactory.UpdateTransitInfoDFacSer;

public class UpdateTransitInfoLogic {
	public static boolean update(String id,String info){
		UpdateTransitInfoDFacSer dataFac;
		UpdateTransitInfoDSer data;
		boolean isSuc=false;
		try
		{
			dataFac=(UpdateTransitInfoDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			data=dataFac.getUpdateTransitInfoDSer();
			isSuc=data.update(id, info);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuc;
	}

}
