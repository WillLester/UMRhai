package edu.nju.umr.data.utilityData;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.KindGetter;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.po.order.TransitPO;

public class OrderListFactory {
	public static ArrayList<KindGetter> produceArrive(ResultSet result){
		ArrayList<KindGetter> list = new ArrayList<KindGetter>();
		ArrivePO arrive = OrderPOFactory.getArrive(result);
		while(arrive != null){
			list.add(arrive);
			arrive = OrderPOFactory.getArrive(result);
		}
		return list;
	}
	
	public static ArrayList<KindGetter> produceCenterLoad(ResultSet result){
		ArrayList<KindGetter> list = new ArrayList<KindGetter>();
		CenterLoadingPO centerLoad = OrderPOFactory.getCenterLoad(result);
		while (centerLoad != null){
			list.add(centerLoad);
			centerLoad = OrderPOFactory.getCenterLoad(result);
		}
		return list;
	}
	
	public static ArrayList<KindGetter> produceExpress(ResultSet result){
		ArrayList<KindGetter> list = new ArrayList<KindGetter>();
		ExpressPO express = OrderPOFactory.getExpress(result);
		while (express != null){
			list.add(express);
			express = OrderPOFactory.getExpress(result);
		}
		return list;
	}
	
	public static ArrayList<KindGetter> produceHallLoad(ResultSet result){
		ArrayList<KindGetter> list = new ArrayList<KindGetter>();
		HallLoadingPO hallLoad = OrderPOFactory.getHallLoad(result);
		while (hallLoad != null){
			list.add(hallLoad);
			hallLoad = OrderPOFactory.getHallLoad(result);
		}
		return list;
	}
	
	public static ArrayList<KindGetter> produceIncome(ResultSet result){
		ArrayList<KindGetter> list = new ArrayList<KindGetter>();
		IncomePO income = OrderPOFactory.getIncome(result);
		while(income != null){
			list.add(income);
			income = OrderPOFactory.getIncome(result);
		}
		return list;
	}
	
	public static ArrayList<KindGetter> producePayment(ResultSet result){
		ArrayList<KindGetter> list = new ArrayList<KindGetter>();
		PaymentPO payment = OrderPOFactory.getPayment(result);
		while(payment != null){
			list.add(payment);
			payment = OrderPOFactory.getPayment(result);
		}
		return list;
	}
	
	public static ArrayList<KindGetter> produceRecipient(ResultSet result){
		ArrayList<KindGetter> list = new ArrayList<KindGetter>();
		RecipientPO recipient = OrderPOFactory.getRecipient(result);
		while(recipient != null){
			list.add(recipient);
			recipient = OrderPOFactory.getRecipient(result);
		}
		return list;
	}
	
	public static ArrayList<KindGetter> produceSend(ResultSet result){
		ArrayList<KindGetter> list = new ArrayList<KindGetter>();
		SendPO send = OrderPOFactory.getSend(result);
		while(send != null){
			list.add(send);
			send = OrderPOFactory.getSend(result);
		}
		return list;
	}
	
	public static ArrayList<KindGetter> produceStockIn(ResultSet result){
		ArrayList<KindGetter> list = new ArrayList<KindGetter>();
		StockInPO stockIn = OrderPOFactory.getStockIn(result);
		while(stockIn != null){
			list.add(stockIn);
			stockIn = OrderPOFactory.getStockIn(result);
		}
		return list;
	}
	
	public static ArrayList<KindGetter> produceStockOut(ResultSet result){
		ArrayList<KindGetter> list = new ArrayList<KindGetter>();
		StockOutPO stockOut = OrderPOFactory.getStockOut(result);
		while(stockOut != null){
			list.add(stockOut);
			stockOut = OrderPOFactory.getStockOut(result);
		}
		return list;
	}
	
	public static ArrayList<KindGetter> produceTransit(ResultSet result){
		ArrayList<KindGetter> list = new ArrayList<KindGetter>();
		TransitPO transit = OrderPOFactory.getTransit(result);
		while(transit != null){
			list.add(transit);
			transit = OrderPOFactory.getTransit(result);
		}
		return list;
	}
}
