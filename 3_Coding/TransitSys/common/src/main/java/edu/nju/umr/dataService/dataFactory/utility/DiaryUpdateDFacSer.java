package edu.nju.umr.dataService.dataFactory.utility;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.utilityDSer.DiaryUpdateDSer;

public interface DiaryUpdateDFacSer extends Remote{
	public DiaryUpdateDSer getDiaryUpdate() throws RemoteException;
}
