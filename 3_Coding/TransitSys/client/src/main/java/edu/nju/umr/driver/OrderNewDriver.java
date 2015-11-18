package edu.nju.umr.driver;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.logic.orderNewLogic.ArriveOrderLogic;
import edu.nju.umr.logic.orderNewLogic.CenterLoadingOrderLogic;
import edu.nju.umr.logic.orderNewLogic.ExpressOrderLogic;
import edu.nju.umr.logic.orderNewLogic.HallLoadingOrderLogic;
import edu.nju.umr.logic.orderNewLogic.IncomeOrderLogic;
import edu.nju.umr.logic.orderNewLogic.PaymentOrderLogic;
import edu.nju.umr.logic.orderNewLogic.RecipientOrderLogic;
import edu.nju.umr.logic.orderNewLogic.SendOrderLogic;
import edu.nju.umr.logic.orderNewLogic.StockInOrderLogic;
import edu.nju.umr.logic.orderNewLogic.StockOutOrderLogic;
import edu.nju.umr.logic.orderNewLogic.TransitOrderLogic;
import edu.nju.umr.logic.orderNewLogic.UpdateTransitInfoLogic;
import edu.nju.umr.logicService.orderNewLogic.ArriveOrderLSer;
import edu.nju.umr.logicService.orderNewLogic.CenterLoadingOrderLSer;
import edu.nju.umr.logicService.orderNewLogic.ExpressOrderLSer;
import edu.nju.umr.logicService.orderNewLogic.HallLoadingOrderLSer;
import edu.nju.umr.logicService.orderNewLogic.IncomeOrderLSer;
import edu.nju.umr.logicService.orderNewLogic.PaymentOrderLSer;
import edu.nju.umr.logicService.orderNewLogic.RecipientOrderLSer;
import edu.nju.umr.logicService.orderNewLogic.SendOrderLSer;
import edu.nju.umr.logicService.orderNewLogic.StockInOrderLSer;
import edu.nju.umr.logicService.orderNewLogic.StockOutOrderLSer;
import edu.nju.umr.logicService.orderNewLogic.TransitOrderLSer;
import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.GoodState;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.vo.order.ArriveVO;
import edu.nju.umr.vo.order.CenterLoadingVO;
import edu.nju.umr.vo.order.ExpressVO;
import edu.nju.umr.vo.order.HallLoadingVO;
import edu.nju.umr.vo.order.IncomeVO;
import edu.nju.umr.vo.order.PaymentVO;
import edu.nju.umr.vo.order.RecipientVO;
import edu.nju.umr.vo.order.SendVO;
import edu.nju.umr.vo.order.StockInVO;
import edu.nju.umr.vo.order.StockOutVO;
import edu.nju.umr.vo.order.TransitVO;
public class OrderNewDriver {
	private ArriveOrderLSer arrive=new ArriveOrderLogic();
	private CenterLoadingOrderLSer centerLoading=new CenterLoadingOrderLogic();
	private ExpressOrderLSer express=new ExpressOrderLogic();
	private HallLoadingOrderLSer hallLoading=new HallLoadingOrderLogic();
	private IncomeOrderLSer income=new IncomeOrderLogic();
	private PaymentOrderLSer payment=new PaymentOrderLogic();
	private RecipientOrderLSer recipient=new RecipientOrderLogic();
	private SendOrderLSer send=new SendOrderLogic();
	private StockInOrderLSer stockIn=new StockInOrderLogic();
	private StockOutOrderLSer stockOut=new StockOutOrderLogic();
	private TransitOrderLSer transit=new TransitOrderLogic();
	public static void main(String[] args)
	{
		OrderNewDriver driver=new OrderNewDriver();
		System.out.println(UpdateTransitInfoLogic.update("1", "2"));
//		driver.driverArrive();
//		driver.driverCenterLoading();
//		driver.driverExpress();
//		driver.driverHallLoading();
//		driver.driverIncomeOrder();
//		driver.driverPayment();
//		driver.driverRecipient();
//		driver.driverSend();
//		driver.driverStockIn();
//		driver.driverStockOut();
//		driver.driverTransit();
	}
	public void driverArrive(){
		System.out.println(arrive.create(new ArriveVO("1",Calendar.getInstance(),"南京",GoodState.INTACT)));
		@SuppressWarnings("unchecked")
		ArrayList<String> ar=(ArrayList<String>)arrive.getCities().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	public void driverCenterLoading(){
		ArrayList<String> expresses=new ArrayList<String>();
		expresses.add("express1");
		expresses.add("express2");
		System.out.println(centerLoading.create(new CenterLoadingVO(Calendar.getInstance(),"北京","vanId","supervision","escort",expresses,100)));
		ArrayList<String> ar=(ArrayList<String>)centerLoading.getHalls().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	public void driverExpress(){
		System.out.println(express.create(new ExpressVO("Sender","SendLoc","Receiver","ReceiveLoc","SendMob","ReceiveMob",null,null,null,null,1,"Name",1,1,1,1,1,Calendar.getInstance(),Express.NORMAL,1)));
		
	}
	public void driverHallLoading(){
		ArrayList<String> expresses=new ArrayList<String>();
		expresses.add("express1");
		expresses.add("express2");
		System.out.println(hallLoading.create(new HallLoadingVO("HallID","conveID","arriveloc","vanId","Super","esc",expresses,100)));
		ArrayList<String> ar=(ArrayList<String>)hallLoading.getOrgs().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
		ar=(ArrayList<String>)hallLoading.getVans().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	public void driverIncomeOrder(){
		ArrayList<String> expresses=new ArrayList<String>();
		expresses.add("express1");
		expresses.add("express2");
		System.out.println(income.create(new IncomeVO(Calendar.getInstance(),"courier",1.5,expresses)));
		ArrayList<String> ar=(ArrayList<String>)income.getCouriers("").getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	public void driverPayment(){
		System.out.println(payment.create(new PaymentVO(Calendar.getInstance(),"payer","acc",Pay.BONUS,10,"remarks")));
	}
	public void driverRecipient(){
		System.out.println(recipient.create(new RecipientVO(Calendar.getInstance(),"transitid","startp",GoodState.DAMAGED)));
		ArrayList<String> ar=(ArrayList<String>)recipient.getCities().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
		
	}
	public void driverSend(){
		System.out.println(send.create(new SendVO(Calendar.getInstance(),"expressid","name")));
		ArrayList<String> ar=(ArrayList<String>)send.getCouriers("").getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	public void driverStockIn(){
		System.out.println(stockIn.create(new StockInVO("expressID",Calendar.getInstance(),"arrp",Part.MANEUVER,"Shelfid",1,1)));
		ArrayList<String> ar=(ArrayList<String>)stockIn.getCities().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	public void driverStockOut(){
		System.out.println(stockOut.create(new StockOutVO("expressID",Calendar.getInstance(),Transit.PLANE,"transitid")));
		ArrayList<String> ar=(ArrayList<String>)stockOut.getCities().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	public void driverTransit(){
		ArrayList<String> expresses=new ArrayList<String>();
		expresses.add("express1");
		expresses.add("express2");
		System.out.println(transit.create(new TransitVO("planeid","sp","ap","cID","supv",expresses)));
		ArrayList<String> ar=(ArrayList<String>)transit.getCities().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	

}