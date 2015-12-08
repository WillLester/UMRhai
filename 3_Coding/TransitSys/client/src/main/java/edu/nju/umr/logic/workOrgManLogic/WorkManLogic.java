package edu.nju.umr.logic.workOrgManLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.WorkManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.WorkManDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.workOrgManLogicSer.WorkManLSer;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Wage;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WorkVO;

public class WorkManLogic implements WorkManLSer{
	private WorkManDFacSer dataFac;
	private WorkManDSer workData;
	private UtilityLogic uti=new UtilityLogic();
	private ArrayList<WorkPO> workList;
	private DiaryUpdateLSer diarySer;
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
		diarySer = new DiaryUpdateLogic();
	}

	@Override
	public Result addWork(WorkVO work,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		
		try{
			String orgId=getOrgId(work.getOrg());
			isSuccessful=workData.addWork(VPFactory.toWorkPO(work,orgId,0,Wage.MONTH,0,0));
			isSuccessful = diarySer.addDiary("新增人员"+work.getName(), name);
		}catch (RemoteException e) {
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	@Override
	public Result deleteWork(int index,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			WorkPO po = workList.get(index);
			isSuccessful=workData.deleteWork(po.getId());
			isSuccessful = diarySer.addDiary("删除人员"+po.getName(), name);
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result reviseWork(WorkVO work, int index,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		WorkPO po=workList.get(index);
		try{
			String orgId=getOrgId(work.getOrg());
			isSuccessful=workData.reviseWork(VPFactory.toWorkPO(work, orgId,po.getId(),po.getKind(),po.getMoney(),po.getCommission()));
			isSuccessful = diarySer.addDiary("修改人员"+work.getName(), name);
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
			if(po.getName().equals(orgName))
				return po.getId();
		}
		return null;
	}

	public ResultMessage searchWork(String keyword) {
		// TODO 自动生成的方法存根
		workList= new ArrayList<WorkPO>();
		try{
			workList=workData.findWork(keyword);
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		ArrayList<WorkVO> arVO=new ArrayList<WorkVO>();
		for(int i=0;i<workList.size();i++)
		{
			WorkPO work = workList.get(i);
			arVO.add(VPFactory.toWorkVO(work));
		}
		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
		return message;
	}

	public ResultMessage orgList() {
		// TODO 自动生成的方法存根\
		ResultMessage message = uti.getOrgs();
		if(message.getReInfo().equals(Result.SUCCESS)){
			@SuppressWarnings("unchecked")
			ArrayList<OrgVO> orgList = (ArrayList<OrgVO>) message.getMessage();
			String[] orgs = new String[orgList.size()];
			for(int i =0;i < orgs.length;i++){
				orgs[i] = orgList.get(i).getName();
			}
			return new ResultMessage(Result.SUCCESS, orgs);
		} else {
			return new ResultMessage(message.getReInfo(), null);
		}
	}

}
