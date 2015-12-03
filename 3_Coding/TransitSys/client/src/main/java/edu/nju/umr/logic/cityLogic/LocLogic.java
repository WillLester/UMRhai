package edu.nju.umr.logic.cityLogic;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.cityLogicSer.LocLSer;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
/*
 * 地址Panel的逻辑，需要获得城市列表
 */
public class LocLogic implements LocLSer{
	UtilityLogic uti=new UtilityLogic();
	public ResultMessage getCities(){
		Result isSuc=Result.DATA_NOT_FOUND;
		ArrayList<CityPO> cityList=new ArrayList<CityPO>();
		ArrayList<String> cities=new ArrayList<String>();
		try {
			cityList=uti.cities();
			if(cityList.size()>0){
				isSuc=Result.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		for(CityPO city:cityList){
			cities.add(city.getName());
		}
		return new ResultMessage(isSuc,cities);
		
	}
}
