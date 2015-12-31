package edu.nju.umr.dataService.checkDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.po.order.IncomePO;
/**
 * 查看收款记录
 * @author Lester
 * @see CollectRecordData
 */
public interface IncomeListDSer extends Remote{
	public ArrayList<IncomePO> getCollectRec(Calendar date,String id) throws RemoteException;
}
