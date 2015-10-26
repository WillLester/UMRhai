package edu.nju.umr.logic.workOrgManLogic;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.logicService.workOrgManLogicSer.DriverManLSer;
import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Sex;
import edu.nju.umr.vo.DriverVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;
import edu.nju.umr.dataService.dataFactory.DriverManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.DriverManDSer;

public class DriverManLogic implements DriverManLSer{
	DriverManDFacSer dataFac;
	DriverManDSer driverData;
	
	public DriverManLogic(){
		try{
			dataFac=(DriverManDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			driverData=(DriverManDSer)dataFac.getDriverMan();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public boolean addDriver(DriverVO Driver) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try
		{
			isSuccessful=driverData.addDriver(new DriverPO(Driver.getId(),Driver.getIdNum(),Driver.getBirthday(),Driver.getIdNum(),Driver.getMobile(),Driver.getSex(),Driver.getDriveLimit()));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public boolean deleteDriver(String id) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try
		{
			isSuccessful=driverData.deleteDriver(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public boolean reviseDriver(DriverVO Driver) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try
		{
			isSuccessful=driverData.reviseDriver(new DriverPO(Driver.getId(),Driver.getIdNum(),Driver.getBirthday(),Driver.getIdNum(),Driver.getMobile(),Driver.getSex(),Driver.getDriveLimit()));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage checkDriver(String id) {
		// TODO 自动生成的方法存根
		DriverPO Driver=null;
		boolean isSuccessful=false;
		try{
			Driver=driverData.checkDriver(id);
			isSuccessful=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		ResultMessage message = new ResultMessage(isSuccessful,new DriverVO(Driver.getId(),Driver.getIdNum(),Driver.getBirthday(),Driver.getIdNum(),Driver.getMobile(),Driver.getSex(),Driver.getDriveLimit()));
		return message;
	}

	public ResultMessage DriverList() {
		// TODO 自动生成的方法存根
		ArrayList<DriverPO> ar=null;
		boolean isSuccessful=false;
		try{
			ar=driverData.findDriver("");
			isSuccessful=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ArrayList<DriverVO> arVO=new ArrayList<DriverVO>();
		for(int i=0;i<ar.size();i++)
		{
			DriverPO Driver = ar.get(i);
			arVO.add(new DriverVO(Driver.getId(),Driver.getIdNum(),Driver.getBirthday(),Driver.getIdNum(),Driver.getMobile(),Driver.getSex(),Driver.getDriveLimit()));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}

	public ResultMessage searchDriver(String keyword) {
		// TODO 自动生成的方法存根
		ArrayList<DriverPO> ar=null;
		boolean isSuccessful=false;
		try{
			ar=driverData.findDriver(keyword);
			isSuccessful=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ArrayList<DriverVO> arVO=new ArrayList<DriverVO>();
		for(int i=0;i<ar.size();i++)
		{
			DriverPO Driver = ar.get(i);
			arVO.add(new DriverVO(Driver.getId(),Driver.getIdNum(),Driver.getBirthday(),Driver.getIdNum(),Driver.getMobile(),Driver.getSex(),Driver.getDriveLimit()));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}

}
