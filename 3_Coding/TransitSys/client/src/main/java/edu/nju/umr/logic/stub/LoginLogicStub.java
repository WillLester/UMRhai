package edu.nju.umr.logic.stub;
import java.rmi.RemoteException;

import edu.nju.umr.dataService.userDSer.LoginDSer;
import edu.nju.umr.po.UserPO;
public class LoginLogicStub implements LoginDSer{

	@Override
	public UserPO findUser(String id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
//		return new UserPO(password, password, Jurisdiction.ADMIN, password, password, password, 0, password);
	}

}
