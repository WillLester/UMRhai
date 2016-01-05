package edu.nju.umr.logic.checkLogic;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.checkDSer.IncomeListDSer;
import edu.nju.umr.dataService.dataFactory.check.IncomeListDFacSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.checkLogicSer.IncomeListLSer;
import edu.nju.umr.logicService.utilityLogicSer.UtilityLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;
//查看收款记录
public class IncomeListLogic implements IncomeListLSer{
	private IncomeListDFacSer dataFac;
	private IncomeListDSer collectData;
	private UtilityLSer uti;
	public IncomeListLogic() throws RemoteException {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (IncomeListDFacSer)Naming.lookup(Url.URL);
			collectData = dataFac.getIncomeList();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } 
//		catch (RemoteException e) { 
//            e.printStackTrace();   
//        } 
		uti = new UtilityLogic();
	}
	public ResultMessage seeIncomeList(Calendar date, String org) {
		ArrayList<IncomeVO> incomeList = new ArrayList<IncomeVO>();
		try {
			ArrayList<IncomePO> income = collectData.getCollectRec(date, org);
			for(IncomePO po:income){
				IncomeVO vo = VPFactory.toIncomeVO(po);
				incomeList.add(vo);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		
		return new ResultMessage(Result.SUCCESS, incomeList);
	}

	public ResultMessage total(ArrayList<IncomeVO> income) {
		// TODO 自动生成的方法存根
		BigDecimal total = new BigDecimal(0);
		for(IncomeVO in:income){
			total = total.add(in.getCost());
		}
		return new ResultMessage(Result.SUCCESS, total);
	}
	//返回所有的营业厅列表
	public ResultMessage getHall() {
		
		return uti.getHall();
		 
	}

}
