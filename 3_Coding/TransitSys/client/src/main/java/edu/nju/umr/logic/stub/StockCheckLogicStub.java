package edu.nju.umr.logic.stub;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.dataService.stockDSer.StockCheckDSer;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;
public class StockCheckLogicStub implements StockCheckDSer{

	@Override
	public ArrayList<StockInPO> getIn(Calendar start, Calendar end, String id)
			throws RemoteException {
		ArrayList<StockInPO> ar=new ArrayList<StockInPO>();
		ar.add(new StockInPO(id, id, Calendar.getInstance(), id, Part.PLANE, id, 0, 0, Calendar.getInstance(), id, id, id));
		return ar;
	}

	@Override
	public ArrayList<StockOutPO> getOut(Calendar start, Calendar end, String id)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<StockOutPO> ar=new ArrayList<StockOutPO>();
		Calendar d=Calendar.getInstance();
		d.set(Calendar.YEAR, 2014);
		ar.add(new StockOutPO(id, id, d, Transit.PLANE, id, id, Calendar.getInstance(), id, id, id));
		return ar;
	}

}
