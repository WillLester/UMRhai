package edu.nju.umr.logic.driver;
import edu.nju.umr.logic.orderApproveLogic.OrderApproveLogic;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ArriveVO;
public class OrderApproveLogicDriver {
	public void drive(){
		OrderApproveLogic l =new OrderApproveLogic();
		ResultMessage message=l.chooseOrder("0", Order.ARRIVE);
		ArriveVO vo=(ArriveVO)message.getMessage();
		System.out.println(vo.getState());
	}
	public static void main(String[] args){
		OrderApproveLogicDriver d=new OrderApproveLogicDriver();
		d.drive();
	}

}
