package edu.nju.umr.logic.workOrgManLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.VanManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.VanManDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.workOrgManLogicSer.VanManLSer;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.VanVO;

public class VanManLogic implements VanManLSer{
	private VanManDFacSer dataFac;
	private VanManDSer vanData;
	private ArrayList<VanPO> ar;
	private DiaryUpdateLSer diarySer;
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
		ar = new ArrayList<VanPO>();
		diarySer = new DiaryUpdateLogic();
	}
	public Result addVan(VanVO van,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			isSuccessful=vanData.addVan(VPFactory.toVanPO(van));
			isSuccessful = diarySer.addDiary("添加车辆"+van.getId(), name);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result deleteVan(String id,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			isSuccessful=vanData.deleteVan(id);
			isSuccessful = diarySer.addDiary("删除车辆"+id, name);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result reviseVan(VanVO van,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			isSuccessful=vanData.reviseVan(VPFactory.toVanPO(van));
			isSuccessful = diarySer.addDiary("修改车辆"+van.getId(), name);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage searchVan(String keyword,String hallId) {
		// TODO 自动生成的方法存根
	
		Result result=Result.DATA_NOT_FOUND;
		try{
			ar=vanData.findVan(keyword,hallId);
			if(ar != null){
				result=Result.SUCCESS;
			} else {
				return new ResultMessage(Result.DATA_NOT_FOUND, null);
			}
		}catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}catch(Exception e){
			e.printStackTrace();
		}
		ArrayList<VanVO> arVO=new ArrayList<VanVO>();
		for(int i=0;i<ar.size();i++){
			VanVO van=VPFactory.toVanVO(ar.get(i));
			arVO.add(van);
		}
		
		ResultMessage message = new ResultMessage(result, arVO);
		return message;

	}
	@Override
	public ResultMessage getNextId(String hallId) {
		// TODO Auto-generated method stub
		for(int i=0;i<ar.size()-1;i++){
			int x1=Integer.parseInt(ar.get(i).getId());
			int x2=Integer.parseInt(ar.get(i+1).getId());
			if(x2-x1>1)
			{
				String temp=Integer.toString(x1+1);
				while(temp.length()<9)temp="0"+temp;
				return new ResultMessage(Result.SUCCESS,temp);
			}
		}
		int x=-1;
		if(ar.size()>0)
		{
			x=Integer.parseInt(ar.get(ar.size()-1).getId());
			String temp=Integer.toString(x+1);
			while(temp.length()<9)temp="0"+temp;
			return new ResultMessage(Result.SUCCESS,temp);
		}
		else
		{
			return new ResultMessage(Result.SUCCESS,hallId+"000");
		}
	}

}
