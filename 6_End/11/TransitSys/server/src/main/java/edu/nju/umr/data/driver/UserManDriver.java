package edu.nju.umr.data.driver;

import java.rmi.RemoteException;

import edu.nju.umr.data.userData.UserManData;
import edu.nju.umr.dataService.userDSer.UserManDSer;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Result;

public class UserManDriver {
	private UserManDSer serv;
	public UserManDriver() {
		try {
			serv = UserManData.getUserMan();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		UserPO user = new UserPO("excited","excited",Jurisdiction.FINANCE,"赛艇","12314131342","上海市中转中心",0,"0210");
		Result re;
		try {
			re = serv.addUser(user);
			System.out.println(re);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		user = new UserPO("excited","exciting",Jurisdiction.FINANCE,"赛艇","12314131342","上海市中转中心",0,"0210");
		try {
			re = serv.reviseUser(user);
			System.out.println(re);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		try {
			re = serv.deleteUser("excited");
			System.out.println(re);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
