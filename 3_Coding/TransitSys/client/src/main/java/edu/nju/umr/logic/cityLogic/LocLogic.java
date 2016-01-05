package edu.nju.umr.logic.cityLogic;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.cityLogicSer.LocLSer;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.LocVO;
import edu.nju.umr.vo.ResultMessage;
/*
 * 地址Panel的逻辑，需要获得城市列表
 */
public class LocLogic implements LocLSer{
	public ResultMessage getCities(){
		Result isSuc=Result.DATA_NOT_FOUND;
		ArrayList<CityPO> cityList=new ArrayList<CityPO>();
		ArrayList<LocVO> cities=new ArrayList<LocVO>();
		try {
			UtilityLogic uti=new UtilityLogic();
			cityList=uti.cities();
			if(cityList.size() > 0){
				isSuc=Result.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		for(CityPO city:cityList){
			LocVO loc = VPFactory.toLocVO(city);
			cities.add(loc);
		}
		return new ResultMessage(isSuc,cities);
		
	}
}
