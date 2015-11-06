package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.DriverVO;

public interface DriverManLSer {
	public boolean addDriver(DriverVO Driver);
	public boolean deleteDriver(String id);
	public boolean reviseDriver(DriverVO Driver);
	public ResultMessage checkDriver(String id);
	public ResultMessage driverList();
//	public ResultMessage searchDriver(String keyword);
}
