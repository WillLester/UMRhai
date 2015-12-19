package edu.nju.umr.ui.stub;

import java.util.ArrayList;

import edu.nju.umr.logicService.cityLogicSer.LocLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.LocVO;


public class LocLogicStub implements LocLSer{

	@Override
	public ResultMessage getCities() {
		// TODO Auto-generated mhod stub
		ArrayList<LocVO> ar=new ArrayList<LocVO>();
		ar.add(new LocVO("北京","北京"));
		ar.add(new LocVO("南京","江苏"));
		ar.add(new LocVO("无锡","江苏"));
		ar.add(new LocVO("上海","上海"));
		return new ResultMessage(Result.SUCCESS,ar);
	}

}
