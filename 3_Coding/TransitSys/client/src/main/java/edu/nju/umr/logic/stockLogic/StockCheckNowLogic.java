package edu.nju.umr.logic.stockLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.StockCheckNowDFacSer;
import edu.nju.umr.dataService.stockDSer.StockCheckNowDSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.stockLogicSer.StockCheckNowLSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public class StockCheckNowLogic implements StockCheckNowLSer{
	private StockCheckNowDFacSer dataFac;
	private StockCheckNowDSer checkData;
	private UtilityLogic uti=new UtilityLogic();
	private StockPO stock=null;
	
	public StockCheckNowLogic(){
		try
		{
			dataFac=(StockCheckNowDFacSer)Naming.lookup(Url.URL);
			checkData=dataFac.getStockCheckNow();
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
	}
	
	public ResultMessage checkNow(String id) {
		Result isSuc=Result.DATA_NOT_FOUND;		
		try{
			stock=checkData.getStock(id);
			if(stock!=null)
				isSuc=Result.SUCCESS;
		}catch (RemoteException e) {
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ResultMessage message=new ResultMessage(isSuc,VPFactory.toStockVO(stock));
		return message;
	}
	
	public Result outputExcel(String location, String name) {
		ArrayList<GoodPO> goodList=stock.getGoods();
		String data[][]=new String[1+goodList.size()][7];
		data[0][0]="快递编号";
		data[0][1]="入库日期";
		data[0][2]="目的地";
		data[0][3]="区号";
		data[0][4]="架号";
		data[0][5]="排号";
		data[0][6]="位号";
		
		for(int i=0;i<goodList.size();i++){
			GoodPO good=goodList.get(i);
			data[i+1][0]=good.getId();
			data[i+1][1]=(good.getDate().get(Calendar.YEAR)+"")+"."+((good.getDate().get(Calendar.MONTH)+1)+"")+"."+(good.getDate().get(Calendar.DATE)+"");
			data[i+1][2]=good.getCity();
			data[i+1][3]=good.getPart()+"";
			data[i+1][4]=good.getShelf()+"";
			data[i+1][5]=good.getRow()+"";
			data[i+1][6]=good.getPlace()+"";
		}
		
		
				
		return uti.outputExcel(data, name, location);
	}

}
