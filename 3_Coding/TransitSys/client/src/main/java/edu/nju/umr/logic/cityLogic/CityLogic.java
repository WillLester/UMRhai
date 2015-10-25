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
import edu.nju.umr.vo.CitiesVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;

public class CityLogic implements CityLSer{
	CityDFacSer dataFac;
	CityDSer cityData;
	public CityLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (CityDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			cityData = dataFac.getCity();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public boolean addCity(CityVO city) {
		// TODO 自动生成的方法存根
		boolean isSuc = false;
		try {
			isSuc = cityData.add(new CityPO(city.getName(), city.getId()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return isSuc;
	}

	public boolean reviseCities(CitiesVO cities) {
		// TODO 自动生成的方法存根
		boolean isSuc = false;
		try {
			isSuc = cityData.reviseCities(new CitiesPO(cities.getCity1(), cities.getCity2(), cities.getDistance(), cities.getPrice()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return isSuc;
	}

	public boolean reviseCity(CityVO city) {
		// TODO 自动生成的方法存根
		boolean isSuc = false;
		try {
			isSuc = cityData.revise(new CityPO(city.getName(), city.getId()));
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
				CityVO vo = new CityVO(city.getName(), city.getId());
				cityList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(true, cityList);
	}

}
