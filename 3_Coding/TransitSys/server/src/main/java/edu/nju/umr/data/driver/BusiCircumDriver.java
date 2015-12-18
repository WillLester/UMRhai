package edu.nju.umr.data.driver;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.data.dataFactory.DataFactory;
import edu.nju.umr.dataService.checkDSer.BusiCircumDSer;
import edu.nju.umr.po.order.IncomePO;

public class BusiCircumDriver {
	private BusiCircumDSer serv;
	public BusiCircumDriver() {
		// TODO 自动生成的构造函数存根
		try {
			DataFactory fac = new DataFactory();
			serv = fac.getStatement();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		String start = "2015-12-15 00:00:00";
		String end = "2015-12-18 00:00:00";
		try {
			Calendar s = Calendar.getInstance();
			s.setTime(DateFormat.TIME.parse(start));
			Calendar e = Calendar.getInstance();
			e.setTime(DateFormat.TIME.parse(end));
			ArrayList<IncomePO> incomes = serv.findIncome(s, e);
			for(IncomePO po:incomes){
				System.out.println(po.getAccount());
				System.out.println(po.getId());
				System.out.println(po.getOpName());
				System.out.println(po.getCost());
			}
		} catch (ParseException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		} catch (RemoteException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
	}
}
