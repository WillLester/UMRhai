package edu.nju.umr.logic.workOrgManLogic;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.logicService.workOrgManLogicSer.DriverManLSer;
import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Sex;
import edu.nju.umr.vo.DriverVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;

public class DriverManLogic implements DriverManLSer{

	public boolean addDriver(DriverVO Driver) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteDriver(String id) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseDriver(DriverVO Driver) {
		// TODO 自动生成的方法存根
		return true;
	}

	public ResultMessage checkDriver(String id) {
		// TODO 自动生成的方法存根
		DriverVO driver = new DriverVO("1","司机1",new Date(1900-01-01),"司机编号1","司机手机号1",Sex.MAN,new Date());
		ResultMessage message = new ResultMessage(true, driver);
		return message;
	}

	public ResultMessage DriverList() {
		// TODO 自动生成的方法存根
		ArrayList<DriverVO> ar = new ArrayList<DriverVO>();
		ar.add(new DriverVO("1","司机1",new Date(1900-01-01),"司机编号1","司机手机号1",Sex.MAN,new Date()));
		ar.add(new DriverVO("2","司机2",new Date(1901-01-01),"司机编号2","司机手机号2",Sex.WOMAN,new Date()));
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

	public ResultMessage searchDriver(String keyword) {
		// TODO 自动生成的方法存根
		ArrayList<DriverVO> ar = new ArrayList<DriverVO>();
		ar.add(new DriverVO("1","司机1",new Date(1900-01-01),"司机编号1","司机手机号1",Sex.MAN,new Date()));
		ar.add(new DriverVO("2","司机2",new Date(1901-01-01),"司机编号2","司机手机号2",Sex.WOMAN,new Date()));
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

}
