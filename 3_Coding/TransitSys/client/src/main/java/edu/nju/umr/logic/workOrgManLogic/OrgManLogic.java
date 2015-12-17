package edu.nju.umr.logic.workOrgManLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.workOrgManLogicSer.OrgManLSer;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.workOrgManDSer.OrgManDSer;
import edu.nju.umr.dataService.dataFactory.OrgManDFacSer;

public class OrgManLogic implements OrgManLSer{
	private OrgManDFacSer dataFac;
	private OrgManDSer orgData;
	private UtilityLogic uti=new UtilityLogic();
	private DiaryUpdateLSer diarySer;
	public OrgManLogic(){
		try{
			dataFac=(OrgManDFacSer)Naming.lookup(Url.URL);
			orgData=dataFac.getOrgMan();
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
	@SuppressWarnings("unchecked")
	public Result addOrg(OrgVO org,String name) {
		Result isSuccessful=Result.SUCCESS;
		
		ResultMessage message = searchOrg(name);
		if(!message.getReInfo().equals(Result.SUCCESS))return message.getReInfo();
		ArrayList<OrgPO> ar= new ArrayList<OrgPO>();
		ar=(ArrayList<OrgPO>)message.getMessage();
		if(ar.size()>0)return Result.ORG_EXIST;
		
		try{
			isSuccessful=orgData.addOrg(new OrgPO(org.getId(),org.getName(),org.getKind(),org.getLocation(),org.getCity(),org.getCityId()));
			isSuccessful = diarySer.addDiary("新增机构"+org.getId(), name);
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result deleteOrg(String id,String name) {
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			isSuccessful=orgData.deleteOrg(id);
			isSuccessful = diarySer.addDiary("删除机构"+id, name);
		}catch(RemoteException e)
		{
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	@SuppressWarnings("unchecked")
	public Result reviseOrg(OrgVO org,String name) {
		Result isSuccessful=Result.DATA_NOT_FOUND;
		
		ResultMessage message = searchOrg(name);
		if(!message.getReInfo().equals(Result.SUCCESS))return message.getReInfo();
		ArrayList<OrgPO> ar= new ArrayList<OrgPO>();
		ar=(ArrayList<OrgPO>)message.getMessage();
		if(ar.size()>0)return Result.ORG_EXIST;
		
		try{
			isSuccessful=orgData.reviseOrg(new OrgPO(org.getId(),org.getName(),org.getKind(),org.getLocation(),org.getCity(),org.getCityId()));
			isSuccessful = diarySer.addDiary("修改机构"+org.getId(), name);
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage searchOrg(String keyword) {
		// TODO 自动生成的方法存根
		ArrayList<OrgPO> ar= new ArrayList<OrgPO>();
//		boolean isSuccessful=false;
		try{
			ar=orgData.findOrg(keyword);
//			isSuccessful=true;
		}
		catch(RemoteException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		ArrayList<OrgVO> arVO=new ArrayList<OrgVO>();
		for(int i=0;i<ar.size();i++)
		{
			OrgPO org=ar.get(i);
			arVO.add(new OrgVO(org.getId(),org.getName(),org.getKind(),org.getLocation(),org.getCity(),org.getCityId()));
		}
		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
		return message;
	}

	public ResultMessage getCities() {
		// TODO 自动生成的方法存根
		return uti.getCities();
	}

}
