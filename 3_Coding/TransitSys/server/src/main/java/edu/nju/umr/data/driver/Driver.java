package edu.nju.umr.data.driver;

public class Driver {
	public static void main(String[] args) {
		CountDriver cD = new CountDriver();
		cD.drive();
		BusiCircumDriver bcD = new BusiCircumDriver();
		bcD.drive();
		IncomeListDriver ilD = new IncomeListDriver();
		ilD.drive();
		CityDriver cityD = new CityDriver();
		cityD.drive();
		OrderApproveDriver oaD = new OrderApproveDriver();
		oaD.drive();
		OrderResubmitDriver orD = new OrderResubmitDriver();
		orD.drive();
		CenterLoadDriver clD = new CenterLoadDriver();
		clD.drive();
	}
}
