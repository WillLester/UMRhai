package edu.nju.umr.logic.stockLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.StockCheckWarnDFacSer;
import edu.nju.umr.dataService.stockDSer.StockCheckWarnDSer;
import edu.nju.umr.logicService.stockLogicSer.StockCheckWarnLSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;


public class StockCheckWarnLogic implements StockCheckWarnLSer{
	private StockCheckWarnDFacSer dataFac;
	private StockCheckWarnDSer checkData;
	
	public StockCheckWarnLogic(){
		try{
		dataFac=(StockCheckWarnDFacSer)Naming.lookup(Url.URL);
		checkData=dataFac.getStockCheckWarn();
		}catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } catch(Exception e){
			e.printStackTrace();
		}
	}
	public ResultMessage checkWarning(String id,Part part) {
		// TODO 自动生成的方法存根
		ArrayList<Integer> warning=new ArrayList<Integer>();
		try{
			warning=checkData.getWarning(id);
		}catch(RemoteException e){
			return new ResultMessage(Result.NET_INTERRUPT, Result.NET_INTERRUPT);
		}
		if(warning == null){
			return new ResultMessage(Result.SUCCESS, Result.SUCCESS);
		}
		try {
			StockPO stock = checkData.getStock(id);
			ArrayList<GoodPO> goods = stock.getGoods();
			ArrayList<ShelfPO> shelves = checkData.getShelves(id);
			int planeShelf = 0;
			int trainShelf = 0;
			int vanShelf = 0;
			int maneuverShelf = 0;
			for(ShelfPO shelf:shelves){
				int total = shelf.getRow() * shelf.getPlace();
				switch(shelf.getPart()){
				case PLANE:planeShelf += total;break;
				case TRAIN:trainShelf += total;break;
				case VAN:vanShelf += total;break;
				case MANEUVER:maneuverShelf += total;break;
				}
			}
			int planeGood = 0;
			int trainGood = 0;
			int vanGood = 0;
			int maneuverGood = 0;
			for(GoodPO good:goods){
				switch(good.getPart()){
				case PLANE:planeGood++;break;
				case TRAIN:trainGood++;break;
				case VAN:vanGood++;break;
				case MANEUVER:maneuverGood++;break;
				}
			}
			switch(part){
			case MANEUVER:
				maneuverGood++;
				break;
			case PLANE:
				planeGood++;
				break;
			case TRAIN:
				trainGood++;
				break;
			case VAN:
				vanGood++;
				break;
			default:
				break;
			
			}
			if((double)planeGood/planeShelf >= (double)warning.get(0)/100){
				ResultMessage message = new ResultMessage(Result.SUCCESS, Result.OUT_OF_STOCK_PLANE);
				return message;
			}
			if((double)trainGood/trainShelf >= (double)warning.get(1)/100){
				ResultMessage message = new ResultMessage(Result.SUCCESS, Result.OUT_OF_STOCK_TRAIN);
				return message;
			}
			if((double)vanGood/vanShelf >= (double)warning.get(2)/100){
				ResultMessage message = new ResultMessage(Result.SUCCESS, Result.OUT_OF_STOCK_VAN);
				return message;
			}
			if((double)maneuverGood/maneuverShelf >= (double)warning.get(3)/100){
				ResultMessage message = new ResultMessage(Result.SUCCESS, Result.OUT_OF_STOCK_MANEUVER);
				return message;
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}
		ResultMessage message=new ResultMessage(Result.SUCCESS,Result.SUCCESS);
		return message;
	}
	
}
