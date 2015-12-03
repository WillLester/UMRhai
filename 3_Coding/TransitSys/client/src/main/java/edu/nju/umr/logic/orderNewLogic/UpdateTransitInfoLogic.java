package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.orderNewDSer.UpdateTransitInfoDSer;
import edu.nju.umr.dataService.dataFactory.UpdateTransitInfoDFacSer;
import edu.nju.umr.po.TransitInfoPO;
import edu.nju.umr.po.enums.Result;

public class UpdateTransitInfoLogic{
	private UpdateTransitInfoDFacSer dataFac;
	private static UpdateTransitInfoDSer tInfodata;
	public UpdateTransitInfoLogic() {
		// TODO 自动生成的构造函数存根
		try {
			dataFac=(UpdateTransitInfoDFacSer)Naming.lookup(Url.URL);
			tInfodata=dataFac.getUpdateTransitInfoDSer();
//			isSuc=data.update(new TransitInfoPO(id, info));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static Result update(String id,ArrayList<String> info){
		Result isSuc=Result.DATABASE_ERROR;
		try {
			isSuc=tInfodata.update(new TransitInfoPO(id, info));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return Result.NET_INTERRUPT;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuc;
	}
	public static Result addInfo(String id,ArrayList<String> info){
		Result isSuc=Result.DATABASE_ERROR;
		try {
			isSuc=tInfodata.addInfo(new TransitInfoPO(id, info));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return Result.NET_INTERRUPT;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuc;
	}
}
