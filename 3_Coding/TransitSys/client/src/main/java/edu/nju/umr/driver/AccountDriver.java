package edu.nju.umr.driver;

import edu.nju.umr.logic.accountLogic.AccountLogic;
import edu.nju.umr.logic.accountLogic.CountLogic;
import edu.nju.umr.logicService.accountLogicSer.AccountLSer;
import edu.nju.umr.logicService.accountLogicSer.CountLSer;

public class AccountDriver {
	private AccountLSer account = new AccountLogic();
	private CountLSer count = new CountLogic();
	public static void main(String[] args) {
		AccountDriver driver = new AccountDriver();
		driver.account.addAccount(null);
	}
}
