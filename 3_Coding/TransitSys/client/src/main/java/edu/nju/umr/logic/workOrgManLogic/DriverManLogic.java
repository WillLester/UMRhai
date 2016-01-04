package edu.nju.umr.logic.workOrgManLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.DriverManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.DriverManDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.workOrgManLogicSer.DriverManLSer;
import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.DriverVO;
import edu.nju.umr.vo.ResultMessage;

public class DriverManLogic implements DriverManLSer{
	private DriverManDFacSer dataFac;
	private DriverManDSer driverData;
	private DiaryUpdateLSer diarySer;
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
		diarySer = new DiaryUpdateLogic();
	}

	public Result addDriver(DriverVO driver,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try{
			isSuccessful=driverData.addDriver(VPFactory.toDriverPO(driver));
			isSuccessful = diarySer.addDiary("新增司机"+driver.getId(), name);
		}catch (RemoteException e) {
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}
	public Result deleteDriver(String id,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try {
			isSuccessful=driverData.deleteDriver(id);
			isSuccessful = diarySer.addDiary("删除司机"+id, name);
		}catch (RemoteException e) {
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result reviseDriver(DriverVO driver,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try{
			isSuccessful=driverData.reviseDriver(VPFactory.toDriverPO(driver));
			isSuccessful = diarySer.addDiary("修改司机"+driver.getId(), name);
		}catch (RemoteException e) {
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage searchDriver(String hallId) {
		// TODO 自动生成的方法存根
		ArrayList<DriverPO> ar=new ArrayList<DriverPO>();
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
		
		ResultMessage message = new ResultMessage(result, arVO);
		return message;
	}

	@Override
	public ResultMessage getNextDriver(String hallId) {
		ArrayList<DriverPO> ar = new ArrayList<DriverPO>();
		Result result=Result.SUCCESS;
		try
		{
			ar=driverData.findDriver(hallId);
			result=Result.SUCCESS;
		}catch(Exception e)
		{
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		for(int i=0;i<ar.size();i++){
			for(int j=i+1;j<ar.size();j++)
			{
				DriverPO left=ar.get(i);
				DriverPO right=ar.get(j);
				if(left.getId().compareTo(right.getId())>0)
				{
					ar.set(i, right);
					ar.set(j, left);
				}
			}
		}
		String id="1";
		for(int i=0;i<ar.size();i++)
		{
			int nowId=Integer.parseInt(ar.get(i).getId().substring(5,9));
			id=Integer.toString(i+1);
			if(nowId>i+1)
			{
				break;
			}else{
				id=Integer.toString(i+2);
			}
		}
		while(id.length()<3)
		{
			id="0"+id;
		}
		return new ResultMessage(result,id);
	}


}
