package edu.nju.umr.dataService.checkDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;

public interface BusiCircumDSer extends Remote{
	public ArrayList<IncomePO> findIncome(Calendar start,Calendar end) throws RemoteException;
//	public ArrayList<OrgPO> getHall() throws RemoteException;
	public ArrayList<PaymentPO> findPayment(Calendar start,Calendar end) throws RemoteException;
	
}
