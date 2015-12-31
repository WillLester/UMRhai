package edu.nju.umr.dataService.userDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import edu.nju.umr.po.UserPO;
/**
 * 登录的数据层接口
 * @author Lester
 *
 */
public interface LoginDSer extends Remote{
	/**
	 * 登录时查找用户
	 * @param id 账号
	 * @param password 密码
	 * @return 若账号错误，返回null，若密码错误，返回一个只有id的UserPO，若正确，返回一个完整的UserPO
	 * @throws RemoteException
	 */
	public UserPO findUser(String id,String password) throws RemoteException;
}
