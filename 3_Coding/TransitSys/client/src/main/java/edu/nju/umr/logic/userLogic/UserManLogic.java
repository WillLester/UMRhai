package edu.nju.umr.logic.userLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logicService.userLogicSer.UserManLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.UserManDFacSer;
import edu.nju.umr.dataService.userDSer.UserManDSer;

public class UserManLogic implements UserManLSer{
	private UserManDFacSer dataFac;
	private UserManDSer userData;
	private ArrayList<UserPO> users;
	private DiaryUpdateLSer diarySer;
	public UserManLogic()throws RemoteException{
			try {
				dataFac=(UserManDFacSer)Naming.lookup(Url.URL);
				userData=dataFac.getUserMan();
				users=userData.findUser(null);
			} catch (MalformedURLException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		diarySer = new DiaryUpdateLogic();
	}
	
	public Result newUser(UserVO user,String name) {
		Result isSuccessful=Result.DATABASE_ERROR;
			try {
				if(userData.checkIsUsed(user.getId())==Result.SUCCESS){
					isSuccessful=userData.addUser(new UserPO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrg(),0,user.getOrgId()));
					isSuccessful = diarySer.addDiary("新增用户"+user.getId(), name);
					users.add(new UserPO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrg(),0,user.getOrgId()));
				} else {
					return Result.ID_IS_USED;
				}
			} catch (RemoteException e) {
				e.printStackTrace();
				return Result.NET_INTERRUPT;
			}
		
		return isSuccessful;
	}

	public Result deleteUser(String id,String name,int index) {
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			isSuccessful=userData.deleteUser(id);
			isSuccessful = diarySer.addDiary("删除用户"+id, name);
			users.remove(index);
		}catch(RemoteException e)
		{
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return isSuccessful;
	}

	public Result reviseUser(UserVO user,int index,String name) {
		Result isSuccessful=Result.DATA_NOT_FOUND;
		UserPO userpo=users.get(index);
		try{
			if(user.getId().equals(userpo.getId())||userData.checkIsUsed(user.getId())==Result.SUCCESS){
				isSuccessful=userData.reviseUser(new UserPO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrg(),userpo.getKey(),user.getOrgId()));
				isSuccessful = diarySer.addDiary("修改了用户"+user.getId(), name);
			}else {
				return Result.ID_IS_USED;
			}
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
