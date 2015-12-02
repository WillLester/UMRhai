package edu.nju.umr.logic.workOrgManLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.workOrgManLogicSer.WorkManLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Wage;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WorkVO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.WorkManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.WorkManDSer;

public class WorkManLogic implements WorkManLSer{
	WorkManDFacSer dataFac;
	WorkManDSer workData;
	UtilityLogic uti=new UtilityLogic();
	ArrayList<WorkPO> ar;
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
			isSuccessful=workData.addWork(new WorkPO(work.getName(),work.getMobile(),work.getOrg(),work.getOrgId(),1,work.getJuri(),Wage.COMMISSION,0,0));
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
			isSuccessful=workData.reviseWork(VPFactory.toWorkPO(work, po.getId()));
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(Exception e){
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
			arVO.add(new WorkVO(work.getName(),work.getMobile(),work.getOrg(),work.getOrgId(),work.getJuri()));
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
