package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.ExpressOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.ExpressOrderDSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.ExpressOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ExpressVO;

public class ExpressOrderLogic implements ExpressOrderLSer{
	private ExpressOrderDFacSer dataFac;
	private ExpressOrderDSer expressData;
	private UtilityLogic uti;
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
	}
	public Result create(ExpressVO order,String org) {
		// TODO 自动生成的方法存根
		Result isSuc = Result.SUCCESS;
		try {
			isSuc=expressData.create(VPFactory.toExpressPO(order));
			if(isSuc.equals(Result.SUCCESS)){
				UpdateTransitInfoLogic.addInfo(order.getId(), DateFormat.TIME.format(Calendar.getInstance().getTime())+" " +org+"快递员 已收件");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return isSuc;
	}
	public String getPriceAndTime(String city1,String city2,int expressKind,int pakKind,double weight){
		String distance=uti.getDistance(city1, city2).toString();
		double dis=Double.parseDouble(distance);
		double wei=weight;
		ResultMessage message=uti.getExpressCost();
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS))
			return null;
		@SuppressWarnings("unchecked")
		ArrayList<Integer> pri= (ArrayList<Integer>)message.getMessage();
		double price=dis*(dis/1000*(pri.get(expressKind)))*wei;
		double []pakp=new double[]{5,10,1};
		price+=pakp[pakKind];
		int [][]timeCount=new int[][]{{0,100,1},{100,400,2},{400,900,3},{900,0x7fffffff,4}};
		double time=-1;
		for(int i=0;i<4;i++)
		{
			if(dis>timeCount[i][0]&&dis<=timeCount[i][1])
			{
				time=timeCount[i][2];
				break;
			}
		}
		return price+";"+time;
	}
}
