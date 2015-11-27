package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.ReceiveOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.ReceiveOrderDSer;
import edu.nju.umr.logicService.orderNewLogic.ReceiveOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.vo.order.ExpressVO;

public class ReceiveOrderLogic implements ReceiveOrderLSer{
	
	ReceiveOrderDFacSer dataFac;
	ReceiveOrderDSer receiveData;
	public ReceiveOrderLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (ReceiveOrderDFacSer)Naming.lookup(Url.URL);
			receiveData = dataFac.getReceiveOrder();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public Result create(ExpressVO order) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.SUCCESS;
		try {
			isSuc=receiveData.create(new ExpressPO(order.getSender(), order.getSendLoc(), order.getReceiver(), order.getReceiveLoc(), order.getSendMobile(), order.getReceiveMobile(),
					order.getSendPhone(), order.getReceivePhone(), order.getSendUnit(), order.getReceiveUnit(), order.getNum(), order.getName(), order.getLength(), order.getWidth(), order.getHeight(), order.getWeight(), order.getVolumn(), 
					order.getId(), order.getArrive(), order.getKind(), order.getCost(), Calendar.getInstance(), order.getOpName()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}

		return isSuc;
	}

}
