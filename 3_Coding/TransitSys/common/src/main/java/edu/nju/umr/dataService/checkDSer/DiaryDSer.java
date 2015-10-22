package edu.nju.umr.dataService.checkDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.po.DiaryPO;

public interface DiaryDSer extends Remote{
	public ArrayList<DiaryPO> seeDiary(Date start, Date end) throws RemoteException;
	
}
