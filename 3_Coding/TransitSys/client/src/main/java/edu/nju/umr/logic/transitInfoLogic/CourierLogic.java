package edu.nju.umr.logic.transitInfoLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.umr.logicService.transitInfoLogicSer.CourierLSer;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.vo.order.ExpressVO;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.CourierDFacSer;
import edu.nju.umr.dataService.transitInfoDSer.CourierDSer;

public class CourierLogic implements CourierLSer{
	CourierDFacSer dataFac;
	CourierDSer CourierData;

	public CourierLogic(){
		try{
			dataFac=(CourierDFacSer)Naming.lookup(Url.URL);
			CourierData=dataFac.getCourier();
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
	
	public ResultMessage enterBarcodeCourier(String barcode) {
//		boolean isSuccessful=false;
		ExpressPO express=null;
		try{
			express=CourierData.find(barcode);
//			isSuccessful=true;
		}catch (RemoteException e) {
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}catch(Exception e)	{
			e.printStackTrace();
		}
		ResultMessage message=new ResultMessage(Result.SUCCESS,new ExpressVO(express.getSender(),express.getSendLoc(),express.getReceiver(),express.getReceiveLoc(),
				express.getSendMobile(),express.getReceiveMobile(),express.getSendPhone(),express.getReceivePhone(),express.getSendUnit(),express.getReceiveUnit(),
				express.getNum(),express.getName(),express.getLength(),express.getWidth(),express.getHeight(),express.getWeight(),express.getVolumn(),
				express.getArrive(),express.getKind(),express.getCost()));
		return message;
	}

}
