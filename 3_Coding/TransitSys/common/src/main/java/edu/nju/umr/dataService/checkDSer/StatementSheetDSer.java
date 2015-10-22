package edu.nju.umr.dataService.checkDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.order.CollectPO;

public interface StatementSheetDSer extends Remote{
	public ArrayList<CollectPO> getCollectRec(Date date,String id) throws RemoteException;
	public ArrayList<OrgPO> getHall() throws RemoteException;
}
