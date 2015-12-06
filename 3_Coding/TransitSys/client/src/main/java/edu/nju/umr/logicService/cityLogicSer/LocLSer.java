package edu.nju.umr.logicService.cityLogicSer;

import edu.nju.umr.vo.ResultMessage;
/**
 * 地址Panel所需要的逻辑层接口
 * @author Lester
 * 
 */
public interface LocLSer {
	public ResultMessage getCities();//需要City名称和所属省份，可以新建一个VO
}
