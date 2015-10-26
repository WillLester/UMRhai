package edu.nju.umr.driver;

import java.util.ArrayList;

import edu.nju.umr.logic.transitInfoLogic.CourierLogic;
import edu.nju.umr.logic.transitInfoLogic.CustomerLogic;
import edu.nju.umr.logicService.transitInfoLogicSer.CourierLSer;
import edu.nju.umr.logicService.transitInfoLogicSer.CustomerLogicSer;
import edu.nju.umr.vo.order.ExpressVO;

public class TransitInfoDriver {
	CourierLSer courier = new CourierLogic();
	CustomerLogicSer customer = new CustomerLogic();
	public static void main(String[] args) {
		TransitInfoDriver driver = new TransitInfoDriver();
		driver.driveCourier();
		driver.driveCustomer();
	}
	private void driveCourier(){
		ExpressVO express = (ExpressVO) courier.enterBarcodeCourier("123456").getMessage();
		System.out.println(express.getId() + " " + express.getSender() + " " + express.getSendLoc() + " " + express.getSendMobile() + " " + express.getReceiver() + " " + express.getReceiveLoc() + " " + express.getReceiveMobile() + " " + express.getCost() + " " + express.getHeight() + " " + express.getLength() + 
				" " + express.getWidth() + " " + express.getNum() + " " + express.getName() + " " + express.getArrive() + " " + express.getKind() + " " + express.getVolumn());
	}
	private void driveCustomer(){
		ArrayList<String> info = (ArrayList<String>) customer.enterBarcodeCustomer("123455").getMessage();
		for(String tInfo:info){
			System.out.println(tInfo);
		}
	}
}
