package edu.nju.umr.logic.checkLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.dataService.checkDSer.StatementSheetDSer;
import edu.nju.umr.dataService.dataFactory.StatementSheetDFacSer;
import edu.nju.umr.logicService.checkLogicSer.StatementSheetLSer;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public class StatementSheetLogic implements StatementSheetLSer{
	StatementSheetDFacSer dataFac;
	StatementSheetDSer statementData;
	public StatementSheetLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (StatementSheetDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			statementData = dataFac.getStatement();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public ResultMessage seeStatementSheet(Date start, Date end, String id) {
		// TODO 自动生成的方法存根
		ArrayList<IncomeVO> incomeList = new ArrayList<IncomeVO>();
		try {
			ArrayList<IncomePO> income = statementData.findCollect(start, end);
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

	public ResultMessage getHall() {
		// TODO 自动生成的方法存根
		ArrayList<OrgVO> hallList = new ArrayList<OrgVO>();
		try {
			ArrayList<OrgPO> halls = statementData.getHall();
			for(OrgPO hall:halls){
				CityVO city = new CityVO(hall.getCity().getName(), hall.getCity().getId());
				OrgVO vo = new OrgVO(hall.getId(), hall.getName(), hall.getKind(), hall.getLocation(), city);
				hallList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(true, hallList);
	}

	public boolean outputExcel(ArrayList<IncomeVO> income, String location) {
		// TODO 自动生成的方法存根
		return true;
	}

}
