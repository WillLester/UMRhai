package edu.nju.umr.logic.stockLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.StockWarningDFacSer;
import edu.nju.umr.dataService.stockDSer.StockWarningDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logicService.stockLogicSer.StockWarningLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public class StockWarningLogic implements StockWarningLSer{
	private StockWarningDFacSer dataFac;
	private StockWarningDSer checkData;
	private DiaryUpdateLSer diarySer;
	public StockWarningLogic(){
		try{
			dataFac=(StockWarningDFacSer)Naming.lookup(Url.URL);
			checkData=dataFac.getStockWarning();
		} catch (NotBoundException e) { 
	        e.printStackTrace(); 
	    } catch (MalformedURLException e) { 
	        e.printStackTrace(); 
	    } catch (RemoteException e) { 
	        e.printStackTrace();   
	    } catch(Exception e){
	    	e.printStackTrace();
		}
		diarySer = new DiaryUpdateLogic();
	}

	public Result setWarning(ArrayList<Integer> warnings, String id,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try{
			isSuccessful=checkData.setWarning(warnings, id);
			isSuccessful = diarySer.addDiary("设置了警戒线", name);
		} catch(RemoteException e){
			return Result.NET_INTERRUPT;
		} catch(Exception e){
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage getWarning(String id) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.FILE_NOT_FOUND;
		ArrayList<Integer> warnings=new ArrayList<Integer>();
		try{
			warnings=checkData.getWarning(id);
			if(warnings != null){
				isSuccessful=Result.SUCCESS;
			}

		}catch (RemoteException e) {
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}catch(Exception e)	{
			e.printStackTrace();
		}
		ResultMessage message=new ResultMessage(isSuccessful,warnings);
		return message;
	}

}
