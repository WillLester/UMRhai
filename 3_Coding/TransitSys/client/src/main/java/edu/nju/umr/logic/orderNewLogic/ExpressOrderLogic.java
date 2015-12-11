package edu.nju.umr.logic.orderNewLogic;

import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.ExpressOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.ExpressOrderDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.ExpressOrderLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.utilityLogicSer.UtilityLSer;
import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.Parse;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ExpressVO;

public class ExpressOrderLogic implements ExpressOrderLSer{
	private ExpressOrderDFacSer dataFac;
	private ExpressOrderDSer expressData;
	private UtilityLSer uti;
	private DiaryUpdateLSer diarySer;
	public ExpressOrderLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (ExpressOrderDFacSer)Naming.lookup(Url.URL);
			expressData = dataFac.getExpressOrder();
			uti=new UtilityLogic();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		diarySer = new DiaryUpdateLogic();
	}
	public Result create(ExpressVO order) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.SUCCESS;
		try {
			isSuc=expressData.create(VPFactory.toExpressPO(order));
			if(isSuc.equals(Result.SUCCESS)){
				isSuc = diarySer.addDiary("生成快递单"+order.getId(), order.getOpName());
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return isSuc;
	}
	public String getPrice(String city1,String city2,Express expressKind,Parse pakKind,double weight){
		//获得城市之间的距离
		BigDecimal distance = new BigDecimal(0);
		if(city1.equals(city2)){
			distance = new BigDecimal(100);
		} else {
			distance=uti.getDistance(city1, city2);
		}
		//获得快递价格
		ResultMessage message=uti.getExpressCost();
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
			return null;
		@SuppressWarnings("unchecked")
		ArrayList<Double> pri= (ArrayList<Double>)message.getMessage();
		BigDecimal price = distance;
		price=price.divide(new BigDecimal(1000));
		price=price.multiply(new BigDecimal(pri.get(expressKind.ordinal())));
		price=price.multiply(new BigDecimal(weight));
		double []pakp=new double[]{5,10,1};
		price.add(new BigDecimal(pakp[pakKind.ordinal()]));
		price  = price.setScale(0, BigDecimal.ROUND_HALF_UP);
		return price.toString();
	}
	
	@Override
	public int getTime(String city1,String city2)
	{
		BigDecimal distance=uti.getDistance(city1, city2);
		int [][]timeCount=new int[][]{{0,100,1},{100,400,2},{400,900,3},{900,0x7fffffff,4}};
		int time=0;
		for(int i=0;i<4;i++)
		{
			if(distance.compareTo(new BigDecimal(timeCount[i][0]))>0&&distance.compareTo(new BigDecimal(timeCount[i][1]))<=0)
			{
				time=timeCount[i][2];
				break;
			}
		}
		return time;
	}
}
