package edu.nju.umr.driver;

import edu.nju.umr.logic.utilityLogic.UtilityLogic;

public class UtilityDriver {
	UtilityLogic uti=new UtilityLogic();
	public static void main(String[] args){
		UtilityDriver dr=new UtilityDriver();
		System.out.println(dr.uti.getCities().getReInfo());
		System.out.println(dr.uti.getOrgs().getReInfo());
		System.out.println(dr.uti.getStocks().getReInfo());
		System.out.println(dr.uti.getVans("").getReInfo());
		System.out.println(dr.uti.getWorkers("").getReInfo());
	}

}
