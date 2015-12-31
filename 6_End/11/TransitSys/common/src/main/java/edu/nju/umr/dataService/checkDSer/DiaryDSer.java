package edu.nju.umr.dataService.checkDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.po.DiaryPO;
/**
 * 查看日志
 * @author WillLester
 * @see DiaryData
 */
public interface DiaryDSer extends Remote{
	public ArrayList<DiaryPO> seeDiary(Calendar start, Calendar end) throws RemoteException;
	
}
