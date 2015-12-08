package edu.nju.umr.logic.stockLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.StockDivideDFacSer;
import edu.nju.umr.dataService.stockDSer.StockDivideDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logicService.stockLogicSer.StockDivideLSer;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;

public class StockDivideLogic implements StockDivideLSer{
	private StockDivideDFacSer dataFac;
	private StockDivideDSer checkData;
	private DiaryUpdateLSer diarySer;
	public StockDivideLogic(){
		try{
		dataFac=(StockDivideDFacSer)Naming.lookup(Url.URL);
		checkData=dataFac.getStockDivide();
		}catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } catch(Exception e)
		{
			e.printStackTrace();
		}
		diarySer = new DiaryUpdateLogic();
	}

	public ResultMessage searchShelf(String id,String keyword) {
		// TODO 自动生成的方法存根
		ArrayList<ShelfPO> ar=null;
//		boolean isSuccessful=false;
		try{
			ar=checkData.getShelves(id,keyword);
//			isSuccessful=true;
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

	public Result addShelf(ShelfVO shelf,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try {
			isSuccessful=checkData.addShelf(new ShelfPO(shelf.getId(),"00001",shelf.getRow(),shelf.getPlace(),shelf.getPart()));
			isSuccessful = diarySer.addDiary("添加了架"+shelf.getId(), name);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

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

	public Result reviseShelf(ShelfVO shelf,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try
		{
			isSuccessful=checkData.reviseShelf(new ShelfPO(shelf.getId(),"00001",shelf.getRow(),shelf.getPlace(),shelf.getPart()));
			isSuccessful = diarySer.addDiary("修改了架"+shelf.getId(), name);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

}
