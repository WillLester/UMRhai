package edu.nju.umr.logic.transitInfoLogic;

import java.rmi.Naming;

import edu.nju.umr.logicService.transitInfoLogicSer.CourierLSer;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.vo.order.ExpressVO;
import edu.nju.umr.dataService.dataFactory.CourierDFacSer;
import edu.nju.umr.dataService.transitInfoDSer.CourierDSer;

public class CourierLogic implements CourierLSer{
	CourierDFacSer dataFac;
	CourierDSer CourierData;

	public CourierLogic(){
		try{
			dataFac=(CourierDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			CourierData=dataFac.getCourier();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public ResultMessage enterBarcodeCourier(String barcode) {
		boolean isSuccessful=false;
		ExpressPO express=null;
		try{
			express=CourierData.find(barcode);
			isSuccessful=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ResultMessage message=new ResultMessage(isSuccessful,new ExpressVO(express.getSender(),express.getSendLoc(),express.getReceiver(),express.getReceiveLoc(),express.getSendMobile(),
				express.getReceiveMobile(),express.getNum(),express.getName(),express.getLength(),express.getWidth(),express.getHeight(),express.getWeight(),express.getVolumn(),express.getId(),
				express.getArrive(),express.getKind(),express.getCost()));
		return message;
	}

}
