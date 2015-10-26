package edu.nju.umr.driver;

import java.util.ArrayList;

import edu.nju.umr.logicService.workOrgManLogicSer.*;
import edu.nju.umr.logic.workOrgManLogic.*;
import edu.nju.umr.vo.WorkVO;
import edu.nju.umr.vo.WageVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.po.enums.Wage;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Organization;

public class WorkOrgManDriver {
	private WorkManLSer work=new WorkManLogic();
	private OrgManLSer org=new OrgManLogic();
	private VanManLSer van =new VanManLogic();
	private DriverManLSer drive=new DriverManLogic();
	private WageManLSer wage=new WageManLogic();
	public static void main(String[] args){
		WorkOrgManDriver driver = new WorkOrgManDriver();
		driver.driverWork();
		driver.driverOrg();
		driver.driverVan();
		driver.driverDriver();
		driver.driverWage();
	}
	private void driverWork(){
		System.out.println(work.addWork(new WorkVO("Worker1","11111111111","1","1",Jurisdiction.ADMIN)));
		System.out.println(work.deleteWork("1"));
		System.out.println(work.reviseWork(new WorkVO("Worker1","11111111111","1","1",Jurisdiction.ADMIN)));
		WorkVO workVO=(WorkVO)work.checkWork("1").getMessage();
		System.out.println(workVO.getName());
		@SuppressWarnings("unchecked")
		ArrayList<WorkVO> ar=(ArrayList<WorkVO>)work.WorkList().getMessage();
		for(int i=0;i<ar.size();i++)
		{
			WorkVO work=ar.get(i);
			System.out.println(work.getName());
		}
		ArrayList<OrgVO> or=(ArrayList<OrgVO>)work.orgList().getMessage();
		for(int i=0;i<ar.size();i++)
		{
			OrgVO Org=or.get(i);
			System.out.println(Org.getName());
		}
	}
	private void driverOrg(){
		System.out.println(org.addOrg(new OrgVO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityVO("南京","1"))));
		System.out.println(org.deleteOrg("1"));
		System.out.println(org.reviseOrg(new OrgVO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityVO("南京","1"))));
		OrgVO org=(OrgVO)this.org.checkOrg("1").getMessage();
		System.out.println(org.getId()+" "+org.getName()+" "+org.getKind()+" "+org.getLocation()+" "+org.getCity().getName()+" "+org.getCity().getId());
		ArrayList<OrgVO> ar=null;
		ar=(ArrayList<OrgVO>)this.org.orgList().getMessage();
		for(int i=0;i<ar.size();i++)
		{
			org=ar.get(i);
			System.out.println(org.getId()+" "+org.getName()+" "+org.getKind()+" "+org.getLocation()+" "+org.getCity().getName()+" "+org.getCity().getId());
		}
		
		ar=(ArrayList<OrgVO>)this.org.searchOrg("").getMessage();
		for(int i=0;i<ar.size();i++)
		{
			org=ar.get(i);
			System.out.println(org.getId()+" "+org.getName()+" "+org.getKind()+" "+org.getLocation()+" "+org.getCity().getName()+" "+org.getCity().getId());
		}
		
		ArrayList<CityVO> ar2=null;
		ar2=(ArrayList<CityVO>)this.org.getCities().getMessage();
		for(int i=0;i<ar2.size();i++)
		{
			CityVO city=ar2.get(i);
			System.out.println(city.getName()+" "+city.getId());
		}
		
	}
	private void driverVan(){
		
	}
	private void driverDriver(){
		
	}
	private void driverWage(){
		ArrayList<WorkVO> ar=null;
		ar=(ArrayList<WorkVO>)wage.WorkList().getMessage();
		for(int i=0;i<ar.size();i++)
		{
			WorkVO work=ar.get(i);
			System.out.println(work.getId()+" "+work.getMobile()+" "+work.getName()+" "+work.getOrgId()+" "+work.getJuri());
		}
		System.out.println(wage.reviseWage(new WageVO("1",Wage.MONTH,5,5)));
		WageVO wage=(WageVO)this.wage.getWage("1").getMessage();
		System.out.println(wage.getWorkerId()+" "+wage.getKind()+" "+wage.getMoney()+" "+wage.getCommission());
		
	}
	

}
