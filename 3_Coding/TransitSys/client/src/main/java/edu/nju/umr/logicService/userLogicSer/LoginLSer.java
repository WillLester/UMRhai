package edu.nju.umr.logicService.userLogicSer;

import edu.nju.umr.vo.ResultMessage;

public interface LoginLSer {
	public ResultMessage login(String id,String password);
}
