package edu.nju.umr.logic.workOrgManLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
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
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.dataService.dataFactory.WorkManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.WorkManDSer;

public class WorkManLogic implements WorkManLSer{
	WorkManDFacSer dataFac;
	WorkManDSer workData;
	public WorkManLogic()
	{
		try{
			dataFac=(WorkManDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			workData=dataFac.getWorkMan();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean addWork(WorkVO work) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try{
			isSuccessful=workData.addWork(new WorkPO(work.getName(),work.getMobile(),work.getOrgId(),work.getId(),work.getJuri()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public boolean deleteWork(String id) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try{
			isSuccessful=workData.deleteWork(id);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public boolean reviseWork(WorkVO work) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try{
			isSuccessful=workData.reviseWork(new WorkPO(work.getName(),work.getMobile(),work.getOrgId(),work.getId(),work.getJuri()));
		}catch(RemoteException e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

//	public ResultMessage checkWork(String id) {
//		// TODO 自动生成的方法存根
//		WorkPO Work=null;
//		boolean isSuccessful=false;
//		try{
//			Work=workData.checkWork(id);
//			isSuccessful=true;
//		}catch(RemoteException e)
//		{
//			e.printStackTrace();
//		}
//		ResultMessage message=new ResultMessage(isSuccessful,new WorkVO(Work.getName(),Work.getMobile(),Work.getOrgId(),Work.getId(),Work.getJuri()));
//		return null;
//	}

//	public ResultMessage WorkList() {
//		// TODO 自动生成的方法存根
//		ArrayList<WorkPO> ar= null;
//		boolean isSuccessful=false;
//		try{
//			ar=workData.findWork("");
//			isSuccessful=true;
//		}
//		catch(RemoteException e){
//			e.printStackTrace();
//		}
//		ArrayList<WorkVO> arVO=new ArrayList<WorkVO>();
//		for(int i=0;i<ar.size();i++)
//		{
//			WorkPO Work=ar.get(i);
//			arVO.add(new WorkVO(Work.getName(),Work.getMobile(),Work.getOrgId(),Work.getId(),Work.getJuri()));
//		}
//		ResultMessage message = new ResultMessage(isSuccessful, arVO);
//		return message;
//	}

	public ResultMessage searchWork(String keyword) {
		// TODO 自动生成的方法存根
		ArrayList<WorkPO> ar= null;
		boolean isSuccessful=false;
		try{
			ar=workData.findWork("");
			isSuccessful=true;
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		ArrayList<WorkVO> arVO=new ArrayList<WorkVO>();
		for(int i=0;i<ar.size();i++)
		{
			WorkPO Work=ar.get(i);
			arVO.add(new WorkVO(Work.getName(),Work.getMobile(),Work.getOrgId(),Work.getId(),Work.getJuri()));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}

	public ResultMessage orgList() {
		// TODO 自动生成的方法存根
		ArrayList<OrgPO> ar= null;
		boolean isSuccessful=false;
		try{
			ar=workData.getOrgs();
			isSuccessful=true;
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		ArrayList<OrgVO> arVO=new ArrayList<OrgVO>();
		for(int i=0;i<ar.size();i++)
		{
			OrgPO Org=ar.get(i);
			arVO.add(new OrgVO(Org.getId(),Org.getName(),Org.getKind(),Org.getLocation(),new CityVO(Org.getCity().getId(),Org.getCity().getName())));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}

}
