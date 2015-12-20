package edu.nju.umr.logic.stub;
import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.dataService.checkDSer.CostBeneDSer;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;
public class CostBeneLogicStub implements CostBeneDSer{

	@Override
	public ArrayList<IncomePO> getIncomes() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<IncomePO> ar= new ArrayList<IncomePO>();
		ArrayList<String> express=new ArrayList<String>();
		express.add("1000000000");
		ar.add(new IncomePO(Calendar.getInstance(), "徐嘉诰", new BigDecimal(100), express, "0250002015121500000", Calendar.getInstance(), "香港记者", "025000", "baohua", "excited"));
		return ar;
	}

	@Override
	public ArrayList<PaymentPO> getPayments() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<PaymentPO> payments = new ArrayList<PaymentPO>();
		PaymentPO pay = new PaymentPO("0250002015121500000", Calendar.getInstance(), "张钟俊", "excited", Pay.BONUS, new BigDecimal(50), "", Calendar.getInstance(), "张钟俊", "profZhang");
		payments.add(pay);
		return payments;
	}

}
