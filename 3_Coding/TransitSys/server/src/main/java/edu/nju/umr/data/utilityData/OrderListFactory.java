package edu.nju.umr.data.utilityData;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.po.order.KindGetter;

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
}
