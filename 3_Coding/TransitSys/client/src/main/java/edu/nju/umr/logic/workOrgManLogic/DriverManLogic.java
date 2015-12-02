package edu.nju.umr.logic.workOrgManLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.DriverManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.DriverManDSer;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.workOrgManLogicSer.DriverManLSer;
import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.enums.Result;
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
		Result isSuccessful=Result.SUCCESS;
		try
		{
			isSuccessful=driverData.addDriver(VPFactory.toDriverPO(Driver));
		}catch (RemoteException e) {
			return Result.NET_INTERRUPT;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}
	public Result deleteDriver(String id) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try {
			isSuccessful=driverData.deleteDriver(id);
		}catch (RemoteException e) {
			return Result.NET_INTERRUPT;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result reviseDriver(DriverVO Driver) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try
		{
			isSuccessful=driverData.addDriver(VPFactory.toDriverPO(Driver));
		}catch (RemoteException e) {
			return Result.NET_INTERRUPT;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

//	public ResultMessage checkDriver(String id) {
//		// TODO 自动生成的方法存根
//		DriverPO Driver=null;
//		Result isSuccessful=Result.SUCCESS;
//		try{
//			Driver=driverData.checkDriver(id);
//			isSuccessful=Result.SUCCESS;
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		ResultMessage message = new ResultMessage(isSuccessful,new DriverVO(Driver.getId(),Driver.getIdNum(),Driver.getBirthday(),Driver.getIdNum(),Driver.getMobile(),Driver.getSex(),Driver.getDriveStart(),Driver.getDriveEnd()));
//		return message;
//	}

//	public ResultMessage driverList() {
//		// TODO 自动生成的方法存根
//		ArrayList<DriverPO> ar=null;
//		boolean isSuccessful=false;
//		try{
//			ar=driverData.driverList();
//			isSuccessful=true;
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		ArrayList<DriverVO> arVO=new ArrayList<DriverVO>();
////		for(int i=0;i<ar.size();i++)
////		{
////			DriverPO Driver = ar.get(i);
////			arVO.add(new DriverVO(Driver.getId(),Driver.getIdNum(),Driver.getBirthday(),Driver.getIdNum(),Driver.getMobile(),Driver.getSex(),Driver.getDriveLimit()));
////		}
//		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
//		return message;
//	}

	public ResultMessage searchDriver(String hallId) {
		// TODO 自动生成的方法存根
//		System.out.println("ADASDASDS");
<<<<<<< HEAD
		ArrayList<DriverPO> ar=new ArrayList<DriverPO>();
=======
		ArrayList<DriverPO> ar=null;
>>>>>>> origin/master
		Result result=Result.DATA_NOT_FOUND;
		try{
			ar=driverData.findDriver(hallId);
			result=Result.SUCCESS;
		}catch (RemoteException e) {
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}catch(Exception e){
			e.printStackTrace();
		}
		ArrayList<DriverVO> arVO=new ArrayList<DriverVO>();
		for(int i=0;i<ar.size();i++){
			DriverVO driver=VPFactory.toDriverVO(ar.get(i));
			arVO.add(driver);
		}
		
//		arVO.add(new DriverVO("1","制杖",Calendar.getInstance(),"111","321312312312",Gender.WOMAN,Calendar.getInstance(),Calendar.getInstance()));
//		arVO.add(new DriverVO("2","蠢苍",Calendar.getInstance(),"222","321312312312",Gender.MAN,Calendar.getInstance(),Calendar.getInstance()));
		
		ResultMessage message = new ResultMessage(result, arVO);
		return message;
	}


}
