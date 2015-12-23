package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public interface UpdateTranStateLSer {
	public Result updateExpressState(String id,String nowOrgId);
	public Result updateHallLoadingState(String id,boolean arrived);
	public Result updateCenterLoadingState(String id,boolean arrived);
	public Result updateTransitState(String id,boolean arrived);
	public ResultMessage getExpressHere(String nowOrgId);
	public ResultMessage getHallLoadingHere(String arriveLoc,boolean arrived);
	public ResultMessage getCenterLoadingHere(String arriveLoc,boolean arrived);
	public ResultMessage getTransitHere(String arriveLoc,boolean arrived);
}
