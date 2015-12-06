package edu.nju.umr.logicService.cityLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.CitiesVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;
/**
 * 
 * @author WillLester
 * 
 */
public interface CityLSer {
	public Result addCity(CityVO city);
	/**
	 * 
	 * @param city 城市VO
	 * @param index 在城市表格中的row号
	 * @return 修改的结果
	 */
	public Result reviseCity(CityVO city,int index);
	public Result deleteCity(String cityName);
	public Result reviseCities(CitiesVO cities);
	public ResultMessage citiesList();
	public ResultMessage cityList();
}
