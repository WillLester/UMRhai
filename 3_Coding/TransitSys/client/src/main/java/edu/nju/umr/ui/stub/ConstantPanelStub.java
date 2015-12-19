package edu.nju.umr.ui.stub;
import edu.nju.umr.logicService.cityLogicSer.ConstantLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ConstantVO;
import edu.nju.umr.vo.ResultMessage;
public class ConstantPanelStub implements ConstantLSer{

	@Override
	public Result setConstant(ConstantVO constant, String name) {
		// TODO Auto-generated method stub
		System.out.println(constant.getLvEco());
		return Result.SUCCESS;
	}

	@Override
	public ResultMessage getConstant() {
		// TODO Auto-generated method stub
		return new ResultMessage(Result.FILE_NOT_FOUND,null);
	}

}
