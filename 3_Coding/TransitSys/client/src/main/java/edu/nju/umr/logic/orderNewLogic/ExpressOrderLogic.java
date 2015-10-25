package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.dataFactory.ExpressOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.ExpressOrderDSer;
import edu.nju.umr.logicService.orderNewLogic.ExpressOrderLSer;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.vo.order.ExpressVO;

public class ExpressOrderLogic implements ExpressOrderLSer{
	ExpressOrderDFacSer dataFac;
	ExpressOrderDSer expressData;
	public ExpressOrderLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (ExpressOrderDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			expressData = dataFac.getExpressOrder();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public boolean create(ExpressVO order) {
		// TODO 自动生成的方法存根
		boolean isSuc = false;
		try {
			isSuc = expressData.create(new ExpressPO(order.getSender(), order.getSendLoc(), order.getReceiver(), order.getReceiveLoc(), order.getSendMobile(), order.getReceiveMobile(), order.getNum(), order.getName(), order.getLength(), order.getWidth(), order.getHeight(), order.getWeight(), order.getVolumn(), order.getId(), order.getArrive(), order.getKind(), order.getCost()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return isSuc;
	}

}
