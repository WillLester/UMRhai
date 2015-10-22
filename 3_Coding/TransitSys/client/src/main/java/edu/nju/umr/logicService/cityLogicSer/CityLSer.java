package edu.nju.umr.logicService.cityLogicSer;

import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.CitiesVO;

public interface CityLSer {
	public boolean addCity(CityVO city);
	public boolean reviseCities(CitiesVO cities);
}
