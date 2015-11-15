package edu.nju.umr.logic.workOrgManLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.dataService.dataFactory.DriverManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.DriverManDSer;
import edu.nju.umr.logicService.workOrgManLogicSer.DriverManLSer;
import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.url.Url;
import edu.nju.umr.vo.DriverVO;
import edu.nju.umr.vo.ResultMessage;

public class DriverManLogic implements DriverManLSer{
	DriverManDFacSer dataFac;
	DriverManDSer driverData;
	
	public DriverManLogic(){
		try{
			dataFac=(DriverManDFacSer)Naming.lookup(Url.URL);
			driverData = dataFac.getDriverMan();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}

	public Result addDriver(DriverVO Driver) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
//		try
//		{
//			isSuccessful=driverData.addDriver(new DriverPO(Driver.getId(),Driver.getIdNum(),Driver.getBirthday(),Driver.getIdNum(),Driver.getMobile(),Driver.getSex(),Driver.getDriveLimit()));
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		return Result.SUCCESS;
	}

	public Result deleteDriver(String id) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try {
			isSuccessful=driverData.deleteDriver(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return Result.SUCCESS;
	}

	public Result reviseDriver(DriverVO Driver) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
//		try
//		{
//			isSuccessful=driverData.reviseDriver(new DriverPO(Driver.getId(),Driver.getIdNum(),Driver.getBirthday(),Driver.getIdNum(),Driver.getMobile(),Driver.getSex(),Driver.getDriveLimit()));
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		return Result.SUCCESS;
	}

	public ResultMessage checkDriver(String id) {
		// TODO 自动生成的方法存根
		DriverPO Driver=null;
		boolean isSuccessful=false;
//		try{
//			Driver=driverData.checkDriver(id);
//			isSuccessful=true;
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		ResultMessage message = new ResultMessage(isSuccessful,new DriverVO(Driver.getId(),Driver.getIdNum(),Driver.getBirthday(),Driver.getIdNum(),Driver.getMobile(),Driver.getSex(),Driver.getDriveLimit()));
		return null;
	}

	public ResultMessage driverList() {
		// TODO 自动生成的方法存根
		ArrayList<DriverPO> ar=null;
		boolean isSuccessful=false;
		try{
			ar=driverData.driverList();
			isSuccessful=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ArrayList<DriverVO> arVO=new ArrayList<DriverVO>();
//		for(int i=0;i<ar.size();i++)
//		{
//			DriverPO Driver = ar.get(i);
//			arVO.add(new DriverVO(Driver.getId(),Driver.getIdNum(),Driver.getBirthday(),Driver.getIdNum(),Driver.getMobile(),Driver.getSex(),Driver.getDriveLimit()));
//		}
		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
		return message;
	}

//	public ResultMessage searchDriver(String keyword) {
//		// TODO 自动生成的方法存根
//		ArrayList<DriverPO> ar=null;
//		boolean isSuccessful=false;
//		try{
//			ar=driverData.findDriver(keyword);
//			isSuccessful=true;
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		ArrayList<DriverVO> arVO=new ArrayList<DriverVO>();
//		for(int i=0;i<ar.size();i++)
//		{
//			DriverPO Driver = ar.get(i);
//			arVO.add(new DriverVO(Driver.getId(),Driver.getIdNum(),Driver.getBirthday(),Driver.getIdNum(),Driver.getMobile(),Driver.getSex(),Driver.getDriveLimit()));
//		}
//		ResultMessage message = new ResultMessage(isSuccessful, arVO);
//		return message;
//	}

}
