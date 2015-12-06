package edu.nju.umr.logic.workOrgManLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.VanManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.VanManDSer;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.workOrgManLogicSer.VanManLSer;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.VanVO;

public class VanManLogic implements VanManLSer{
	private VanManDFacSer dataFac;
	private VanManDSer vanData;
	private ArrayList<VanPO> ar;
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
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			isSuccessful=vanData.addVan(VPFactory.toVanPO(van));
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result deleteVan(String id) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			isSuccessful=vanData.deleteVan(id);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result reviseVan(VanVO van) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			isSuccessful=vanData.reviseVan(VPFactory.toVanPO(van));
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
			result=Result.SUCCESS;
		}catch (RemoteException e) {
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
				return new ResultMessage(Result.SUCCESS,x1+1+"");
		}
		int x=Integer.parseInt(ar.get(ar.size()-1).getId());
		return new ResultMessage(Result.SUCCESS,x+1+"");
	}

}
