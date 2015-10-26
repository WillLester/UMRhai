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
	private OrgManLSer Org=new OrgManLogic();
	//private VanManLSer van=new VanManLogic();
	//private DriverManLSer drive=new DriverManLogic();
	private WageManLSer wage=new WageManLogic();
	public static void main(String[] args)
	{
	  driverWork();
	  driverOrg();
	  //driverVan();
      //driverDriver();
	  driverWage();
	}
	public static void driverWork(){
		WorkOrgManDriver driver=new WorkOrgManDriver();
		System.out.println(driver.work.addWork(new WorkVO("Worker1","11111111111","1","1",Jurisdiction.ADMIN)));
		System.out.println(driver.work.deleteWork("1"));
		System.out.println(driver.work.reviseWork(new WorkVO("Worker1","11111111111","1","1",Jurisdiction.ADMIN)));
		WorkVO workVO=(WorkVO)driver.work.checkWork("1").getMessage();
		System.out.println(workVO.getName());
		@SuppressWarnings("unchecked")
		ArrayList<WorkVO> ar=(ArrayList<WorkVO>)driver.work.WorkList().getMessage();
		for(int i=0;i<ar.size();i++)
		{
			WorkVO work=ar.get(i);
			System.out.println(work.getName());
		}
		ArrayList<OrgVO> or=(ArrayList<OrgVO>)driver.work.orgList().getMessage();
		for(int i=0;i<ar.size();i++)
		{
			OrgVO Org=or.get(i);
			System.out.println(Org.getName());
		}
	}
	public static void driverOrg(){
		WorkOrgManDriver driver=new WorkOrgManDriver();
		System.out.println(driver.Org.addOrg(new OrgVO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityVO("南京","1"))));
		System.out.println(driver.Org.deleteOrg("1"));
		System.out.println(driver.Org.reviseOrg(new OrgVO("1","组织1",Organization.CENTER,"南京大学仙林校区",new CityVO("南京","1"))));
		OrgVO org=(OrgVO)driver.Org.checkOrg("1").getMessage();
		System.out.println(org.getId()+" "+org.getName()+" "+org.getKind()+" "+org.getLocation()+" "+org.getCity().getName()+" "+org.getCity().getId());
		ArrayList<OrgVO> ar=null;
		ar=(ArrayList<OrgVO>)driver.Org.orgList().getMessage();
		for(int i=0;i<ar.size();i++)
		{
			org=ar.get(i);
			System.out.println(org.getId()+" "+org.getName()+" "+org.getKind()+" "+org.getLocation()+" "+org.getCity().getName()+" "+org.getCity().getId());
		}
		
		ar=(ArrayList<OrgVO>)driver.Org.searchOrg("").getMessage();
		for(int i=0;i<ar.size();i++)
		{
			org=ar.get(i);
			System.out.println(org.getId()+" "+org.getName()+" "+org.getKind()+" "+org.getLocation()+" "+org.getCity().getName()+" "+org.getCity().getId());
		}
		
		ArrayList<CityVO> ar2=null;
		ar2=(ArrayList<CityVO>)driver.Org.getCities().getMessage();
		for(int i=0;i<ar2.size();i++)
		{
			CityVO city=ar2.get(i);
			System.out.println(city.getName()+" "+city.getId());
		}
		
	}
	public static void driverVan(){}
	public static void driverDriver(){}
	public static void driverWage(){
		WorkOrgManDriver driver=new WorkOrgManDriver();
		ArrayList<WorkVO> ar=null;
		ar=(ArrayList<WorkVO>)driver.wage.WorkList().getMessage();
		for(int i=0;i<ar.size();i++)
		{
			WorkVO work=ar.get(i);
			System.out.println(work.getId()+" "+work.getMobile()+" "+work.getName()+" "+work.getOrgId()+" "+work.getJuri());
		}
		System.out.println(driver.wage.reviseWage(new WageVO("1",Wage.MONTH,5,5)));
		WageVO wage=(WageVO)driver.wage.getWage("1").getMessage();
		System.out.println(wage.getWorkerId()+" "+wage.getKind()+" "+wage.getMoney()+" "+wage.getCommission());
		
	}
	

}
