package edu.nju.umr.logic.workOrgManLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.WorkManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.WorkManDSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.workOrgManLogicSer.WorkManLSer;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Wage;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WorkVO;

public class WorkManLogic implements WorkManLSer{
	private WorkManDFacSer dataFac;
	private WorkManDSer workData;
	private UtilityLogic uti=new UtilityLogic();
	private ArrayList<WorkPO> ar;
	public WorkManLogic()
	{
		try{
			dataFac=(WorkManDFacSer)Naming.lookup(Url.URL);
			workData=dataFac.getWorkMan();
			uti=new UtilityLogic();
		}catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } catch(Exception e){
			e.printStackTrace();
		}
	}

	public Result addWork(WorkVO work) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		
		try{
			String orgId=getOrgId(work.getOrg());
			isSuccessful=workData.addWork(VPFactory.toWorkPO(work,orgId,0,Wage.MONTH,0,0));
		}catch (RemoteException e) {
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result deleteWork(int id) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			isSuccessful=workData.deleteWork(id);
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result reviseWork(WorkVO work, int index) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		WorkPO po=ar.get(index);
		try{
			String orgId=getOrgId(work.getOrg());
			isSuccessful=workData.reviseWork(VPFactory.toWorkPO(work, orgId,po.getId(),po.getKind(),po.getMoney(),po.getCommission()));
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}
	
	private String getOrgId(String orgName){
		ArrayList<OrgPO> orgs=new ArrayList<OrgPO>();
		try {
			orgs=uti.orgs();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		
		for(OrgPO po:orgs){
			if(po.getName()==orgName)
				return po.getId();
		}
		return null;
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
		ar= new ArrayList<WorkPO>();
//		boolean isSuccessful=false;
		try{
			ar=workData.findWork(keyword);
//			isSuccessful=true;
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		ArrayList<WorkVO> arVO=new ArrayList<WorkVO>();
		for(int i=0;i<ar.size();i++)
		{
			WorkPO work=ar.get(i);
//			arVO.add(new WorkVO(work.getName(),work.getMobile(),work.getOrg(),work.getJuri()));
			arVO.add(VPFactory.toWorkVO(work));
		}
		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
		return message;
	}

	public ResultMessage orgList() {
		// TODO 自动生成的方法存根
//		ArrayList<OrgPO> ar= null;
//		boolean isSuccessful=false;
//		try{
//			ar=workData.getOrgs();
//			isSuccessful=true;
//		}
//		catch(RemoteException e){
//			e.printStackTrace();
//		}
//		ArrayList<OrgVO> arVO=new ArrayList<OrgVO>();
//		for(int i=0;i<ar.size();i++)
//		{
//			OrgPO org=ar.get(i);
//			arVO.add(new OrgVO(org.getId(),org.getName(),org.getKind(),org.getLocation(),new CityVO(org.getCity().getId(),org.getCity().getName(),org.getCity().getProvince())));
//		}
//		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
//		return message;
		return uti.getOrgs();
	}

}
