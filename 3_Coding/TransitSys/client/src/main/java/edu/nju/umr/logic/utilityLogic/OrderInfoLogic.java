package edu.nju.umr.logic.utilityLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.utility.OrderInfoDFacSer;
import edu.nju.umr.dataService.utilityDSer.OrderInfoDSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.po.order.ExpressPO;

public class OrderInfoLogic implements OrderInfoLSer{
	private OrderInfoDFacSer dataFac;
	private OrderInfoDSer dataSer;
	
	public OrderInfoLogic() {
		// TODO 自动生成的构造函数存根
		try {
			dataFac = (OrderInfoDFacSer) Naming.lookup(Url.URL);
			dataSer = dataFac.getOrderInfo();
		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	@Override
	public boolean isTransitValid(String id){
		try {
			return dataSer.isTransitValid(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}
	
	@Override
	public boolean isExpressValid(String id){
		try {
			return dataSer.isExpressValid(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}

	@Override
	public boolean isCenterLoadValid(String id){
		try {
			return dataSer.isCenterLoadValid(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}

	@Override
	public int isExpressListValid(List<String> expressList) {
		// TODO 自动生成的方法存根
		for(int i = 0;i < expressList.size();i++){
			if(!isExpressValid(expressList.get(i))){
				return i;
			}
		}
		return -1;
	}

	@Override
	public List<String> getTransitExp(String id) {
		// TODO 自动生成的方法存根
		try {
			return dataSer.getTransitExp(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ArrayList<String>();
		}
	}

	@Override
	public List<String> getHallLoadExp(String id) {
		// TODO 自动生成的方法存根
		try {
			return dataSer.getHallLoadExp(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ArrayList<String>();
		}
	}

	@Override
	public List<ExpressPO> getExpresses(List<String> expressList) {
		// TODO 自动生成的方法存根
		try {
			return dataSer.getExpresses(expressList);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ArrayList<ExpressPO>();
		}
	}
}
