package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.umr.logicService.orderNewLogic.ReceiveOrderLSer;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ReceiveVO;
import edu.nju.umr.vo.order.ExpressVO;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.ReceivePO;
import edu.nju.umr.dataService.dataFactory.ReceiveOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.ReceiveOrderDSer;

public class ReceiveOrderLogic implements ReceiveOrderLSer{
	ReceiveOrderDFacSer dataFac;
	ReceiveOrderDSer receiveData;

	public ReceiveOrderLogic(){
		try{
			dataFac = (ReceiveOrderDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			receiveData = dataFac.getReceiveOrder();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	
	public boolean create(ReceiveVO order) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try{
			ReceivePO orderPO=new ReceivePO(order.getExpressId(),order.getReceiver(),order.getDate());
			receiveData.create(orderPO);
			isSuccessful=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage getExpress(String id) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		ExpressPO order=null;
		try{
			order=receiveData.getExpress(id);
			isSuccessful=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ResultMessage message=new ResultMessage(isSuccessful,new ExpressVO(order.getSender(), order.getSendLoc(), order.getReceiver(), order.getReceiveLoc(), order.getSendMobile(), order.getReceiveMobile(), order.getNum(), order.getName(), order.getLength(), order.getWidth(), order.getHeight(), order.getWeight(), order.getVolumn(), order.getId(), order.getArrive(), order.getKind(), order.getCost()));
		return message;
	}

}
