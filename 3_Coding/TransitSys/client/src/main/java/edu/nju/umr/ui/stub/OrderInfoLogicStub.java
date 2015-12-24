package edu.nju.umr.ui.stub;

import java.util.List;

import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.po.order.ExpressPO;

public class OrderInfoLogicStub implements OrderInfoLSer{

	@Override
	public boolean isTransitValid(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isExpressValid(String id) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCenterLoadValid(String id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int isExpressListValid(List<String> expressList) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> getTransitExp(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getHallLoadExp(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCenterLoadExp(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ExpressPO> getExpresses(List<String> expressList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStockInExp(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String getStockOutExp(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

}
