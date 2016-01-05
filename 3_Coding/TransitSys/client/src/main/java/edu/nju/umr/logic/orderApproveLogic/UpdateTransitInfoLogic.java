package edu.nju.umr.logic.orderApproveLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.CustomerDFacSer;
import edu.nju.umr.dataService.dataFactory.orderNew.UpdateTransitInfoDFacSer;
import edu.nju.umr.dataService.orderApproveDSer.UpdateTransitInfoDSer;
import edu.nju.umr.dataService.transitInfoDSer.CustomerDSer;
import edu.nju.umr.po.TransitInfoPO;
import edu.nju.umr.po.enums.Result;

public class UpdateTransitInfoLogic{
	private UpdateTransitInfoDFacSer dataFac;
	private UpdateTransitInfoDSer tInfodata;
	private CustomerDFacSer checkFac;
	private CustomerDSer checkInfoData;
	public UpdateTransitInfoLogic() throws RemoteException {
		// TODO 自动生成的构造函数存根
		try {
			dataFac=(UpdateTransitInfoDFacSer)Naming.lookup(Url.URL);
			tInfodata=dataFac.getUpdateTransitInfoDSer();
			checkFac = (CustomerDFacSer) Naming.lookup(Url.URL);
			checkInfoData = checkFac.getCustomer();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public Result update(String id,String info){
		Result isSuc=Result.DATABASE_ERROR;
		try {
			ArrayList<String> infos = checkInfoData.findTransit(id);
			infos.add(info);
			isSuc=tInfodata.update(new TransitInfoPO(id, infos));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return Result.NET_INTERRUPT;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuc;
	}
	public Result addInfo(String id,String info){
		Result isSuc=Result.DATABASE_ERROR;
		try {
			ArrayList<String> infos = new ArrayList<String>();
			infos.add(info);
			isSuc=tInfodata.addInfo(new TransitInfoPO(id, infos));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return Result.NET_INTERRUPT;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuc;
	}
}
