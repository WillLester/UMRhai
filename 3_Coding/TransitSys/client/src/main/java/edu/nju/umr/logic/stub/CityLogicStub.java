package edu.nju.umr.logic.stub;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.dataService.cityDSer.CityDSer;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.enums.Result;
public class CityLogicStub implements CityDSer{

	@Override
	public Result addCity(CityPO city) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(city.getId()+" "+city.getKey()+" "+city.getName()+" "+city.getProvince());
		return Result.SUCCESS;
	}

	@Override
	public Result reviseCity(CityPO city) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(city.getId()+" "+city.getKey()+" "+city.getName()+" "+city.getProvince());
		return Result.SUCCESS;
	}

	@Override
	public Result deleteCity(String cityName) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println(cityName);
		return Result.SUCCESS;
	}

	@Override
	public Result addCities(CitiesPO cities) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Add"+cities.getCity1()+" "+cities.getCity2()+" "+cities.getDistance());
		return Result.SUCCESS;
	}

	@Override
	public Result deleteCities(CitiesPO cities) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete"+cities.getCity1()+" "+cities.getCity2()+" "+cities.getDistance());
		return Result.SUCCESS;
	}

	@Override
	public Result reviseCities(CitiesPO cities) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Revise"+cities.getCity1()+" "+cities.getCity2()+" "+cities.getDistance());
		return Result.SUCCESS;
	}

	@Override
	public ArrayList<CitiesPO> getCitiesInfo() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<CitiesPO> cities=new ArrayList<CitiesPO>();
		
		return cities;
	}

	@Override
	public Result isCityUsed(String name, String id) throws RemoteException {
		// TODO Auto-generated method stub
		return Result.SUCCESS;
	}

}
