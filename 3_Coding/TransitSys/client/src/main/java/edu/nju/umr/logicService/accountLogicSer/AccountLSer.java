package edu.nju.umr.logicService.accountLogicSer;

import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.ResultMessage;

public interface AccountLSer {
	public boolean addAccount(AccountVO account);
	public boolean deleteAccount(String id);
	public boolean reviseAccount(AccountVO account);
//	public ResultMessage checkAccount(String id);
//	public ResultMessage accountList();
	public ResultMessage searchAccount(String keyword);
}
