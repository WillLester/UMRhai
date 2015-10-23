package edu.nju.umr.logicService.accountLogicSer;

import edu.nju.umr.vo.CountVO;
import edu.nju.umr.vo.ResultMessage;

public interface CountLSer {
	public boolean newCount(CountVO count);
	public ResultMessage checkInitInfo();
	public ResultMessage orgList();
	public ResultMessage getWorkers(String id);
	public ResultMessage getVans(String id);
	public ResultMessage getStock(String id);
	public ResultMessage getAccount(String id);
}
