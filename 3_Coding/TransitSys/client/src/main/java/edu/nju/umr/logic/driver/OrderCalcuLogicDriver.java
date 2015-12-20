package edu.nju.umr.logic.driver;
import java.math.BigDecimal;
import java.util.ArrayList;

import edu.nju.umr.logic.utilityLogic.OrderCalcuLogic;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.vo.ResultMessage;
public class OrderCalcuLogicDriver {
	public void drive(){
		OrderCalcuLogic l=new OrderCalcuLogic();
		BigDecimal m =l.getDistance("1", "2");
		System.out.println(m);
		ArrayList<String> ar=new ArrayList<String>();
		ar.add("1000000000");
		ResultMessage r=l.getPrice("1", "2", Transit.PLANE, ar);
		System.out.println(r.getMessage());
	}
	public static void main(String[] args){
		OrderCalcuLogicDriver d=new OrderCalcuLogicDriver();
		d.drive();
	}

}
