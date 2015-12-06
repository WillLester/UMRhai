package edu.nju.umr.logic.accountLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.accountDSer.CountDSer;
import edu.nju.umr.dataService.dataFactory.CountDFacSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.accountLogicSer.CountLSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public class CountLogic implements CountLSer{
	private CountDFacSer countFac;
	private CountDSer countData;
	private UtilityLogic uti=new UtilityLogic();
	private ArrayList<CountPO> countPO=new ArrayList<CountPO>();
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
	}
	public Result newCount() {		
		ArrayList<OrgPO> orgList=null;
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
		
		CountPO count=new CountPO(0,orgList,workList,vanList,stockList,accountList,Calendar.getInstance());
		try {
			Result result=countData.addCount(count);
			return result;
		} catch (RemoteException e) {
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
	}
	public ResultMessage getCount(){
		Result result=Result.DATA_NOT_FOUND;
		
		try {
			countPO=countData.getCount();
			if(countPO!=null){
				result=Result.SUCCESS;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		return new ResultMessage(result,countPO);
	}
	@Override
	public Result deleteCount(int index) {
		CountPO cp=countPO.get(index);
		Result result=Result.DATA_NOT_FOUND;
		try {
			result=countData.deleteCount(cp.getId());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return result;
	}
}
