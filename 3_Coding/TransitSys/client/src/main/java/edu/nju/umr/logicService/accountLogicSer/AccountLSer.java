package edu.nju.umr.logicService.accountLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.ResultMessage;

public interface AccountLSer {
	public Result addAccount(AccountVO account,String opName);
	public Result deleteAccount(int index,String opName);
	public Result reviseAccount(AccountVO account,int index,String opName);
	public ResultMessage searchAccount(String keyword);
}
