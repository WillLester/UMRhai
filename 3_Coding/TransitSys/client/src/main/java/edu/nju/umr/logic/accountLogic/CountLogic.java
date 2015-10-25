package edu.nju.umr.logic.accountLogic;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.logicService.accountLogicSer.CountLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.CountVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.VanVO;
import edu.nju.umr.vo.WorkVO;

public class CountLogic implements CountLSer{

	public boolean newCount(CountVO count) {
		// TODO 自动生成的方法存根
		return true;
	}

	public ResultMessage checkInitInfo() {
		// TODO 自动生成的方法存根
		return null;
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

	public ResultMessage getWorkers(String id) {
		// TODO 自动生成的方法存根
		ArrayList<WorkVO> ar=new ArrayList<WorkVO>();
		ar.add(new WorkVO("Worker1","11111111111","1","1",Jurisdiction.ADMIN));
		ar.add(new WorkVO("Worker2","22222222222","2","2",Jurisdiction.COURIER));
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

	public ResultMessage getVans(String id) {
		// TODO 自动生成的方法存根
		VanVO van1=new VanVO("1","11111",new Date(),null,"1");
		VanVO van2=new VanVO("2","22222",new Date(),null,"2");
		ArrayList<VanVO> ar=new ArrayList<VanVO>();
		ar.add(van1);
		ar.add(van2);
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

	public ResultMessage getStock(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage getAccount(String id) {
		// TODO 自动生成的方法存根
		AccountVO account1 = new AccountVO("12345", "Excited", 25000);
		AccountVO account2 = new AccountVO("54321", "亦可赛艇", 8964);
		ArrayList<AccountVO> ar=new ArrayList<AccountVO>();
		ar.add(account1);
		ar.add(account2);
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

}
