package edu.nju.umr.ui.stub;
import java.util.ArrayList;

import edu.nju.umr.logicService.cityLogicSer.CityLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.CitiesVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;
public class CityListPanelStub implements CityLSer{
	ArrayList<CityVO> cityList = new ArrayList<CityVO>();
	ArrayList<CitiesVO> citiesList=new ArrayList<CitiesVO>();
	@Override
	public Result addCity(CityVO city, String name) {
		cityList.add(city);
		for(int i=0;i<cityList.size()-1;i++)
		{
			CityVO p=cityList.get(i);
			CitiesVO pp=new CitiesVO(p.getName(),city.getName(),0);
			citiesList.add(pp);
		}
		return Result.SUCCESS;
	}

	@Override
	public Result reviseCity(CityVO city, int index, String name) {
		// TODO Auto-generated method stub
		CityVO p=cityList.get(index);
		for(int i=0;i<citiesList.size();i++)
		{
			CitiesVO pp=citiesList.get(i);
			if(pp.getCity1().equals(p.getName()))
			{
				citiesList.set(index, new CitiesVO(city.getName(),pp.getCity2(),pp.getDistance()));
			}
			if(pp.getCity2().equals(p.getName()))
			{
				citiesList.set(index, new CitiesVO(pp.getCity1(),city.getName(),pp.getDistance()));
			}
		}
		cityList.set(index, city);
		return Result.SUCCESS;
	}

	@Override
	public Result deleteCity(String cityName, String name) {
		// TODO Auto-generated method stub
		for(CityVO city:cityList){
			if(city.getName().equals(cityName)){
				cityList.remove(city);
				break;
			}
		}
		for(int i=0;i<citiesList.size();i++)
		{
			CitiesVO pp=citiesList.get(i);
			if(pp.getCity1().equals(cityName))
			{
				citiesList.remove(i);
				i--;
			}
			if(pp.getCity2().equals(cityName))
			{
				citiesList.remove(i);
				i--;
			}
		}
		return Result.SUCCESS;
	}

	@Override
	public Result reviseCities(CitiesVO cities, String name) {
		// TODO Auto-generated method stub
		return Result.SUCCESS;
	}

	@Override
	public ResultMessage citiesList() {
		// TODO Auto-generated method stub
		return new ResultMessage(Result.SUCCESS,citiesList);
	}

	@Override
	public ResultMessage cityList() {
		// TODO Auto-generated method stub
		return new ResultMessage(Result.SUCCESS,cityList);
	}

}
