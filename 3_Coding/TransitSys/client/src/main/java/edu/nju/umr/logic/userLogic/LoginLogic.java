package edu.nju.umr.logic.userLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.LoginDFacSer;
import edu.nju.umr.dataService.userDSer.LoginDSer;
import edu.nju.umr.logicService.userLogicSer.LoginLSer;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;

public class LoginLogic implements LoginLSer{
	LoginDFacSer dataFac;
	LoginDSer loginData;
	public LoginLogic() throws Exception{
		dataFac=(LoginDFacSer)Naming.lookup(Url.URL);
		loginData=dataFac.getLogin();
	}

	public ResultMessage login(String id, String password) {
		// TODO 自动生成的方法存根
		UserPO user;
		try {
			user = loginData.findUser(id, password);
			return new ResultMessage(Result.SUCCESS,new UserVO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrg(),user.getOrgId()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
	}

}
