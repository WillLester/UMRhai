package edu.nju.umr.data.driver;

import java.math.BigDecimal;
import java.rmi.RemoteException;

import edu.nju.umr.data.utilityData.AccountUpdateData;
import edu.nju.umr.dataService.utilityDSer.AccountUpdateDSer;
import edu.nju.umr.po.enums.Result;

public class AccountUpdateDriver {
	private AccountUpdateDSer serv;
	public AccountUpdateDriver() {
		try {
			serv = AccountUpdateData.getAccountUp();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		try {
			Result re = serv.income("蛤", new BigDecimal(500));
			System.out.println(re);
			re = serv.pay("蛤", new BigDecimal(500));
			System.out.println(re);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
