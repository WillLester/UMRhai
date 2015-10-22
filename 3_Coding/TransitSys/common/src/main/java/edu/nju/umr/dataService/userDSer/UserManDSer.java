package edu.nju.umr.dataService.userDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.po.UserPO;

public interface UserManDSer extends Remote{
	public UserPO findUser(String id) throws RemoteException;
	public boolean addUser(UserPO user) throws RemoteException;
	public boolean deleteUser(String id) throws RemoteException;
	public boolean reviseUser(UserPO user) throws RemoteException;
	public ArrayList<UserPO> userList() throws RemoteException;
}
