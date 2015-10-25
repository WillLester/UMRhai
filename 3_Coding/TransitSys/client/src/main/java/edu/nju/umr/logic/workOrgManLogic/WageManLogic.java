package edu.nju.umr.logic.workOrgManLogic;

import java.util.ArrayList;

import edu.nju.umr.logicService.workOrgManLogicSer.WageManLSer;
import edu.nju.umr.po.WagePO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Wage;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WageVO;
import edu.nju.umr.vo.WorkVO;

public class WageManLogic implements WageManLSer{

	public ResultMessage WorkList() {
		// TODO 自动生成的方法存根
		ArrayList<WorkVO> ar=new ArrayList<WorkVO>();
		ar.add(new WorkVO("Worker1","11111111111","1","1",Jurisdiction.ADMIN));
		ar.add(new WorkVO("Worker2","22222222222","2","2",Jurisdiction.COURIER));
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

	public boolean reviseWage(ArrayList<WageVO> wage) {
		// TODO 自动生成的方法存根
		return true;
	}

	public ResultMessage getWage(String id) {
		// TODO 自动生成的方法存根
		ResultMessage message = new ResultMessage(true, new WagePO("WorkerID1",Wage.MONTH,5,5));
		return message;
	}

}
