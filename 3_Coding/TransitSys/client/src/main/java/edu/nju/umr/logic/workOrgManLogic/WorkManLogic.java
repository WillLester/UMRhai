package edu.nju.umr.logic.workOrgManLogic;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.logicService.workOrgManLogicSer.WorkManLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.po.enums.Sex;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WorkVO;

public class WorkManLogic implements WorkManLSer{

	public boolean addWork(WorkVO Work) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteWork(String id) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseWork(WorkVO Work) {
		// TODO 自动生成的方法存根
		return true;
	}

	public ResultMessage checkWork(String id) {
		// TODO 自动生成的方法存根
		WorkVO worker = new WorkVO("Worker1","11111111111","1","1",Jurisdiction.ADMIN);
		ResultMessage message = new ResultMessage(true, worker);
		return message;
	}

	public ResultMessage WorkList() {
		// TODO 自动生成的方法存根
		ArrayList<WorkVO> ar=new ArrayList<WorkVO>();
		ar.add(new WorkVO("Worker1","11111111111","1","1",Jurisdiction.ADMIN));
		ar.add(new WorkVO("Worker2","22222222222","2","2",Jurisdiction.COURIER));
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

	public ResultMessage searchWork(String keyword) {
		// TODO 自动生成的方法存根
		ArrayList<WorkVO> ar=new ArrayList<WorkVO>();
		ar.add(new WorkVO("Worker1","11111111111","1","1",Jurisdiction.ADMIN));
		ar.add(new WorkVO("Worker2","22222222222","2","2",Jurisdiction.COURIER));
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

	public ResultMessage orgList() {
		// TODO 自动生成的方法存根
		OrgVO org1=new OrgVO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityVO("南京","1"));
		OrgVO org2=new OrgVO("2","组织2",Organization.HALL,"南京大学鼓楼校区",new CityVO("南京","1"));
		ArrayList<OrgVO> ar=new ArrayList<OrgVO>();
		ar.add(org1);
		ar.add(org2);
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

}
