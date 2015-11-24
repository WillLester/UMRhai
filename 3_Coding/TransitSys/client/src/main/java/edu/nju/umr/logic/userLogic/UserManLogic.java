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
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public Result newUser(UserVO user) {
		Result isSuccessful=Result.SUCCESS;
			try {
				isSuccessful=userData.addUser(new UserPO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrg(),1,null));
			} catch (RemoteException e) {
				e.printStackTrace();
				return Result.NET_INTERRUPT;
			}
		
		return isSuccessful;
	}

	public Result deleteUser(String id) {
		Result isSuccessful=Result.SUCCESS;
		try{
			isSuccessful=userData.deleteUser(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public Result reviseUser(UserVO user) {
		// TODO 自动生成的方法存根
		Result isSuccessful=Result.SUCCESS;
		try{
			isSuccessful=userData.reviseUser(new UserPO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrg(),0,null));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage findUser(String keyword,int index) {
		Result isSuccessful=Result.SUCCESS;
		ArrayList<UserPO> ar=new ArrayList<UserPO>();
		try{
			ar=userData.findUser(keyword);
			isSuccessful=Result.SUCCESS;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ArrayList<UserVO> arVO=new ArrayList<UserVO>();
		for(int i=0;i<ar.size();i++){
			UserPO user=ar.get(i);
			arVO.add(new UserVO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrg(),user.getKey()));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}
}
