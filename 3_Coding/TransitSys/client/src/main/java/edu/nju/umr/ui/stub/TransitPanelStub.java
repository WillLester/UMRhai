package edu.nju.umr.ui.stub;
import java.math.BigDecimal;
import java.util.List;

import edu.nju.umr.logicService.orderNewLogic.TransitOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.TransitVO;
public class TransitPanelStub implements TransitOrderLSer{

	@Override
	public Result create(TransitVO order) {
		// TODO Auto-generated method stub
		return Result.SUCCESS;
	}

	@Override
	public ResultMessage getCenters() {
		// TODO Auto-generated method stub
		String[] t=new String[]{"中转"};
		return new ResultMessage(Result.SUCCESS,t);
	}

	@Override
	public int isExpressValid(List<String> expressList) {
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public ResultMessage getPrice(String org1, String org2, int tran,
			List<String> expressList) {
		// TODO Auto-generated method stub
		return new ResultMessage(Result.SUCCESS,new BigDecimal(100));
	}

	@Override
	public ResultMessage getNextId(String orgId) {
		// TODO Auto-generated method stub
		return new ResultMessage(Result.SUCCESS,10);
	}

	@Override
	public ResultMessage getGoingExpresses(String orgId) {
		// TODO Auto-generated method stub
		return null;
	}

}
