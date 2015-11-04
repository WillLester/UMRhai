package edu.nju.umr.logicService.checkLogicSer;

import java.util.ArrayList;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.IncomeVO;
import edu.nju.umr.vo.order.PaymentVO;

public interface CostBeneLSer {
	public ResultMessage getIncome();
	public ResultMessage getPayment();
	public boolean outputExcel(String location,ArrayList<IncomeVO> income,ArrayList<PaymentVO> payment);
}
