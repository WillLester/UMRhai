package edu.nju.umr.dataService.checkDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.po.order.CollectPO;

public interface CollectFormDSer extends Remote{
	public ArrayList<CollectPO> findCollect(Date start,Date end) throws RemoteException;
	
}
