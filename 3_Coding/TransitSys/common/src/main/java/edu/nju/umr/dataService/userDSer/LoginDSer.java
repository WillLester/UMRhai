package edu.nju.umr.dataService.userDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import edu.nju.umr.po.UserPO;

public interface LoginDSer extends Remote{
	public UserPO findUser(String id) throws RemoteException;
}
