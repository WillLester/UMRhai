package edu.nju.umr.logic.checkLogic;

import java.util.ArrayList;

import edu.nju.umr.logicService.checkLogicSer.CostBeneLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;
import edu.nju.umr.vo.order.PaymentVO;

public class CostBeneLogic implements CostBeneLSer{

	public ResultMessage getIncome() {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage getPayment() {
		// TODO 自动生成的方法存根
		return null;
	}

	public Result outputExcel(String location, ArrayList<IncomeVO> income,
			ArrayList<PaymentVO> payment) {
		// TODO 自动生成的方法存根
		return Result.SUCCESS;
	}

}
