package edu.nju.umr.dataService.userDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.enums.Result;

public interface UserManDSer extends Remote{
	public ArrayList<UserPO> findUser(String keyword) throws RemoteException;
	public Result addUser(UserPO user) throws RemoteException;
	public Result deleteUser(String id) throws RemoteException;
	public Result reviseUser(UserPO user) throws RemoteException;
}
