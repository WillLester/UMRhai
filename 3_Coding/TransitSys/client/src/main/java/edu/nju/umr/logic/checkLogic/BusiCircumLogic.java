package edu.nju.umr.logic.checkLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.dataService.checkDSer.BusiCircumDSer;
import edu.nju.umr.dataService.dataFactory.StatementSheetDFacSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.checkLogicSer.BusiCircumLSer;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.url.Url;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;

public class BusiCircumLogic implements BusiCircumLSer{
	StatementSheetDFacSer dataFac;
	BusiCircumDSer statementData;
	UtilityLogic uti;
	public BusiCircumLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (StatementSheetDFacSer)Naming.lookup(Url.URL);
			statementData = dataFac.getStatement();
			uti=new UtilityLogic();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public ResultMessage seeBusinessCircum(Date start, Date end) {
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
		
		return new ResultMessage(Result.SUCCESS, incomeList);
	}

	public ResultMessage getHall() {
		// TODO 自动生成的方法存根
//		ArrayList<OrgVO> hallList = new ArrayList<OrgVO>();
//		try {
//			ArrayList<OrgPO> halls = statementData.getHall();
//			for(OrgPO hall:halls){
//				CityVO city = new CityVO(hall.getCity().getName(), hall.getCity().getId(),hall.getCity().getProvince());
//				OrgVO vo = new OrgVO(hall.getId(), hall.getName(), hall.getKind(), hall.getLocation(), city);
//				hallList.add(vo);
//			}
//		} catch (RemoteException e) {
//			// TODO 自动生成的 catch 块
//			e.printStackTrace();
//		}
//		return new ResultMessage(Result.SUCCESS, hallList);
		return uti.getHall();
	}

	public Result outputExcel(ArrayList<IncomeVO> income, String location) {
		// TODO 自动生成的方法存根
		return Result.SUCCESS;
	}

}
