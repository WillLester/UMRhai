package edu.nju.umr.logic.cityLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.cityDSer.CityDSer;
import edu.nju.umr.dataService.dataFactory.CityDFacSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.cityLogicSer.CityLSer;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.CitiesVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;

public class CityLogic implements CityLSer{
	CityDFacSer dataFac;
	CityDSer cityData;
	UtilityLogic utility;
	ArrayList<CityPO> cityPOs;
	public CityLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (CityDFacSer)Naming.lookup(Url.URL);
			cityData = dataFac.getCity();
			cityPOs=utility.cities();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public Result addCity(CityVO city) {
		// TODO 自动生成的方法存根
		Result result = Result.SUCCESS;
		try {
			result = cityData.addCity(new CityPO(city.getName(), city.getId(),city.getProvince(),0));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return result;
	}
	
    //制定距离和价格常量
	public Result reviseCities(CitiesVO cities) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.SUCCESS;
		try {
			isSuc = cityData.reviseCities(new CitiesPO(cities.getCity1(), cities.getCity2(), cities.getDistance()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return isSuc;
	}

	public Result reviseCity(CityVO city,int index) {
		CityPO po=cityPOs.get(index);
		Result isSuc = Result.SUCCESS;
		try {
			isSuc = cityData.reviseCity(new CityPO(city.getName(), city.getId(),city.getProvince(),po.getKey()));
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return isSuc;
	}

	public ResultMessage cityList() {
		
//		ArrayList<CityVO> cityList = new ArrayList<CityVO>();
//		try {
//			ArrayList<CityPO> cities = cityData.getCities();
//			for(CityPO city:cities){
//				CityVO vo = new CityVO(city.getName(), city.getId(),city.getProvince());
//				cityList.add(vo);
//			}
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		return new ResultMessage(Result.SUCCESS, cityList);
		return utility.getCities();
	}
	public Result deleteCity(String cityName) {
		Result isSuc=null;
		try {
			isSuc=cityData.deleteCity(cityName);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return Result.SUCCESS;
	}

	public ResultMessage citiesList() {
		ArrayList<CitiesPO> city=null;
		try {
			city=cityData.getCitiesInfo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		return new ResultMessage(Result.SUCCESS,city);
	}

}
