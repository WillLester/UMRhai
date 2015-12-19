package edu.nju.umr.data.stub;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.dataService.checkDSer.BusiCircumDSer;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;

public class BusiCircumDataStub implements BusiCircumDSer{

	@Override
	public ArrayList<IncomePO> findIncome(Calendar start, Calendar end)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<IncomePO> incomes = new ArrayList<IncomePO>();
		ArrayList<String> express = new ArrayList<String>();
		express.add("1123314231");
		IncomePO in = new IncomePO(start, "徐嘉诰", new BigDecimal(100), express, "0250002015121500000", start, "香港记者", "025000", "baohua", "excited");
		incomes.add(in);
		return incomes;
	}

	@Override
	public ArrayList<PaymentPO> findPayment(Calendar start, Calendar end)
			throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<PaymentPO> payments = new ArrayList<PaymentPO>();
		PaymentPO pay = new PaymentPO("0250002015121500000", end, "张钟俊", "excited", Pay.BONUS, new BigDecimal(50), "", end, "张钟俊", "profZhang");
		payments.add(pay);
		return payments;
	}

}
