package edu.nju.umr.logic.accountLogic;

import edu.nju.umr.logicService.accountLogicSer.AccountLSer;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.ResultMessage;

public class AccountLogic implements AccountLSer{

	public boolean addAccount(AccountVO account) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean deleteAccount(String id) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean reviseAccount(AccountVO account) {
		// TODO 自动生成的方法存根
		return true;
	}

	public ResultMessage checkAccount(String id) {
		// TODO 自动生成的方法存根
		AccountVO account = new AccountVO("12345", "Excited", 25000);
		ResultMessage message = new ResultMessage(true, account);
		return message;
	}

	public ResultMessage accountList() {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage searchAccount(String keyword) {
		// TODO 自动生成的方法存根
		return null;
	}

}
