package edu.nju.umr.logic.cityLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.cityDSer.ConstantDSer;
import edu.nju.umr.dataService.dataFactory.ConstantDFacSer;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.cityLogicSer.ConstantLSer;
import edu.nju.umr.po.ConstantPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ConstantVO;
import edu.nju.umr.vo.ResultMessage;

public class ConstantLogic implements ConstantLSer{
	private ConstantDFacSer dataFac;
	private ConstantDSer constantData;
	public ConstantLogic()
	{
		try{
			dataFac = (ConstantDFacSer)Naming.lookup(Url.URL);
			constantData = dataFac.getConstant();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public Result setConstant(ConstantVO constant)
	{
		Result isSuc=Result.SUCCESS;
		
		ConstantPO po=VPFactory.toConstantPO(constant);
			try {
				isSuc=constantData.setConstant(po);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return Result.NET_INTERRUPT;
			}
		return isSuc;
	}
	public ResultMessage getConstant(){
		ConstantPO po;
		try {
			po = constantData.getConstant();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}
		ConstantVO vo = VPFactory.toConstantVO(po);
		return new ResultMessage(Result.SUCCESS, vo);
	}
}
