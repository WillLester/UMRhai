package edu.nju.umr.logic.driver;
import edu.nju.umr.logic.workOrgManLogic.VanManLogic;
public class VanManLogicDriver {
	public void drive(){
		VanManLogic l=new VanManLogic();
		System.out.println(l.getNextId("").getMessage());
	}
	public static void main(String[] args){
		VanManLogicDriver d= new VanManLogicDriver();
		d.drive();
	}

}
