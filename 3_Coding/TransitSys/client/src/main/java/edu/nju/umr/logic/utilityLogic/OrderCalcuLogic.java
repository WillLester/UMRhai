package edu.nju.umr.logic.utilityLogic;

import edu.nju.umr.constants.Url;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.nju.umr.dataService.dataFactory.utility.OrderCalcuDFacSer;
import edu.nju.umr.dataService.utilityDSer.OrderCalcuDSer;
import edu.nju.umr.logicService.utilityLogicSer.ConstantGetLSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderCalcuLSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.logicService.utilityLogicSer.UtilityLSer;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.vo.ResultMessage;

public class OrderCalcuLogic implements OrderCalcuLSer{
	private OrderCalcuDFacSer dataFac;
	private OrderCalcuDSer dataSer;
	private UtilityLSer uti;
	private ConstantGetLSer constantLSer;
	private OrderInfoLSer orderInfo;
	public OrderCalcuLogic() {
		// TODO 自动生成的构造函数存根
		try {
			dataFac = (OrderCalcuDFacSer)Naming.lookup(Url.URL);
			dataSer = dataFac.getOrderCalcu();
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
		uti = new UtilityLogic();
		constantLSer = new ConstantGetLogic();
		orderInfo = new OrderInfoLogic();
	}
	
	@Override
	public BigDecimal getDistance(String city1,String city2){
		CitiesPO cities = null;
		try {
			cities = dataSer.getCitesPO(city1, city2);
			if(cities == null){
				return new BigDecimal(0);
			} else {
				return new BigDecimal(cities.getDistance());
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
	}
	
	@Override
	public ResultMessage getPrice(String org1, String org2,Transit transit,List<String> expressList) {
		String city1=null;
		String city2=null;//两个机构所属城市名称
		List<OrgPO> orgs=new ArrayList<OrgPO>();//获取机构列表
		BigDecimal distance= new BigDecimal(0);//城市间距离
		BigDecimal price = new BigDecimal(0);//城市间价格
		ResultMessage costMessage = constantLSer.getTransitCost();
		if(!costMessage.getReInfo().equals(Result.SUCCESS)){
			return costMessage;
		}
		@SuppressWarnings("unchecked")
		ArrayList<BigDecimal> temp=(ArrayList<BigDecimal>)costMessage.getMessage();
		price = temp.get(transit.ordinal());
		orgs = uti.orgs();
		if(orgs == null){
			return new ResultMessage(Result.DATA_NOT_FOUND, null);
		}
		//获得两个机构所在城市名称
		for(OrgPO po:orgs){
			if(po.getName().equals(org1)){
				city1=po.getCity();
				break;
			}
		}
		for(OrgPO po:orgs){
			if(po.getName().equals(org2)){
				city2=po.getCity();
			    break;
			}
		}
		//两机构在同一城市
		if(city1.equals(city2)){
			distance = new BigDecimal(100);//固定值暂定为100
		} else {
		//不在同一城市
			try{
				distance= getDistance(city1, city2);
			}catch(Exception e){
				return new ResultMessage(Result.NET_INTERRUPT,null);
			}
		}
		List<ExpressPO> expresses = orderInfo.getExpresses(expressList);
		BigDecimal weight = new BigDecimal(0);
		for(ExpressPO express:expresses){
			weight = weight.add(new BigDecimal(express.getWeight()));
		}
		// 划为吨计算
		weight = weight.divide(new BigDecimal(1000));
		ResultMessage load = constantLSer.getFullLoad();
		if(load.getReInfo().equals(Result.SUCCESS)){
			@SuppressWarnings("unchecked")
			List<BigDecimal> loads = (List<BigDecimal>) load.getMessage();
			BigDecimal fullLoad = loads.get(transit.ordinal());
			// 超出满载量，返回错误
			if(weight.compareTo(fullLoad) == 1){
				return new ResultMessage(Result.OUT_OF_LOAD, null);
			}
		} else {
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}
		return new ResultMessage(Result.SUCCESS, distance.multiply(price).multiply(weight));
	}
}
