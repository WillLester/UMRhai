package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.DriverVO;
import edu.nju.umr.vo.ResultMessage;

public interface DriverManLSer {
	public Result addDriver(DriverVO Driver);
	public Result deleteDriver(String id);
	public Result reviseDriver(DriverVO Driver);
//	public ResultMessage checkDriver(String id);
//	public ResultMessage driverList();
	public ResultMessage searchDriver(String hallId);
}