package edu.nju.umr.ui.stub;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.logicService.checkLogicSer.BusiCircumLSer;
import edu.nju.umr.po.enums.Pay;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.BusiCircumVO;
import edu.nju.umr.vo.ResultMessage;

public class BusiCircumPanelStub implements BusiCircumLSer{

	@Override
	public ResultMessage getBusiCircum(Calendar start, Calendar end) {
		// TODO Auto-generated method stub
		BusiCircumVO bc=new BusiCircumVO(0,Calendar.getInstance(),new BigDecimal(100),null);
		BusiCircumVO bc1=new BusiCircumVO(1,Calendar.getInstance(),new BigDecimal(200),Pay.BONUS);
		ArrayList<BusiCircumVO> ar=new ArrayList<BusiCircumVO>();
		ar.add(bc);
		ar.add(bc1);
		return new ResultMessage(Result.SUCCESS,ar);
	}

	@Override
	public Result outputExcel(String name, String location) {
		
		return Result.SUCCESS;
	}

}
