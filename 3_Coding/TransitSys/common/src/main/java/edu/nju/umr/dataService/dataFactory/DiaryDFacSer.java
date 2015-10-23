package edu.nju.umr.dataService.dataFactory;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.checkDSer.DiaryDSer;

public interface DiaryDFacSer extends Remote{
	public DiaryDSer getDiary() throws RemoteException;
}
