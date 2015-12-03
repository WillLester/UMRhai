package edu.nju.umr.data.utilityData;

import java.sql.ResultSet;

import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.po.order.TransitPO;

public class OrderPOFactory {
	public static ArrivePO getArrive(ResultSet result){
		return null;
	}
	public static CenterLoadingPO getCenterLoad(ResultSet result){
		return null;
	}
	public static ExpressPO getExpress(ResultSet result){
		return null;
	}
	public static HallLoadingPO getHallLoad(ResultSet result){
		return null;
	}
	public static IncomePO getIncome(ResultSet result){
		return null;
	}
	public static PaymentPO getPayment(ResultSet result){
		return null;
	}
	public static RecipientPO getRecipient(ResultSet result){
		return null;
	}
	public static SendPO getSend(ResultSet result){
		return null;
	}
	public static StockInPO getStockIn(ResultSet result){
		return null;
	}
	public static StockOutPO getStockOut(ResultSet result){
		return null;
	}
	public static TransitPO getTransit(ResultSet result){
		return null;
	}
}
