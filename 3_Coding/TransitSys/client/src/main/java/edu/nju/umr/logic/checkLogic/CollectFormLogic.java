package edu.nju.umr.logic.checkLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.dataService.checkDSer.CollectFormDSer;
import edu.nju.umr.dataService.dataFactory.CollectFormDFacSer;
import edu.nju.umr.logicService.checkLogicSer.CollectFormLSer;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public class CollectFormLogic implements CollectFormLSer{
	CollectFormDFacSer dataFac;
	CollectFormDSer collectData;
	public CollectFormLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (CollectFormDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			collectData = dataFac.getCollectForm();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public ResultMessage seeCollectRecord(Date date, String id) {
		// TODO 自动生成的方法存根
		ArrayList<IncomeVO> incomeList = new ArrayList<IncomeVO>();
		try {
			ArrayList<IncomePO> income = collectData.getCollectRec(date, id);
			for(IncomePO po:income){
				IncomeVO vo = new IncomeVO(po.getDate(), po.getCourier(), po.getCost(), po.getExpress(), po.getId());
				incomeList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return new ResultMessage(true, incomeList);
	}

	public ResultMessage total(ArrayList<IncomeVO> income) {
		// TODO 自动生成的方法存根
		double total = 0;
		for(IncomeVO in:income){
			total = total + in.getCost();
		}
		return new ResultMessage(true, total);
	}

}
