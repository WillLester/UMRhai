package edu.nju.umr.logic.utilityLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.utility.ConstantGetDFacSer;
import edu.nju.umr.dataService.utilityDSer.ConstantGetDSer;
import edu.nju.umr.logicService.utilityLogicSer.ConstantGetLSer;
import edu.nju.umr.po.ConstantPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public class ConstantGetLogic implements ConstantGetLSer{
	private ConstantGetDFacSer dataFac;
	private ConstantGetDSer dataSer;
	public ConstantGetLogic() {
		// TODO 自动生成的构造函数存根
		try {
			dataFac = (ConstantGetDFacSer) Naming.lookup(Url.URL);
			dataSer = dataFac.getConstantGet();
		} catch (MalformedURLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultMessage getExpressCost() {
		// TODO 自动生成的方法存根
		try {
			ConstantPO constant = dataSer.getConstant();
			if(constant == null){
				return new ResultMessage(Result.DATA_NOT_FOUND, null);
			} else {
				List<Double> costs = new ArrayList<Double>();
				costs.add(constant.getLvEco());
				costs.add(constant.getLvStd());
				costs.add(constant.getLvVip());
				return new ResultMessage(Result.SUCCESS, costs);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}
	}
	
	@Override
	public ResultMessage getTransitCost(){
		try {
			ConstantPO constant = dataSer.getConstant();
			if(constant == null){
				return new ResultMessage(Result.DATA_NOT_FOUND, null);
			} else {
				List<Double> costs = new ArrayList<Double>();
				costs.add(constant.getPricePlane());
				costs.add(constant.getPriceTrain());
				costs.add(constant.getPriceVan());
				return new ResultMessage(Result.SUCCESS, costs);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}
	}
	
	@Override
	public ResultMessage getFullLoad(){
		try {
			ConstantPO constant = dataSer.getConstant();
			if(constant == null){
				return new ResultMessage(Result.DATA_NOT_FOUND, null);
			} else {
				List<Double> load = new ArrayList<Double>();
				load.add(constant.getMaxLoadPlane());
				load.add(constant.getMaxLoadTrain());
				load.add(constant.getMaxLoadVan());
				return new ResultMessage(Result.SUCCESS, load);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}
	}
}
