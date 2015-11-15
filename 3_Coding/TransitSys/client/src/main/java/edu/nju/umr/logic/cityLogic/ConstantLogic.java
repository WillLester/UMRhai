package edu.nju.umr.logic.cityLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import edu.nju.umr.logicService.cityLogicSer.ConstantLSer;
import edu.nju.umr.url.Url;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ConstantVO;
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
		try
		{
			ConstantPO po=new ConstantPO(1,2,3,4,5,6,7,8,9);
			isSuc=constantData.setConstant(po);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuc;
	}
	public ResultMessage getConstant(){
		Result isSuc = Result.SUCCESS;
		ConstantVO vo=null;
		try
		{
			ConstantPO po=constantData.getConstant();
			vo=new ConstantVO(po.getMaxLoadPlane(),po.getMaxLoadTrain(),po.getMaxLoadVan(),po.getPricePlane(),po.getPriceTrain(),po.getPriceVan(),po.getLvEco(),po.getLvStd(),po.getLvVip());
			isSuc=Result.SUCCESS;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
			return new ResultMessage(isSuc,vo);
	}
}
