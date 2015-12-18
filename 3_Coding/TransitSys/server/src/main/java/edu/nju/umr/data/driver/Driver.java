package edu.nju.umr.data.driver;

public class Driver {
	public static void main(String[] args) {
		CountDriver cD = new CountDriver();
		cD.drive();
		BusiCircumDriver bcD = new BusiCircumDriver();
		bcD.drive();
	}
}
