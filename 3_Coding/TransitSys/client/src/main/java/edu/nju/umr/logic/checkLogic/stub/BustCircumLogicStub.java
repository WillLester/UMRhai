package edu.nju.umr.logic.checkLogic.stub;

import java.util.Calendar;

import edu.nju.umr.logicService.checkLogicSer.BusiCircumLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;

public class BustCircumLogicStub implements BusiCircumLSer{

	@Override
	public ResultMessage getBusiCircum(Calendar start, Calendar end) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public Result outputExcel(String name, String location) {
		// TODO 自动生成的方法存根
		return null;
	}

}
