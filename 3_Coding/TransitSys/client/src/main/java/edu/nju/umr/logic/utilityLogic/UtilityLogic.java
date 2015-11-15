package edu.nju.umr.logic.utilityLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.dataService.dataFactory.UtilityDFacSer;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;

public class UtilityLogic {
	private UtilityDSer utilitySer;
	private UtilityDFacSer utilityFac;
	public UtilityLogic() {
		// TODO 自动生成的构造函数存根
		try {
			utilityFac = (UtilityDFacSer) Naming.lookup("rmi://localhost:8885/DataFactory");
			utilitySer = utilityFac.getUtility();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        }  
	}
	public ResultMessage getCities(){
		return null;
	}
	public ResultMessage getOrgs(){
		return null;
	}
	public ResultMessage getWorkers(String orgId){
		return null;
	}
	public ResultMessage getVans(String orgId){
		return null;
	}
	public ResultMessage getStocks(){
		return null;
	}
	public static Result setRecord(Calendar cal,String op,String opt){
		Result isSuc=Result.SUCCESS;
		try
		{
			UtilityDFacSer dataFac=(UtilityDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			UtilityDSer data=dataFac.getUtility();
			isSuc=data.setRecord(cal, op, opt);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuc;
	}
}
