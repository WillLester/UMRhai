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
		UpdateTransInfoDriver utD = new UpdateTransInfoDriver();
		utD.drive();
		StockCheckNowDriver scnD = new StockCheckNowDriver();
		scnD.drive();
		CustomerDriver cusD = new CustomerDriver();
		cusD.drive();
		UserManDriver umD = new UserManDriver();
		umD.drive();
		AccountUpdateDriver auD = new AccountUpdateDriver();
		auD.drive();
		DiaryUpdateDriver duD = new DiaryUpdateDriver();
		duD.drive();
		OrderCalcuDriver ocD = new OrderCalcuDriver();
		ocD.drive();
		OrderInfoDriver oiD = new OrderInfoDriver();
		oiD.drive();
		UtilityDriver uD = new UtilityDriver();
		uD.drive();
		VanManDriver vmD = new VanManDriver();
		vmD.drive();
	}
}
