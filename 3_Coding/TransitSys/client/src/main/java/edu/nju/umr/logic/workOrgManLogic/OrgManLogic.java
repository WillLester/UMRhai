package edu.nju.umr.logic.workOrgManLogic;

import java.util.ArrayList;

import edu.nju.umr.logicService.workOrgManLogicSer.OrgManLSer;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.vo.ResultMessage;

public class OrgManLogic implements OrgManLSer{

	public boolean addOrg(OrgVO org) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteOrg(String id) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseOrg(OrgVO org) {
		// TODO 自动生成的方法存根
		return true;
	}

	public ResultMessage checkOrg(String id) {
		// TODO 自动生成的方法存根
		OrgVO org=new OrgVO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityVO("南京","1"));
		ResultMessage message = new ResultMessage(true, org);
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

	public ResultMessage searchOrg(String keyword) {
		// TODO 自动生成的方法存根
		OrgVO org1=new OrgVO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityVO("南京","1"));
		OrgVO org2=new OrgVO("2","组织2",Organization.HALL,"南京大学鼓楼校区",new CityVO("南京","1"));
		ArrayList<OrgVO> ar=new ArrayList<OrgVO>();
		ar.add(org1);
		ar.add(org2);
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
		ArrayList<CityVO> ar=new ArrayList<CityVO>();
		ar.add(new CityVO("南京","1"));
		ar.add(new CityVO("北京","2"));
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

}
