package edu.nju.umr.dataService.checkDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.order.IncomePO;

public interface BusiCircumDSer extends Remote{
	public ArrayList<IncomePO> findCollect(Date start,Date end) throws RemoteException;
	public ArrayList<OrgPO> getHall() throws RemoteException;
}
