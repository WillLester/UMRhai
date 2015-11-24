package edu.nju.umr.logic.workOrgManLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.VanManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.VanManDSer;
import edu.nju.umr.logicService.workOrgManLogicSer.VanManLSer;
import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.DriverVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.VanVO;

public class VanManLogic implements VanManLSer{
	VanManDFacSer dataFac;
	VanManDSer vanData;
	
	public VanManLogic(){
		try{
			dataFac= (VanManDFacSer)Naming.lookup(Url.URL);
			vanData = dataFac.getVanMan();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public Result addVan(VanVO van) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try{
			isSuccessful=vanData.addVan(new VanPO(van.getId(),van.getPlateNum(),van.getServTime(),van.getPhoto(),van.getHallId()));
		}catch(RemoteException e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result deleteVan(String id) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try{
			isSuccessful=vanData.deleteVan(id);
		}catch(RemoteException e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result reviseVan(VanVO van) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try{
			isSuccessful=vanData.reviseVan(new VanPO(van.getId(),van.getPlateNum(),van.getServTime(),van.getPhoto(),van.getHallId()));
		}catch(RemoteException e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

//	public ResultMessage checkVan(String id) {
//		// TODO 自动生成的方法存根
//		VanPO Van=null;
//		Result isSuccessful=Result.SUCCESS;
//		try{
//			Van=vanData.checkVan(id);
//			isSuccessful=Result.SUCCESS;
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		ResultMessage message=new ResultMessage(isSuccessful,new VanVO(Van.getId(),Van.getPlateNum(),Van.getServTime(),Van.getPhoto()));
//		return message;
//	}

//	public ResultMessage VanList() {
//		// TODO 自动生成的方法存根
//		ArrayList<VanPO> ar=null;
//		boolean isSuccessful=false;
//		try
//		{
//			ar=vanData.findVan("");
//			isSuccessful=true;
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		ArrayList<VanVO> arVO=new ArrayList<VanVO>();
//		for(int i=0;i<ar.size();i++)
//		{
//			VanPO Van=ar.get(i);
//			arVO.add(new VanVO(Van.getId(),Van.getPlateNum(),Van.getServTime(),Van.getPhoto(),Van.getOrgId()));
//		}
//		ResultMessage message = new ResultMessage(isSuccessful, arVO);
//		return message;
//	}

	public ResultMessage searchVan(String keyword,String hallId) {
		// TODO 自动生成的方法存根
//		ArrayList<VanPO> van=null;
//		Result isSuccessful=Result.SUCCESS;
//		try{
//			Van=vanData.findVan(keyword,hallId);
//			isSuccessful=Result.SUCCESS;
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		ResultMessage message=new ResultMessage(isSuccessful,new VanVO(Van.getId(),Van.getPlateNum(),Van.getServTime(),Van.getPhoto()));
//		return message;
		ArrayList<VanPO> ar=null;
		Result result=Result.SUCCESS;
		try{
			ar=vanData.findVan(keyword,hallId);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ArrayList<VanVO> arVO=new ArrayList<VanVO>();
		for(int i=0;i<ar.size();i++){
			VanVO van=new VanVO(ar.get(i).getId(),ar.get(i).getPlateNum(),ar.get(i).getServTime(),ar.get(i).getPhoto(),ar.get(i).getHallId());
			arVO.add(van);
		}
		
		ResultMessage message = new ResultMessage(result, arVO);
		return message;

	}

}
