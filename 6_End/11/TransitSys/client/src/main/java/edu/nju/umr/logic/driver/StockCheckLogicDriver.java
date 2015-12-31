package edu.nju.umr.logic.driver;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.logic.stockLogic.StockCheckLogic;
import edu.nju.umr.vo.order.StockInOutVO;
public class StockCheckLogicDriver {
	@SuppressWarnings("unchecked")
	public void drive(){
		StockCheckLogic l =new StockCheckLogic();
		ArrayList<StockInOutVO> sList =new ArrayList<StockInOutVO>();
		sList=(ArrayList<StockInOutVO>)l.orderStock(Calendar.getInstance(), Calendar.getInstance(), "!").getMessage();
		for(StockInOutVO v:sList){
			System.out.println(v.getTime().getTime());
		}
		
	}
	public static void main(String[] args){
		StockCheckLogicDriver d=new StockCheckLogicDriver();
		d.drive();
	}
}
