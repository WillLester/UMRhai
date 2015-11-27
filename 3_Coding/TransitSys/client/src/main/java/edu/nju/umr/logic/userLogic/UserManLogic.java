package edu.nju.umr.logic.userLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.logicService.userLogicSer.UserManLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.UserManDFacSer;
import edu.nju.umr.dataService.userDSer.UserManDSer;

public class UserManLogic implements UserManLSer{
	UserManDFacSer dataFac;
	UserManDSer userData;
	ArrayList<UserPO> users;
	public UserManLogic(){
		try{
		dataFac=(UserManDFacSer)Naming.lookup(Url.URL);
		userData=dataFac.getUserMan();
		users=userData.findUser(null);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Result newUser(UserVO user) {
		Result isSuccessful=Result.DATABASE_ERROR;
			try {
				if(userData.checkIsUsed(user.getId())==Result.SUCCESS)
					isSuccessful=userData.addUser(new UserPO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrg(),0,user.getOrgId()));
			} catch (RemoteException e) {
				e.printStackTrace();
				return Result.NET_INTERRUPT;
			}
		
		return isSuccessful;
	}

	public Result deleteUser(String id) {
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			isSuccessful=userData.deleteUser(id);
		}catch(RemoteException e)
		{
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return isSuccessful;
	}

	public Result reviseUser(UserVO user,int index) {
		Result isSuccessful=Result.DATA_NOT_FOUND;
		UserPO userpo=users.get(index);
		try{
			isSuccessful=userData.reviseUser(new UserPO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrg(),userpo.getKey(),user.getOrgId()));
		}catch(RemoteException e)
		{
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return isSuccessful;
	}

	public ResultMessage findUser(String keyword) {
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			users=userData.findUser(keyword);
			isSuccessful=Result.SUCCESS;
		}
		catch(RemoteException e)
		{
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		ArrayList<UserVO> arVO=new ArrayList<UserVO>();
		for(int i=0;i<users.size();i++){
			UserPO user=users.get(i);
			arVO.add(new UserVO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrg(),user.getOrgId()));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}
}
