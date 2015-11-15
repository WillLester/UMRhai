package edu.nju.umr.logic.cityLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.dataService.cityDSer.CityDSer;
import edu.nju.umr.dataService.dataFactory.CityDFacSer;
import edu.nju.umr.logicService.cityLogicSer.CityLSer;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.url.Url;
import edu.nju.umr.vo.CitiesVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;

public class CityLogic implements CityLSer{
	CityDFacSer dataFac;
	CityDSer cityData;
	public CityLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (CityDFacSer)Naming.lookup(Url.URL);
			cityData = dataFac.getCity();
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
			result = cityData.addCity(new CityPO(city.getName(), city.getId(),null));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return result;
	}

	public Result reviseCities(CitiesVO cities) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.SUCCESS;
		try {
			isSuc = cityData.reviseCities(new CitiesPO(cities.getCity1(), cities.getCity2(), cities.getDistance(), cities.getPrice()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return isSuc;
	}

	public Result reviseCity(CityVO city) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.SUCCESS;
		try {
			isSuc = cityData.reviseCity(new CityPO(city.getName(), city.getId(),city.getProvince()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return isSuc;
	}

	public ResultMessage cityList() {
		// TODO 自动生成的方法存根
		ArrayList<CityVO> cityList = new ArrayList<CityVO>();
		try {
			ArrayList<CityPO> cities = cityData.getCities();
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
	public Result deleteCity(String cityName) {
		// TODO 自动生成的方法存根
		return Result.SUCCESS;
	}

}
