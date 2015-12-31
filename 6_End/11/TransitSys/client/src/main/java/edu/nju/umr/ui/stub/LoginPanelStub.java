package edu.nju.umr.ui.stub;
import edu.nju.umr.logicService.userLogicSer.LoginLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.UserVO;
public class LoginPanelStub implements LoginLSer{

	@Override
	public ResultMessage login(String id, String password) {
		// TODO Auto-generated method stub
		return new ResultMessage(Result.SUCCESS,new UserVO(password, password,Jurisdiction.ADMIN , password, password, password, password));
	}

}
