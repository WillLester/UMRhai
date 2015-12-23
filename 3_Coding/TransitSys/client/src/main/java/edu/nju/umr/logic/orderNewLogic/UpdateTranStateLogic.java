package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.orderNew.UpdateTranStateDFacSer;
import edu.nju.umr.dataService.orderNewDSer.UpdateTranStateDSer;
import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.Parse;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ExpressPO;
public class UpdateTranStateLogic{
	UpdateTranStateDFacSer dataFac;
	UpdateTranStateDSer updateData;
	public UpdateTranStateLogic(){
		try{
			dataFac = (UpdateTranStateDFacSer)Naming.lookup(Url.URL);
			updateData = dataFac.getUpdateTranState();		
		} catch (NotBoundException e) { 
			e.printStackTrace(); 
		}catch (MalformedURLException e) { 
			e.printStackTrace(); 
		} catch (RemoteException e) { 
			e.printStackTrace();   
		} 
	}
	public Result updateExpressState(String id,String nowOrgId){
		ExpressPO ex=new ExpressPO(null,null,null,null,null,null,null,null,null,null,0,null,0,
				0,0,0,0,id,null,null,null,0, null, null, null, null,null,null,null,null,nowOrgId);
		try{
			return updateData.updateTranState(ex);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}
	}
}
