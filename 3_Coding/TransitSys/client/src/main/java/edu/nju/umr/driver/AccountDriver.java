package edu.nju.umr.driver;

import java.util.ArrayList;

import edu.nju.umr.logic.accountLogic.AccountLogic;
import edu.nju.umr.logic.accountLogic.CountLogic;
import edu.nju.umr.logicService.accountLogicSer.AccountLSer;
import edu.nju.umr.logicService.accountLogicSer.CountLSer;
import edu.nju.umr.vo.AccountVO;

public class AccountDriver {
	private AccountLSer account = new AccountLogic();
	private CountLSer count = new CountLogic();
	public static void main(String[] args) {
		AccountDriver driver = new AccountDriver();
		System.out.println(driver.account.addAccount(new AccountVO("00001", "赛艇", 233)));
		System.out.println(driver.account.deleteAccount("00001"));
		System.out.println(driver.account.reviseAccount(new AccountVO("00001", "赛艇", 233)));
		AccountVO account = (AccountVO) driver.account.checkAccount("00001").getMessage();
		System.out.println(account.getName() + " " + account.getBalance());
		@SuppressWarnings("unchecked")
		ArrayList<AccountVO> accountList = (ArrayList<AccountVO>) driver.account.accountList().getMessage();
		for(int i = 0;i < accountList.size();i++){
			System.out.println(accountList.get(i).getName() + " " + accountList.get(i).getBalance());
		}
		@SuppressWarnings("unchecked")
		ArrayList<AccountVO> accountList2 = (ArrayList<AccountVO>) driver.account.searchAccount("蛤").getMessage();
		for(int i = 0;i < accountList2.size();i++){
			System.out.println(accountList2.get(i).getName() + " " + accountList2.get(i).getBalance());
		}
		
	}
}
