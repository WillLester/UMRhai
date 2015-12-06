package edu.nju.umr.logic.accountLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.accountDSer.AccountDSer;
import edu.nju.umr.dataService.dataFactory.AccountDFacSer;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.accountLogicSer.AccountLSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.ResultMessage;

public class AccountLogic implements AccountLSer{
	private AccountDFacSer dataFac;
	private AccountDSer accountData;
	private ArrayList<AccountPO> accountPOs;//从数据层拿到的po的列表排序要与界面层显示的vo列表排序一致
	public AccountLogic() {
		// TODO 自动生成的构造函数存根
		try{
			dataFac = (AccountDFacSer)Naming.lookup(Url.URL);
			accountData = dataFac.getAccountData();
			accountPOs=accountData.findAccount(null);
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
	}
	public Result addAccount(AccountVO account) {
		Result isSuccessful = Result.SUCCESS;
		try {
			isSuccessful = accountData.addAccount(new AccountPO(0, account.getName(), account.getBalance()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return Result.NET_INTERRUPT;
			
		}
		return isSuccessful;
	}

	public Result deleteAccount(int index) {
		Result isSuccessful = Result.SUCCESS;
		AccountPO toDelete=accountPOs.get(index);//获得待删除账户项在po的list中的位置
		try {
			isSuccessful = accountData.deleteAccount(toDelete.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return isSuccessful;
	}

	public Result reviseAccount(AccountVO account,int index) {
		Result isSuccessful = Result.SUCCESS;
		AccountPO init=accountPOs.get(index);
		try {
			isSuccessful = accountData.reviseAccount(new AccountPO(init.getId(), account.getName(), account.getBalance()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return Result.NET_INTERRUPT;
		}
		return isSuccessful;
	}

	public ResultMessage searchAccount(String keyword) {
		Result isSuc=Result.DATA_NOT_FOUND;
		try {
			accountPOs = accountData.findAccount(keyword);
			if(accountPOs.size()>=0)
				isSuc=Result.SUCCESS;
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}
		ArrayList<AccountVO> accountVOs=new ArrayList<AccountVO>();
		for(int i = 0;i < accountPOs.size();i++){
			AccountVO vo = VPFactory.toAccountVO(accountPOs.get(i));
			accountVOs.add(vo);
		}
		ResultMessage message = new ResultMessage(isSuc, accountVOs);
		return message;
	}

}
