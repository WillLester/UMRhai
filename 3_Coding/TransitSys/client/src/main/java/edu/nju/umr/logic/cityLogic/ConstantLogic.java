package edu.nju.umr.logic.cityLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.umr.logicService.cityLogicSer.ConstantLSer;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ConstantVO;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.cityDSer.ConstantDSer;
import edu.nju.umr.dataService.dataFactory.ConstantDFacSer;
import edu.nju.umr.po.ConstantPO;
import edu.nju.umr.po.enums.Result;

public class ConstantLogic implements ConstantLSer{
	ConstantDFacSer dataFac;
	ConstantDSer constantData;
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
		
		ConstantPO po=new ConstantPO(constant.getMaxLoadPlane(), constant.getMaxLoadTrain(), constant.getMaxLoadVan(), 
					constant.getPricePlane(), constant.getPriceTrain(), constant.getPriceVan(), constant.getLvEco(), constant.getLvStd(), constant.getLvVip());
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
		Result isSuc = Result.SUCCESS;
		ConstantVO vo=null;
			ConstantPO po=null;
			try {
				po = constantData.getConstant();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return new ResultMessage(Result.NET_INTERRUPT,null);
			}
			vo=new ConstantVO(po.getMaxLoadPlane(),po.getMaxLoadTrain(),po.getMaxLoadVan(),
					po.getPricePlane(),po.getPriceTrain(),po.getPriceVan(),po.getLvEco(),po.getLvStd(),po.getLvVip());
			
			return new ResultMessage(isSuc,vo);
	}
}
