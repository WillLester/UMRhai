package edu.nju.umr.logic.workOrgManLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.logicService.workOrgManLogicSer.VanManLSer;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.VanVO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.dataService.dataFactory.VanManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.VanManDSer;

public class VanManLogic implements VanManLSer{
	VanManDFacSer dataFac;
	VanManDSer vanData;
	
	public VanManLogic(){
		try{
			dataFac= (VanManDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			vanData = dataFac.getVanMan();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public boolean addVan(VanVO Van) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try{
			isSuccessful=vanData.addVan(new VanPO(Van.getId(),Van.getPlateNum(),Van.getServTime(),Van.getPhoto(),Van.getOrgId()));
		}catch(RemoteException e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public boolean deleteVan(String id) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try{
			isSuccessful=vanData.deleteVan(id);
		}catch(RemoteException e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public boolean reviseVan(VanVO Van) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try{
			isSuccessful=vanData.reviseVan(new VanPO(Van.getId(),Van.getPlateNum(),Van.getServTime(),Van.getPhoto(),Van.getOrgId()));
		}catch(RemoteException e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage checkVan(String id) {
		// TODO 自动生成的方法存根
		VanPO Van=null;
		boolean isSuccessful=false;
		try{
			Van=vanData.checkVan(id);
			isSuccessful=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ResultMessage message=new ResultMessage(isSuccessful,new VanVO(Van.getId(),Van.getPlateNum(),Van.getServTime(),Van.getPhoto(),Van.getOrgId()));
		return message;
	}

	public ResultMessage VanList() {
		// TODO 自动生成的方法存根
		ArrayList<VanPO> ar=null;
		boolean isSuccessful=false;
		try
		{
			ar=vanData.findVan("");
			isSuccessful=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ArrayList<VanVO> arVO=new ArrayList<VanVO>();
		for(int i=0;i<ar.size();i++)
		{
			VanPO Van=ar.get(i);
			arVO.add(new VanVO(Van.getId(),Van.getPlateNum(),Van.getServTime(),Van.getPhoto(),Van.getOrgId()));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}

	public ResultMessage searchVan(String keyword) {
		// TODO 自动生成的方法存根
		VanPO Van=null;
		boolean isSuccessful=false;
		try{
			Van=vanData.checkVan(keyword);
			isSuccessful=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ResultMessage message=new ResultMessage(isSuccessful,new VanVO(Van.getId(),Van.getPlateNum(),Van.getServTime(),Van.getPhoto(),Van.getOrgId()));
		return message;
	}

}
