package edu.nju.umr.logicService.cityLogicSer;

import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.CitiesVO;
import edu.nju.umr.vo.ResultMessage;

public interface CityLSer {
	public boolean addCity(CityVO city);
	public boolean reviseCity(CityVO city);
	public boolean reviseCities(CitiesVO cities);
	public ResultMessage cityList();
}
