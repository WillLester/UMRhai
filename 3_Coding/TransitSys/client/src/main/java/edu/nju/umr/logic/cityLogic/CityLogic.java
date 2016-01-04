package edu.nju.umr.logic.cityLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.cityDSer.CityDSer;
import edu.nju.umr.dataService.dataFactory.CityDFacSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.cityLogicSer.CityLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.CitiesVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;

public class CityLogic implements CityLSer{
	private CityDFacSer dataFac;
	private CityDSer cityData;
	private UtilityLogic utility=new UtilityLogic();
	private ArrayList<CityPO> cityPOs;
	private ArrayList<CitiesPO> citiesPOs;
	private DiaryUpdateLSer diarySer;
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
		diarySer = new DiaryUpdateLogic();
	}
	public Result addCity(CityVO city,String name) {
		// TODO 自动生成的方法存根
		ArrayList<CityPO> citypo=new ArrayList<CityPO>();
		Result resultCity = Result.SUCCESS;
		Result resultCities = Result.SUCCESS;
		try {
			citypo=utility.cities();
		} catch (RemoteException e) {
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		try {
			if(cityData.isCityUsed(city.getName(), city.getId(),-1).equals(Result.SUCCESS))
			{
				resultCity = cityData.addCity(VPFactory.toCityPO(city, 0));
				resultCity = diarySer.addDiary("新增城市"+city.getName(), name);
			}
			else
			{
				return cityData.isCityUsed(city.getName(), city.getId(),-1);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		if(citypo.size()>0){
			for(CityPO po:citypo){
				CitiesPO cities=new CitiesPO(city.getName(),po.getName(),0);
			    try {
					resultCities=cityData.addCities(cities);
				} catch (RemoteException e) {
					e.printStackTrace();
					return Result.NET_INTERRUPT;
				}
			}
		}
		if(resultCity==Result.SUCCESS&&resultCities==Result.SUCCESS){
		    return Result.SUCCESS;
		}else{
			return Result.DATABASE_ERROR;
		}
	}
	
    //制定距离和价格常量
	public Result reviseCities(CitiesVO cities,String name) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.SUCCESS;
		try {
			isSuc = cityData.reviseCities(VPFactory.toCitiesPO(cities));
			isSuc = diarySer.addDiary("修改"+cities.getCity1()+"和"+cities.getCity2()+"间信息", name);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return isSuc;
	}

	public Result reviseCity(CityVO city,int index,String name) {
		CityPO po=cityPOs.get(index);
		Result isSuc = Result.SUCCESS;
		try {
			if(cityData.isCityUsed(city.getName(), city.getId(),po.getKey()).equals(Result.SUCCESS))
			{
				isSuc = cityData.reviseCity(VPFactory.toCityPO(city, po.getKey()));
				isSuc = diarySer.addDiary("修改了"+city.getName()+"的信息", name);
			}
			else
			{
				return cityData.isCityUsed(city.getName(), city.getId(),po.getKey());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		// 如果修改了城市名，则相应的城市间信息需要更新
		if(isSuc.equals(Result.SUCCESS)){
			if(!city.getName().equals(po.getName())){
				for(CitiesPO cities:citiesPOs){
					if(cities.getCity1().equals(po.getName())){//城市1是被修改的城市
						try {
							isSuc = cityData.reviseCities(new CitiesPO(city.getName(), cities.getCity2(), cities.getDistance()));
						} catch (RemoteException e) {
							// TODO 自动生成的 catch 块
							return Result.NET_INTERRUPT;
						}
					} else if(cities.getCity2().equals(po.getName())){//城市2是被修改的城市
						try {
							isSuc = cityData.reviseCities(new CitiesPO(cities.getCity1(), city.getName(), cities.getDistance()));
						} catch (RemoteException e) {
							// TODO 自动生成的 catch 块
							return Result.NET_INTERRUPT;
						}
					}
					if(!isSuc.equals(Result.SUCCESS)){
						return isSuc;
					}
				}
			}
		}
		return isSuc;
	}

	public ResultMessage cityList() {
		try {
			cityPOs = utility.cities();
			return utility.getCities();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}
	}
	public Result deleteCity(String cityName,String name) {
		Result isSuc = Result.DATA_NOT_FOUND;
		try {
			isSuc=cityData.deleteCity(cityName);
			isSuc = diarySer.addDiary("删除城市"+cityName, name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		if(isSuc.equals(Result.SUCCESS)){
			for(CitiesPO cities:citiesPOs){
				if((cities.getCity1().equals(cityName))||(cities.getCity2().equals(cityName))){
					try {
						cityData.deleteCities(cities);
					} catch (RemoteException e) {
						// TODO 自动生成的 catch 块
						return Result.NET_INTERRUPT;
					}
				}
			}
		} 
		return isSuc;
	}

	public ResultMessage citiesList() {
		citiesPOs=null;
		try {
			citiesPOs=cityData.getCitiesInfo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		ArrayList<CitiesVO> citiesVO=new ArrayList<CitiesVO>();
		for(CitiesPO po:citiesPOs)
		{
			citiesVO.add(VPFactory.toCitiesVO(po));
		}
		return new ResultMessage(Result.SUCCESS,citiesVO);
	}

}
