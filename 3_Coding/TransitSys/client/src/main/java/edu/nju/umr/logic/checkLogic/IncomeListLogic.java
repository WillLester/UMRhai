package edu.nju.umr.logic.checkLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.checkDSer.CollectRecordDSer;
import edu.nju.umr.dataService.dataFactory.check.CollectFormDFacSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.checkLogicSer.IncomeListLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;
//查看收款记录
public class IncomeListLogic implements IncomeListLSer{
	private CollectFormDFacSer dataFac;
	private CollectRecordDSer collectData;
	private UtilityLogic uti=new UtilityLogic();
	public IncomeListLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (CollectFormDFacSer)Naming.lookup(Url.URL);
			collectData = dataFac.getCollectForm();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public ResultMessage seeIncomeList(Calendar date, String hallId) {
		ArrayList<IncomeVO> incomeList = new ArrayList<IncomeVO>();
		try {
			ArrayList<IncomePO> income = collectData.getCollectRec(date, hallId);
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
		double total = 0;
		for(IncomeVO in:income){
			total = total + in.getCost();
		}
		return new ResultMessage(Result.SUCCESS, total);
	}
	//返回所有的营业厅列表
	public ResultMessage getHall() {
		
		return uti.getHall();
		 
	}

}
