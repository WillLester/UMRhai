package edu.nju.umr.ui.stub;
import java.util.ArrayList;
import java.util.List;

import edu.nju.umr.logicService.workOrgManLogicSer.WageManLSer;
import edu.nju.umr.po.enums.Jurisdiction;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Wage;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.WageVO;
public class WorkWageListPanelStub implements WageManLSer{

	@Override
	public ResultMessage searchWorks(String keyword) {
		// TODO Auto-generated method stub
		ArrayList<WageVO> ar= new ArrayList<WageVO>();
		ar.add(new WageVO("1", Jurisdiction.COURIER, Wage.MONTH, 3, 4));
		return new ResultMessage(Result.SUCCESS,ar);
	}

	@Override
	public Result setWage(List<WageVO> wageList, int[] index, String name) {
		// TODO Auto-generated method stub
		return Result.SUCCESS;
	}

}
