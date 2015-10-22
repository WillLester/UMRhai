package edu.nju.umr.logicService.accountLogicSer;

import edu.nju.umr.vo.CountVO;
import edu.nju.umr.vo.ResultMessage;

public interface CountLSer {
	public boolean newCount(CountVO count);
	public ResultMessage checkInitInfo();
}
