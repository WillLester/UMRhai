package edu.nju.umr.logic.stockLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.StockCheckDFacSer;
import edu.nju.umr.dataService.stockDSer.StockCheckDSer;
import edu.nju.umr.logicService.stockLogicSer.StockCheckLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.StockInOutVO;

public class StockCheckLogic implements StockCheckLSer{
	private StockCheckDFacSer dataFac;
	private StockCheckDSer checkData;
	
	public StockCheckLogic(){
		try {
			dataFac=(StockCheckDFacSer)Naming.lookup(Url.URL);
			checkData=dataFac.getStockCheck();
		}catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public ResultMessage orderStock(Calendar start,Calendar end,String id) {
	
		ArrayList<StockInOutVO> sList =new ArrayList<StockInOutVO>();
		try{
			ArrayList<StockInPO> stockInPOs=checkData.getIn(start, end, id);
			ArrayList<StockOutPO> stockOutPOs=checkData.getOut(start, end, id);
			for(StockInPO po:stockInPOs){
				StockInOutVO stock = new StockInOutVO(po.getId(),po.getDate(),"入库",po.getExpressId(),po.getShelfId(),po.getRow(),po.getPlace());
				sList.add(stock);
			}
			
			for(StockOutPO po:stockOutPOs){
				StockInOutVO stock=new StockInOutVO(po.getId(),po.getDate(),"出库",po.getExpressId(),"",0,0);
				sList.add(stock);
			}
			
			for(int i=0;i<sList.size();i++){
				for(int j=0;j<sList.size()-1;j++){
					StockInOutVO s1=sList.get(j);
					StockInOutVO s2=sList.get(j+1);
					if(s1.getTime().compareTo(s2.getTime())>0){
						StockInOutVO temp=s1;
						sList.set(j, s2);
						sList.set(j+1, temp);
					}
				}
			}
	} catch (RemoteException e) {
		return new ResultMessage(Result.NET_INTERRUPT,null);
	}
	
	return new ResultMessage(Result.SUCCESS,sList);
	}
}
