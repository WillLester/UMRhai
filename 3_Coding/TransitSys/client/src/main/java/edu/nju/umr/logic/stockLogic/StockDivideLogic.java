package edu.nju.umr.logic.stockLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.StockDivideDFacSer;
import edu.nju.umr.dataService.stockDSer.StockDivideDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logicService.stockLogicSer.StockDivideLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;

public class StockDivideLogic implements StockDivideLSer{
	private StockDivideDFacSer dataFac;
	private StockDivideDSer checkData;
	private DiaryUpdateLSer diarySer;
	private ArrayList<ShelfPO> shelfAll;
	public StockDivideLogic()throws RemoteException{
		try{
		dataFac=(StockDivideDFacSer)Naming.lookup(Url.URL);
		checkData=dataFac.getStockDivide();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        }
		diarySer = new DiaryUpdateLogic();
		shelfAll = new ArrayList<ShelfPO>();
	}

	public ResultMessage searchShelf(String id,String keyword) {
		// TODO 自动生成的方法存根
		ArrayList<ShelfPO> ar= new ArrayList<ShelfPO>();
		try{
			ar = checkData.getShelves(id,keyword);
			if(keyword == null){
				shelfAll = ar;
			} 
		}catch(RemoteException e){
			return new ResultMessage(Result.NET_INTERRUPT, Result.NET_INTERRUPT);
		}catch(Exception e){
			e.printStackTrace();
		}
		ArrayList<ShelfVO> arVO=new ArrayList<ShelfVO>();
		for(int i=0;i<ar.size();i++)
		{
			ShelfPO shelf=ar.get(i);
			arVO.add(new ShelfVO(shelf.getId(),shelf.getRow(),shelf.getPlace(),shelf.getPart()));
		}
		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
		return message;
	}

	@Override
	public Result addShelf(ShelfVO shelf,String name,String orgId) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try {
			isSuccessful=checkData.addShelf(new ShelfPO(shelf.getId(),orgId,shelf.getRow(),shelf.getPlace(),shelf.getPart()));
			isSuccessful = diarySer.addDiary("添加了架"+shelf.getId(), name);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	@Override
	public Result deleteShelf(String id,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try
		{
			isSuccessful=checkData.deleteShelf(id);
			isSuccessful = diarySer.addDiary("删除了架"+id, name);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	@Override
	public Result reviseShelf(ShelfVO shelf,String name,String orgId) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try
		{
			isSuccessful=checkData.reviseShelf(new ShelfPO(shelf.getId(),orgId,shelf.getRow(),shelf.getPlace(),shelf.getPart()));
			isSuccessful = diarySer.addDiary("修改了架"+shelf.getId(), name);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	@Override
	public String getNextId(String orgId) {
		// TODO 自动生成的方法存根
		int orgLength = orgId.length();
		int preId = -1;
		if(shelfAll.size() == 0){
			return orgId+"00000";
		}
		ArrayList<ShelfPO> shelfList = bubble();
		for(ShelfPO shelf:shelfList){
			int id = Integer.parseInt(shelf.getId().substring(orgLength, orgLength+5));
			if(id != preId+1){
				break;
			}
			preId = id;
		}
		String result = orgId;
		String back = ""+(preId+1);
		while(back.length() < 5){
			back = "0"+back;
		}
		return result+back;
	}
	
	private ArrayList<ShelfPO> bubble(){
		for(int i = 0;i < shelfAll.size();i++){
			for(int j = shelfAll.size()-1;j > i;j--){
				ShelfPO s1 = shelfAll.get(j);
				ShelfPO s2 = shelfAll.get(j-1);
				if(s1.getId().compareTo(s2.getId()) == -1){
					shelfAll.set(j, s2);
					shelfAll.set(j-1, s1);
				}
			}
		}
		return shelfAll;
	}
}
