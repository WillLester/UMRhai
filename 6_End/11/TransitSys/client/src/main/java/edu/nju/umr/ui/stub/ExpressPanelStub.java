package edu.nju.umr.ui.stub;
import edu.nju.umr.logicService.orderNewLogic.ExpressOrderLSer;
import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.Parse;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.order.ExpressVO;
public class ExpressPanelStub implements ExpressOrderLSer{

	@Override
	public Result create(ExpressVO order) {
		// TODO Auto-generated method stub
		return Result.SUCCESS;
	}

	@Override
	public String getPrice(String city1, String city2, Express expressKind,
			Parse pakKind, double weight) {
		// TODO Auto-generated method stub
		return "233";
	}

	@Override
	public int getTime(String city1, String city2) {
		// TODO Auto-generated method stub
		return 3;
	}

}
