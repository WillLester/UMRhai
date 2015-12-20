package edu.nju.umr.logic.driver;
import edu.nju.umr.logic.checkLogic.CostBeneLogic;
import edu.nju.umr.vo.CostBeneVO;
public class CostBeneLogicDriver {
	public void drive(){
		CostBeneLogic c=new CostBeneLogic();
		CostBeneVO cb=(CostBeneVO)c.getCostBene().getMessage();
		System.out.println(cb.getBenefit()+" "+cb.getIncome()+" "+cb.getPayment());
	}
	public static void main(String[] args){
		CostBeneLogicDriver d=new CostBeneLogicDriver();
		d.drive();
	}

}
