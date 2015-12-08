package edu.nju.umr.logic.workOrgManLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.WageManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.WageManDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.workOrgManLogicSer.WageManLSer;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WageVO;

public class WageManLogic implements WageManLSer{
	private WageManDFacSer dataFac;
	private WageManDSer wageData;
	private List<WorkPO> workList;
	private DiaryUpdateLSer diarySer;
	public WageManLogic()
	{
		try{
			dataFac=(WageManDFacSer)Naming.lookup(Url.URL);
			wageData=dataFac.getWageMan();
		}catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } catch(Exception e){
			e.printStackTrace();
		}
		diarySer = new DiaryUpdateLogic();
	}

	@Override
	public ResultMessage searchWorks(String keyword) {
		// TODO 自动生成的方法存根
		workList= new ArrayList<WorkPO>();
		try{
			workList=wageData.searchWork(keyword);
		}catch(Exception e){
			e.printStackTrace();
		}
		List<WageVO> arVO = new ArrayList<WageVO>();
		for(int i=0;i<workList.size();i++)
		{
			WorkPO work=workList.get(i);
			arVO.add(VPFactory.toWageVO(work));
		}
		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
		return message;
	}

	@Override
	public Result setWage(List<WageVO> wageList,int[] index,String name) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		
		for(int i = 0;i < index.length;i++){
			WorkPO work = workList.get(index[i]);
			WageVO wage = wageList.get(i);
			WorkPO w = new WorkPO(work.getName(),work.getMobile(),work.getOrg(),work.getOrgId(),work.getId(),wage.getJuri(),wage.getKind(),wage.getWage(),wage.getCommission());
			try {
				isSuccessful = wageData.updateWork(w);
				isSuccessful = diarySer.addDiary("修改了人员的薪水", name);
			} catch (RemoteException e) {
				// TODO 自动生成的 catch 块
				return Result.NET_INTERRUPT;
			}
		}
		
		return isSuccessful;
	}

}
