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
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.workOrgManLogicSer.WageManLSer;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WageVO;
import edu.nju.umr.vo.WorkVO;

public class WageManLogic implements WageManLSer{
	WageManDFacSer dataFac;
	WageManDSer wageData;
	UtilityLogic uti=new UtilityLogic();
	List<WorkPO> ar;
	public WageManLogic()
	{
		try{
			dataFac=(WageManDFacSer)Naming.lookup(Url.URL);
			wageData=dataFac.getWageMan();
			uti=new UtilityLogic();
		}catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public ResultMessage searchWorks(String keyword) {
		// TODO 自动生成的方法存根
		ar= new ArrayList<WorkPO>();
//		boolean isSuccessful=false;
		try{
			ar=wageData.searchWork(keyword);
//			isSuccessful=true;
		}catch(Exception e){
			e.printStackTrace();
		}
		List<WorkVO> arVO = new ArrayList<WorkVO>();
		for(int i=0;i<ar.size();i++)
		{
			WorkPO work=ar.get(i);
//			arVO.add(new WorkVO(work.getName(),work.getMobile(),work.getOrg(),work.getJuri()));
			arVO.add(VPFactory.toWorkVO(work));
		}
		ResultMessage message = new ResultMessage(Result.SUCCESS, arVO);
		return message;
	}

	@Override
	public Result setWage(List<WageVO> wageList,int[] index) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.DATA_NOT_FOUND;
		
		for(int i=0;i<index.length;i++){
			WorkPO work=ar.get(index[i]);
			WageVO wage=wageList.get(i);
			WorkPO w=new WorkPO(work.getName(),work.getMobile(),work.getOrg(),work.getOrgId(),work.getId(),wage.getJuri(),wage.getKind(),wage.getWage(),wage.getCommission());
			isSuccessful=wageData.updateWork(w);
		}
		
		return isSuccessful;
	}

}
