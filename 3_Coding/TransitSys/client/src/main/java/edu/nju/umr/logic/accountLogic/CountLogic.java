package edu.nju.umr.logic.accountLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.dataService.dataFactory.account.CountDFacSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.accountLogicSer.CountLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.CountVO;
import edu.nju.umr.vo.ResultMessage;

public class CountLogic implements CountLSer{
	private CountDFacSer countFac;
	private CountDSer countData;
	private UtilityLogic uti=new UtilityLogic();
	private ArrayList<CountPO> countPO=new ArrayList<CountPO>();
	private DiaryUpdateLSer diarySer;
	public CountLogic() {
		try{
			countFac = (CountDFacSer)Naming.lookup(Url.URL);
			countData = countFac.getCountData();
			uti=new UtilityLogic();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		diarySer = new DiaryUpdateLogic();
	}
	public Result newCount(String name) {		
		List<OrgPO> orgList=null;
		ArrayList<WorkPO> workList=null;
		ArrayList<VanPO> vanList=null;
		ArrayList<StockPO> stockList=null;
		ArrayList<AccountPO> accountList=null;
		try {
			orgList = uti.orgs();
			workList = uti.works(null);
			vanList = uti.vans(null);
			stockList = uti.stocks();
			accountList = uti.accounts();
		} catch (RemoteException e) {
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		
		CountPO count=new CountPO(0,(ArrayList<OrgPO>) orgList,workList,vanList,stockList,accountList,Calendar.getInstance());
		try {
			Result result=countData.addCount(count);
			result = diarySer.addDiary("新增账", name);
			return result;
		} catch (RemoteException e) {
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
	}
	public ResultMessage getCount(){
		Result result=Result.DATA_NOT_FOUND;
		
		try {
			countPO = countData.getCount();
			if(countPO!=null){
				result=Result.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		ArrayList<CountVO> list = new ArrayList<CountVO>();
		for(CountPO po:countPO){
			CountVO count = VPFactory.toCountVO(po);
			list.add(count);
		}
		return new ResultMessage(result,list);
	}
	@Override
	public Result deleteCount(int index,String name) {
		CountPO cp=countPO.get(index);
		Result result=Result.DATA_NOT_FOUND;
		try {
			result=countData.deleteCount(cp.getId());
			result = diarySer.addDiary("删除账"+cp.getId(), name);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return result;
	}
}
