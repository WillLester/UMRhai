package edu.nju.umr.logic.userLogic;

import java.rmi.Naming;
import java.util.Calendar;

import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logicService.userLogicSer.LoginLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.UserVO;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.dataService.dataFactory.LoginDFacSer;
import edu.nju.umr.dataService.userDSer.LoginDSer;

public class LoginLogic implements LoginLSer{
	LoginDFacSer dataFac;
	LoginDSer loginData;
	public LoginLogic(){
		try{
		dataFac=(LoginDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
		loginData=dataFac.getLogin();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public ResultMessage login(String id, String password) {
		// TODO 自动生成的方法存根
		//UserVO user = new UserVO("1","Password",Jurisdiction.ADMIN,"一个用户名啊","一个手机号啊","一个机构编号啊");
		//ResultMessage message = new ResultMessage(true, user);
		boolean isSuccessful=false;
		UserVO userVO=null;
		try{
			UserPO user=loginData.findUser(id,password);
			isSuccessful=true;
			userVO=new UserVO(user.getId(),user.getPassword(),user.getJuri(),user.getName(),user.getMobile(),user.getOrgId());
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		ResultMessage message=new ResultMessage(Result.SUCCESS,userVO);
		System.out.println(UtilityLogic.setRecord(null, "嘻嘻", "蛤蛤"));
		return message;
	}

}
