package edu.nju.umr.ui.stub;
import java.util.ArrayList;

import edu.nju.umr.logicService.transitInfoLogicSer.CustomerLogicSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
public class TransitInfoInqPanelStub implements CustomerLogicSer{

	@Override
	public ResultMessage enterBarcodeCustomer(String barcode) {
		// TODO Auto-generated method stub
		ArrayList<String> ar =new ArrayList<String>();
		ar.add("1");
		ar.add("2");
		return new ResultMessage(Result.SUCCESS,ar);
	}

}
