package edu.nju.umr.logic.driver;
import edu.nju.umr.logic.utilityLogic.ConstantGetLogic;
import edu.nju.umr.vo.ResultMessage;
public class ConstantGetLogicDriver {
	public void drive(){
		ConstantGetLogic l=new ConstantGetLogic();
		ResultMessage m=l.getFullLoad();
		System.out.println(m.getMessage());
	}
	public static void main(String[] args){
		ConstantGetLogicDriver d=new ConstantGetLogicDriver();
		d.drive();
	}

}
