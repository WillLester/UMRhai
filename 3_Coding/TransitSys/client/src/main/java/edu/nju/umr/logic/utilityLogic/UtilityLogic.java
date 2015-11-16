package edu.nju.umr.logic.utilityLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.url.Url;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.dataService.dataFactory.UtilityDFacSer;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;

public class UtilityLogic {
	private UtilityDSer utilityData;
	private UtilityDFacSer dataFac;
	public UtilityLogic() {
		// TODO 自动生成的构造函数存根
		try {
			dataFac = (UtilityDFacSer) Naming.lookup(Url.URL);
			utilityData = dataFac.getUtility();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        }  
	}
	public ResultMessage getCities(){
		ArrayList<CityVO> cityList = new ArrayList<CityVO>();
		try {
			ArrayList<CityPO> cities = utilityData.getCities();
			for(CityPO city:cities){
				CityVO vo = new CityVO(city.getName(), city.getId(),city.getProvince());
				cityList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(Result.SUCCESS, cityList);
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
