package edu.nju.umr.logicService.cityLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.CitiesVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;

public interface CityLSer {
	public Result addCity(CityVO city);
	public Result reviseCity(CityVO city,int index);
	public Result deleteCity(String cityName);
	public Result reviseCities(CitiesVO cities);
	public ResultMessage citiesList();
	public ResultMessage cityList();
}
