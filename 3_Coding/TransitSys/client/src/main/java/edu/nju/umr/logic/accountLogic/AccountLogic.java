package edu.nju.umr.logic.accountLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.dataService.accountDSer.AccountDSer;
import edu.nju.umr.dataService.dataFactory.AccountDFacSer;
import edu.nju.umr.logicService.accountLogicSer.AccountLSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.ResultMessage;

public class AccountLogic implements AccountLSer{
	AccountDFacSer dataFac;
	AccountDSer accountData;
	public AccountLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (AccountDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			accountData = dataFac.getAccountData();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public boolean addAccount(AccountVO account) {
		// TODO 自动生成的方法存根
		boolean isSuccessful = false;
		try {
			isSuccessful = accountData.addAccount(new AccountPO(account.getId(), account.getName(), account.getBalance()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public boolean deleteAccount(String id) {
		// TODO 自动生成的方法存根
		boolean isSuccessful = false;
		try {
			isSuccessful = accountData.deleteAccount(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public boolean reviseAccount(AccountVO account) {
		// TODO 自动生成的方法存根
		boolean isSuccessful = false;
		try {
			isSuccessful = accountData.reviseAccount(new AccountPO(account.getId(), account.getName(), account.getBalance()));
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return isSuccessful;
	}

	public ResultMessage checkAccount(String id) {
		// TODO 自动生成的方法存根
		AccountPO accountPo = null;
		try {
			accountPo = accountData.checkAccount(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		AccountVO account = new AccountVO(accountPo.getId(), accountPo.getName(), accountPo.getBalance());
		ResultMessage message = new ResultMessage(true, account);
		return message;
	}

	public ResultMessage accountList() {
		// TODO 自动生成的方法存根
		ArrayList<AccountPO> arPo = null;
		try {
			arPo = accountData.findAccount(null);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		ArrayList<AccountVO> ar=new ArrayList<AccountVO>();
		for(int i = 0;i < arPo.size();i++){
			AccountVO vo = new AccountVO(arPo.get(i).getId(), arPo.get(i).getName(), arPo.get(i).getBalance());
			ar.add(vo);
		}
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

	public ResultMessage searchAccount(String keyword) {
		// TODO 自动生成的方法存根
		ArrayList<AccountPO> arPo = null;
		try {
			arPo = accountData.findAccount(keyword);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		ArrayList<AccountVO> ar=new ArrayList<AccountVO>();
		for(int i = 0;i < arPo.size();i++){
			AccountVO vo = new AccountVO(arPo.get(i).getId(), arPo.get(i).getName(), arPo.get(i).getBalance());
			ar.add(vo);
		}
		ResultMessage message = new ResultMessage(true, ar);
		return message;
	}

}
