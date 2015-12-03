package edu.nju.umr.logic.workOrgManLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
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
	}
	public Result addOrg(OrgVO org) {
		Result isSuccessful=Result.SUCCESS;
		try{
			isSuccessful=orgData.addOrg(new OrgPO(org.getId(),org.getName(),org.getKind(),org.getLocation(),org.getCity(),org.getCityId()));
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result deleteOrg(String id) {
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			isSuccessful=orgData.deleteOrg(id);
		}catch(RemoteException e)
		{
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result reviseOrg(OrgVO org) {
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			isSuccessful=orgData.reviseOrg(new OrgPO(org.getId(),org.getName(),org.getKind(),org.getLocation(),org.getCity(),org.getCityId()));
		}catch(RemoteException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

//	public ResultMessage checkOrg(String id) {
//		boolean isSuccessful=false;
//		OrgPO orgPO=null;
//		try{
//			orgPO=orgData.checkOrg(id);
//			isSuccessful=true;
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		OrgVO orgVO=new OrgVO(orgPO.getId(),orgPO.getName(),orgPO.getKind(),orgPO.getLocation(),new CityVO(orgPO.getCity().getId(),orgPO.getCity().getName()));
//		ResultMessage message = new ResultMessage(isSuccessful, orgVO);
//		return message;
//	}

//	public ResultMessage orgList() {
//		// TODO 自动生成的方法存根
//		ArrayList<OrgPO> ar= null;
//		boolean isSuccessful=false;
//		try{
//			ar=orgData.findOrg("");
//			isSuccessful=true;
//		}
//		catch(RemoteException e){
//			e.printStackTrace();
//		}
//		ArrayList<OrgVO> arVO=new ArrayList<OrgVO>();
//		for(int i=0;i<ar.size();i++)
//		{
//			OrgPO Org=ar.get(i);
//			arVO.add(new OrgVO(Org.getId(),Org.getName(),Org.getKind(),Org.getLocation(),new CityVO(Org.getCity().getId(),Org.getCity().getName())));
//		}
//		ResultMessage message = new ResultMessage(isSuccessful, arVO);
//		return message;
//	}

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
//		ArrayList<CityPO> ar= null;
//		boolean isSuccessful=false;
//		try{
//			ar=orgData.getCities();
//			isSuccessful=true;
//		}
//		catch(RemoteException e){
//			e.printStackTrace();
//		}
//		ArrayList<CityVO> arVO=new ArrayList<CityVO>();
//		for(int i=0;i<ar.size();i++)
//		{
//			CityPO city=ar.get(i);
//			arVO.add(new CityVO(city.getId(),city.getName(),city.getProvince()));
//		}
//		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
//		return message;
		return uti.getCities();
	}

}
