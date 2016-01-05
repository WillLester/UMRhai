package edu.nju.umr.logic.transitInfoLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.CourierDFacSer;
import edu.nju.umr.dataService.transitInfoDSer.CourierDSer;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.transitInfoLogicSer.CourierLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.vo.ResultMessage;

public class CourierLogic implements CourierLSer{
	private CourierDFacSer dataFac;
	private CourierDSer CourierData;

	public CourierLogic()throws RemoteException{
		try{
			dataFac=(CourierDFacSer)Naming.lookup(Url.URL);
			CourierData=dataFac.getCourier();
		}catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        }
	}
	
	public ResultMessage enterBarcodeCourier(String barcode) {
		ExpressPO express=null;
		try{
			express=CourierData.find(barcode);
		}catch (RemoteException e) {
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}catch(Exception e)	{
			e.printStackTrace();
		}
		if(express==null)
		{
			return new ResultMessage(Result.DATA_NOT_FOUND,null);
		}
		ResultMessage message=new ResultMessage(Result.SUCCESS,VPFactory.toExpressVO(express));
		return message;
	}

}
