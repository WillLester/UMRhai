package edu.nju.umr.logic.orderApproveLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.orderNew.UpdateTranStateDFacSer;
import edu.nju.umr.dataService.orderApproveDSer.UpdateTranStateDSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.po.order.TransitPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.logicService.orderApproveLogicSer.UpdateTranStateLSer;
public class UpdateTranStateLogic implements UpdateTranStateLSer{
	UpdateTranStateDFacSer dataFac;
	UpdateTranStateDSer updateData;
	public UpdateTranStateLogic(){
		try{
			dataFac = (UpdateTranStateDFacSer)Naming.lookup(Url.URL);
			updateData = dataFac.getUpdateTranState();		
		} catch (NotBoundException e) { 
			e.printStackTrace(); 
		}catch (MalformedURLException e) { 
			e.printStackTrace(); 
		} catch (RemoteException e) { 
			e.printStackTrace();   
		} 
	}
	public Result updateExpressState(String id,String nowOrgId){
		ExpressPO ex=new ExpressPO(null,null,null,null,null,null,null,null,null,null,0,null,0,
				0,0,0,0,id,null,null,null,0, null, null, null, null,null,null,null,null,nowOrgId);
		try{
			return updateData.updateTranState(ex);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}
	}
	public ResultMessage getExpressHere(String nowOrgId){
		ExpressPO ex=new ExpressPO(null,null,null,null,null,null,null,null,null,null,0,null,0,
				0,0,0,0,null,null,null,null,0, null, null, null, null,null,null,null,null,nowOrgId);
		List<String> list=new ArrayList<String>();
		try{
			list=updateData.getOrdersHere(ex);
		}catch(RemoteException e){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		ArrayList<String> ar =new ArrayList<String>();
		ar.addAll(list);
		return new ResultMessage(Result.SUCCESS,ar);
	}
	@Override
	public ResultMessage getHallLoadingHere(String arriveLoc, boolean arrived) {
		HallLoadingPO hl=new HallLoadingPO(null, null, arriveLoc, null, null, null, null, null, null, null, 0, null, arrived);
		List<String> list=new ArrayList<String>();
		try{
			list=updateData.getOrdersHere(hl);
		}catch(RemoteException e){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		ArrayList<String> ar =new ArrayList<String>();
		ar.addAll(list);
		return new ResultMessage(Result.SUCCESS,ar);
	}
	@Override
	public ResultMessage getCenterLoadingHere(String arriveLoc, boolean arrived) {
		// TODO Auto-generated method stub
		CenterLoadingPO cl=new CenterLoadingPO(null, null, arriveLoc, null, null, null, null, null, null, 0, null, arrived, null,null);
		List<String> list=new ArrayList<String>();
		try{
			list=updateData.getOrdersHere(cl);
		}catch(RemoteException e){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		ArrayList<String> ar =new ArrayList<String>();
		ar.addAll(list);
		return new ResultMessage(Result.SUCCESS,ar);
	}
	@Override
	public ResultMessage getTransitHere(String arriveLoc, boolean arrived) {
		TransitPO tr=new TransitPO(null, null, null, arriveLoc, null, null, null, null, null, null, 0, null, null, arrived,null);
		List<String> list=new ArrayList<String>();
		try{
			list=updateData.getOrdersHere(tr);
		}catch(RemoteException e){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		ArrayList<String> ar =new ArrayList<String>();
		ar.addAll(list);
		return new ResultMessage(Result.SUCCESS,ar);
	}
	@Override
	public Result updateHallLoadingState(String id, boolean arrived) {
		HallLoadingPO hl=new HallLoadingPO(null, id, null, null, null, null, null, null, null, null, 0, null, arrived);
		try{
			return updateData.updateTranState(hl);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}
	}
	@Override
	public Result updateCenterLoadingState(String id, boolean arrived) {
		CenterLoadingPO cl=new CenterLoadingPO(null, id,null, null, null, null, null, null, null, 0, null, arrived, null,null);
		try{
			return updateData.updateTranState(cl);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}
	}
	@Override
	public Result updateTransitState(String id, boolean arrived) {
		TransitPO tr=new TransitPO(id, null, null, null, null, null, null, null, null, null, 0, null, null, arrived,null);
		try{
			return updateData.updateTranState(tr);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}
	}
	@Override
	public ResultMessage getGoingCenterLoading(String startPlace,
			boolean arrived) {
		CenterLoadingPO cl=new CenterLoadingPO(null, null, null, null, null, null, null, null, null, 0, null, arrived, startPlace,null);
		List<String> list=new ArrayList<String>();
		try{
			list=updateData.getOrdersHere(cl);
		}catch(RemoteException e){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		ArrayList<String> ar =new ArrayList<String>();
		ar.addAll(list);
		return new ResultMessage(Result.SUCCESS,ar);
	}
	@Override
	public ResultMessage getGoingTransit(String startPlace, boolean arrived) {
		TransitPO tr=new TransitPO(null, null, startPlace, null, null, null, null, null, null, null, 0, null, null, arrived,null);
		List<String> list=new ArrayList<String>();
		try{
			list=updateData.getOrdersHere(tr);
		}catch(RemoteException e){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		ArrayList<String> ar =new ArrayList<String>();
		ar.addAll(list);
		return new ResultMessage(Result.SUCCESS,ar);
	}
}
