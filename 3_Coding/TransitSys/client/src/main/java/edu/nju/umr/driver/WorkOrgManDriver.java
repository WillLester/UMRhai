package edu.nju.umr.driver;

import java.util.ArrayList;

import edu.nju.umr.logicService.workOrgManLogicSer.*;
import edu.nju.umr.logic.workOrgManLogic.*;
import edu.nju.umr.vo.WorkVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.po.enums.Jurisdiction;

public class WorkOrgManDriver {
	private WorkManLSer work=new WorkManLogic();
	private OrgManLSer Org=new OrgManLogic();
	public static void main(String[] args)
	{
		WorkOrgManDriver driver=new WorkOrgManDriver();
		System.out.println(driver.work.addWork(new WorkVO("Worker1","11111111111","1","1",Jurisdiction.ADMIN)));
		System.out.println(driver.work.deleteWork("1"));
		System.out.println(driver.work.reviseWork(new WorkVO("Worker1","11111111111","1","1",Jurisdiction.ADMIN)));
		WorkVO workVO=(WorkVO)driver.work.checkWork("1").getMessage();
		System.out.println(workVO.getName());
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

}
