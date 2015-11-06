package edu.nju.umr.driver;

import java.util.ArrayList;

import edu.nju.umr.logic.orderApproveLogic.OrderApproveLogic;
import edu.nju.umr.logic.orderApproveLogic.OrderResubmitLogic;
import edu.nju.umr.logicService.orderApproveLogicSer.OrderApproveLSer;
import edu.nju.umr.logicService.orderApproveLogicSer.OrderResubmitLSer;
import edu.nju.umr.vo.order.OrderVO;
import edu.nju.umr.vo.order.PaymentVO;

public class OrderApproveDriver {
	OrderApproveLSer approve = new OrderApproveLogic();
	OrderResubmitLSer resubmit = new OrderResubmitLogic();
	public static void main(String[] args) {
		OrderApproveDriver driver = new OrderApproveDriver();
		driver.driveApprove();
		driver.driveResubmit();
	}
	private void driveApprove(){
		@SuppressWarnings("unchecked")
		ArrayList<OrderVO> orders = (ArrayList<OrderVO>) approve.askExamine().getMessage();
		for(OrderVO vo:orders){
			System.out.println(vo.getOperator() + " " + vo.getId() + " "  + vo.getKind() + "　" + vo.getTime());
		}
		System.out.println(approve.examine(true, null));
		PaymentVO pay = (PaymentVO) approve.chooseOrder("00001").getMessage();
		System.out.println(pay.getId() + " " + pay.getPayer() + " " + pay.getAccount() + " " + pay.getAmount() + " " + pay.getDate() + " " + pay.getKind() + " " + pay.getRemarks());
	}
	private void driveResubmit(){
		@SuppressWarnings("unchecked")
		ArrayList<Object> getOrders = (ArrayList<Object>) resubmit.getOrders("00001").getMessage();
		for(Object order:getOrders){
			PaymentVO pay = (PaymentVO)order;
			System.out.println(pay.getId() + " " + pay.getPayer() + " " + pay.getAccount() + " " + pay.getAmount() + " " + pay.getDate() + " " + pay.getKind() + " " + pay.getRemarks());
		}
	}
}
