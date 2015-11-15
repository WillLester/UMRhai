package edu.nju.umr.logic.stockLogic;

import java.rmi.Naming;
import java.util.ArrayList;

import edu.nju.umr.dataService.dataFactory.StockDivideDFacSer;
import edu.nju.umr.dataService.stockDSer.StockDivideDSer;
import edu.nju.umr.logicService.stockLogicSer.StockDivideLSer;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;

public class StockDivideLogic implements StockDivideLSer{
	StockDivideDFacSer dataFac;
	StockDivideDSer checkData;
	
	public StockDivideLogic(){
		try{
		dataFac=(StockDivideDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
		checkData=dataFac.getStockDivide();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public ResultMessage searchShelf(String id,String keyword) {
		// TODO 自动生成的方法存根
		ArrayList<ShelfPO> ar=null;
		boolean isSuccessful=false;
//		try{
//			ar=checkData.getShelves(id);
//			isSuccessful=true;
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		ArrayList<ShelfVO> arVO=new ArrayList<ShelfVO>();
//		for(int i=0;i<ar.size();i++)
//		{
//			ShelfPO shelf=ar.get(i);
//			arVO.add(new ShelfVO(shelf.getId(),shelf.getRow(),shelf.getPlace(),shelf.getPart()));
//		}
//		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return null;
	}

	public Result addShelf(ShelfVO shelf) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try {
			isSuccessful=checkData.addShelf(new ShelfPO(shelf.getId(),"00001",shelf.getRow(),shelf.getPlace(),shelf.getPart()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result deleteShelf(String id) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try
		{
			isSuccessful=checkData.deleteShelf(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result reviseShelf(ShelfVO shelf) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try
		{
			isSuccessful=checkData.reviseShelf(new ShelfPO(shelf.getId(),"00001",shelf.getRow(),shelf.getPlace(),shelf.getPart()));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

//	public ResultMessage checkShelf(String id) {
//		// TODO 自动生成的方法存根
//		boolean isSuccessful=false;
//		ShelfPO shelf=null;
//		try{
//			shelf=checkData.getShelf(id);
//			isSuccessful=true;
//		}catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		ResultMessage message = new ResultMessage(isSuccessful, new ShelfVO(shelf.getId(),shelf.getRow(),shelf.getPlace(),shelf.getPart()));
//		return message;
//	}

}
