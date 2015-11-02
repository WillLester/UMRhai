package edu.nju.umr.logic.workOrgManLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.dataService.dataFactory.WageManDFacSer;
import edu.nju.umr.dataService.workOrgManDSer.WageManDSer;
import edu.nju.umr.logicService.workOrgManLogicSer.WageManLSer;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WageVO;
import edu.nju.umr.vo.WorkVO;

public class WageManLogic implements WageManLSer{
	WageManDFacSer dataFac;
	WageManDSer wageData;
	
	public WageManLogic(){
		try{
			dataFac=(WageManDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			wageData=dataFac.getWageMan();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public ResultMessage searchWorker(String keyword) {
		// TODO 自动生成的方法存根
		ArrayList<WorkPO> ar= null;
		boolean isSuccessful=false;
		try{
			ar=wageData.findWork("");
			isSuccessful=true;
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		ArrayList<WorkVO> arVO=new ArrayList<WorkVO>();
		for(int i=0;i<ar.size();i++)
		{
			WorkPO Work=ar.get(i);
			arVO.add(new WorkVO(Work.getName(),Work.getMobile(),Work.getOrgId(),Work.getId(),Work.getJuri()));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}

	public boolean reviseWage(WageVO wage) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
//		try{
//			WagePO wagePO=new WagePO(wage.getWorkerId(),wage.getKind(),wage.getCommission(),wage.getMoney());
//			isSuccessful=wageData.reviseWage(wagePO);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
		return isSuccessful;
	}

//	public ResultMessage getWage(String id) {
//		// TODO 自动生成的方法存根
//		boolean isSuccessful=false;
//		WagePO wage=null;
//		try
//		{
//			wage=wageData.getWage(id);
//			isSuccessful=true;
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		ResultMessage message=new ResultMessage(isSuccessful,new WageVO(wage.getWorkerId(),wage.getKind(),wage.getCommission(),wage.getMoney()));
//		return message;
//	}

}
