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
	/**
	 * 新增城市
	 * @param city 城市VO
	 * @param name 操作者姓名
	 * @see edu.nju.umr.vo.CityVO
	 * @return 结果
	 */
	public Result addCity(CityVO city,String name);
	/**
	 * 修改城市信息
	 * @param city 城市VO
	 * @param index 在城市表格中的row号
	 * @param name 操作者姓名
	 * @see edu.nju.umr.vo.CityVO
	 * @return 修改的结果
	 */
	public Result reviseCity(CityVO city,int index,String name);
	/**
	 * 删除城市
	 * @param cityName 城市名
	 * @param name 操作者姓名
	 * @return 删除的结果
	 */
	public Result deleteCity(String cityName,String name);
	/**
	 * 修改城市间信息
	 * @param cities 城市间VO
	 * @param name 操作者姓名
	 * @see edu.nju.umr.vo.CitiesVO
	 * @return
	 */
	public Result reviseCities(CitiesVO cities,String name);
	public ResultMessage citiesList();
	public ResultMessage cityList();
}
