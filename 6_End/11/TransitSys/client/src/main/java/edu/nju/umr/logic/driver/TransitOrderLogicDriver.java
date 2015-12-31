package edu.nju.umr.logic.driver;
import edu.nju.umr.logic.orderNewLogic.TransitOrderLogic;
import edu.nju.umr.vo.ResultMessage;
public class TransitOrderLogicDriver {
	public void drive(){
		TransitOrderLogic t=new TransitOrderLogic();
		ResultMessage r=t.getNextId("1");
		int i=(Integer)r.getMessage();
		System.out.println(i);
	}
	public static void main(String[] args){
		TransitOrderLogicDriver t=new TransitOrderLogicDriver();
		t.drive();
	}

}
