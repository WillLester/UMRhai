package edu.nju.umr.driver;

import java.util.Date;
import java.util.ArrayList;

import edu.nju.umr.logicService.orderNewLogic.*;
import edu.nju.umr.logic.orderNewLogic.*;
import edu.nju.umr.po.enums.GoodState;
import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.vo.order.*;
public class OrderNewDriver {
	private ArriveOrderLSer arrive=new ArriveOrderLogic();
	private CenterLoadingOrderLSer centerLoading=new CenterLoadingOrderLogic();
	private ExpressOrderLSer express=new ExpressOrderLogic();
	private HallLoadingOrderLSer hallLoading=new HallLoadingOrderLogic();
	private IncomeOrderLSer income=new IncomeOrderLogic();
	private PaymentOrderLSer payment=new PaymentOrderLogic();
	private ReceiveOrderLSer receive=new ReceiveOrderLogic();
	private RecipientOrderLSer recipient=new RecipientOrderLogic();
	private SendOrderLSer send=new SendOrderLogic();
	private StockInOrderLSer stockIn=new StockInOrderLogic();
	private StockOutOrderLSer stockOut=new StockOutOrderLogic();
	private TransitOrderLSer transit=new TransitOrderLogic();
	public static void main(String[] args)
	{
		OrderNewDriver driver=new OrderNewDriver();
		driver.driverArrive();
		driver.driverCenterLoading();
		driver.driverExpress();
		driver.driverHallLoading();
		driver.driverIncomeOrder();
		driver.driverPayment();
		driver.driverReceive();
		driver.driverRecipient();
		driver.driverSend();
		driver.driverStockIn();
		driver.driverStockOut();
		driver.driverTransit();
	}
	public void driverArrive(){
		System.out.println(arrive.create(new ArriveVO("1",new Date(),"1","南京",GoodState.INTACT)));
		ArrayList<String> ar=(ArrayList<String>)arrive.getCities().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	public void driverCenterLoading(){
		ArrayList<String> expresses=new ArrayList<String>();
		expresses.add("express1");
		expresses.add("express2");
		System.out.println(centerLoading.create(new CenterLoadingVO(new Date(),"1","北京","vanId","supervision","escort",expresses)));
		ArrayList<String> ar=(ArrayList<String>)centerLoading.getHalls().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	public void driverExpress(){
		System.out.println(express.create(new ExpressVO("Sender","SendLoc","Receiver","ReceiveLoc","SendMob","ReceiveMob",1,"Name",1,1,1,1,1,"ID",new Date(),Express.NORMAL,1)));
		
	}
	public void driverHallLoading(){
		ArrayList<String> expresses=new ArrayList<String>();
		expresses.add("express1");
		expresses.add("express2");
		System.out.println(hallLoading.create(new HallLoadingVO("HallID","conveID","arriveloc","vanId","Super","esc",expresses)));
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
		System.out.println(income.create(new IncomeVO(new Date(),"courier",1.5,expresses,"ID")));
		ArrayList<String> ar=(ArrayList<String>)income.getCouriers("").getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	public void driverPayment(){
		System.out.println(payment.create(new PaymentVO("ID",new Date(),"payer","acc",Pay.BONUS,10,"remarks")));
	}
	public void driverReceive(){
		System.out.println(receive.create(new ReceiveVO("expressID","receiver",new Date())));
		ExpressVO ex=(ExpressVO)receive.getExpress("").getMessage();
		System.out.println(ex.getSender()+" "+ex.getReceiver());
	}
	public void driverRecipient(){
		System.out.println(recipient.create(new RecipientVO(new Date(),"id","transitid","startp",GoodState.DAMAGED)));
		ArrayList<String> ar=(ArrayList<String>)recipient.getCities().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
		
	}
	public void driverSend(){
		System.out.println(send.create(new SendVO(new Date(),"expressid","id","name")));
		ArrayList<String> ar=(ArrayList<String>)send.getCouriers("").getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	public void driverStockIn(){
		System.out.println(stockIn.create(new StockInVO("id","expressID",new Date(),"arrp",Part.MANEUVER,"Shelfid",1,1)));
		ArrayList<String> ar=(ArrayList<String>)stockIn.getCities().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	public void driverStockOut(){
		System.out.println(stockOut.create(new StockOutVO("id","expressID",new Date(),Transit.PLANE,"transitid")));
		ArrayList<String> ar=(ArrayList<String>)stockOut.getCities().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	public void driverTransit(){
		ArrayList<String> expresses=new ArrayList<String>();
		expresses.add("express1");
		expresses.add("express2");
		System.out.println(transit.create(new TransitVO("id","planeid","sp","ap","cID","supv",expresses)));
		ArrayList<String> ar=(ArrayList<String>)transit.getCities().getMessage();
		for(int i=0;i<ar.size();i++){
			System.out.println(ar.get(i));
		}
	}
	

}