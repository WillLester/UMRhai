package edu.nju.umr.logic.userLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.LoginDFacSer;
import edu.nju.umr.dataService.userDSer.LoginDSer;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.userLogicSer.LoginLSer;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public class LoginLogic implements LoginLSer{
	private LoginDFacSer dataFac;
	private LoginDSer loginData;
	public LoginLogic() throws Exception{
		dataFac=(LoginDFacSer)Naming.lookup(Url.URL);
		loginData=dataFac.getLogin();
	}

	public ResultMessage login(String id, String password) {
		// TODO 自动生成的方法存根
		UserPO user;
		Result isSuc=Result.DATA_NOT_FOUND;
		Object message="username wrong or password wrong!";
		try {
			user = loginData.findUser(id, password);
			if(user!=null){
				isSuc=Result.SUCCESS;
				message=VPFactory.toUserVO(user);
			}
			return new ResultMessage(isSuc,message);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		} 
	}

}
