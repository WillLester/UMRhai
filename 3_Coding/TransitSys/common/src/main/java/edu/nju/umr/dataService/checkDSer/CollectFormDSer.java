package edu.nju.umr.dataService.checkDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.po.order.IncomePO;

public interface CollectFormDSer extends Remote{
	public ArrayList<IncomePO> getCollectRec(Date date,String id) throws RemoteException;
	
}
