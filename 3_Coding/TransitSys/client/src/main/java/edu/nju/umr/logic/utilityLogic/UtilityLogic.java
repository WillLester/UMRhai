package edu.nju.umr.logic.utilityLogic;

import java.rmi.Naming;
import java.util.Calendar;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.dataService.dataFactory.UtilityDFacSer;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;

public class UtilityLogic {
	public ResultMessage getCities(){
		return null;
	}
	public ResultMessage getOrgs(){
		return null;
	}
//	public ResultMessage getWorkers(String orgId){
//		return null;
//	}
//	public ResultMessage getVans(String orgId){
//		return null;
//	}
	public ResultMessage getStocks(){
		return null;
	}
	
	public static boolean setRecord(Calendar cal,String op,String opt){
		boolean isSuc=false;
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
