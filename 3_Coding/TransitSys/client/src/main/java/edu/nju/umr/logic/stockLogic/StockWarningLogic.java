package edu.nju.umr.logic.stockLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.StockWarningDFacSer;
import edu.nju.umr.dataService.stockDSer.StockWarningDSer;
import edu.nju.umr.logicService.stockLogicSer.StockWarningLSer;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public class StockWarningLogic implements StockWarningLSer{
	StockWarningDFacSer dataFac;
	StockWarningDSer checkData;
	public StockWarningLogic(){
		try{
			dataFac=(StockWarningDFacSer)Naming.lookup(Url.URL);
			checkData=dataFac.getStockWarning();
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

	public Result setWarning(ArrayList<Integer> warnings, String id) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		Part part=Part.MANEUVER;
		int w=-1;
		if(warnings.get(0)!=null) {part=Part.MANEUVER;w=warnings.get(0);}
		else if(warnings.get(1)!=null) {part=Part.PLANE;w=warnings.get(1);}
		else if(warnings.get(2)!=null) {part=Part.PLANE;w=warnings.get(2);}
		else if(warnings.get(3)!=null) {part=Part.PLANE;w=warnings.get(3);}
		else{return Result.DATA_NOT_FOUND;	}
		try{
			isSuccessful=checkData.setWarning(w,part, id);
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage getWarning(String id) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		ArrayList<Integer> ar=new ArrayList<Integer>();
		try{
			ar=checkData.getWarning(id);
			isSuccessful=Result.SUCCESS;
		}catch (RemoteException e) {
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}catch(Exception e)	{
			e.printStackTrace();
		}
		ResultMessage message=new ResultMessage(isSuccessful,ar);
		return message;
	}

}
