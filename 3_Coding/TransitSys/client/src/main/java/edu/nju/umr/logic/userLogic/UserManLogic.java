package edu.nju.umr.logic.userLogic;

import java.rmi.Naming;
import java.util.ArrayList;

import edu.nju.umr.logicService.userLogicSer.UserManLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.dataService.dataFactory.UserManDFacSer;
import edu.nju.umr.dataService.userDSer.UserManDSer;

public class UserManLogic implements UserManLSer{
	UserManDFacSer dataFac;
	UserManDSer userData;
	
	public UserManLogic(){
		try{
		dataFac=(UserManDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
		userData=dataFac.getUserMan();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean newUser(UserVO user) {
		boolean isSuccessful=false;
		try{
			isSuccessful=userData.addUser(new UserPO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrgId()));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public boolean deleteUser(String id) {
		boolean isSuccessful=false;
		try{
			isSuccessful=userData.deleteUser(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public boolean reviseUser(UserVO user) {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		try{
			isSuccessful=userData.reviseUser(new UserPO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrgId()));
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage checkUser(String id) {
		// TODO 自动生成的方法存根
		UserVO userVO=null;
		boolean isSuccessful=false;
		try{
			UserPO user=userData.findUser(id);
			userVO=new UserVO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrgId());
			isSuccessful=true;
		}catch(Exception e){ 
			e.printStackTrace();
		}
		ResultMessage message = new ResultMessage(isSuccessful, userVO);
		return message;
	}

	public ResultMessage userList() {
		// TODO 自动生成的方法存根
		boolean isSuccessful=false;
		ArrayList<UserPO> ar=new ArrayList<UserPO>();
		try{
			ar=userData.userList();
			isSuccessful=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ArrayList<UserVO> arVO=new ArrayList<UserVO>();
		for(int i=0;i<ar.size();i++){
			UserPO user=ar.get(i);
			arVO.add(new UserVO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrgId()));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}

}
