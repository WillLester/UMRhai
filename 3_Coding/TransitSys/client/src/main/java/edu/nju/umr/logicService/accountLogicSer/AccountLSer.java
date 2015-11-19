package edu.nju.umr.logicService.accountLogicSer;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.ResultMessage;

public interface AccountLSer {
	public Result addAccount(AccountVO account);
	public Result deleteAccount(int index);
	public Result reviseAccount(AccountVO account,int index);
//	public ResultMessage checkAccount(String id);
//	public ResultMessage accountList();
	public ResultMessage searchAccount(String keyword);
}
