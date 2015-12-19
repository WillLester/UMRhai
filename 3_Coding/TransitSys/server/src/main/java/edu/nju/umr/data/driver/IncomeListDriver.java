package edu.nju.umr.data.driver;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.data.checkData.IncomeListData;
import edu.nju.umr.dataService.checkDSer.IncomeListDSer;
import edu.nju.umr.po.order.IncomePO;

public class IncomeListDriver {
	private IncomeListDSer serv;
	public IncomeListDriver() {
		// TODO 自动生成的构造函数存根
		try {
			serv = IncomeListData.getIncomeList();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		
		try {
			ArrayList<IncomePO> in = serv.getCollectRec(null, "025000");
			for(IncomePO i:in){
				System.out.println(i.getAccount());
				System.out.println(i.getOpName());
				System.out.println(i.getOpTime().getTime());
			}
			Calendar c = Calendar.getInstance();
			String s = "2015-12-15";
			c.setTime(DateFormat.DATE.parse(s));
			in = serv.getCollectRec(c, null);
			for(IncomePO i:in){
				System.out.println(i.getAccount());
				System.out.println(i.getOpName());
				System.out.println(i.getOpTime().getTime());
			}
			in = serv.getCollectRec(c, "025000");
			for(IncomePO i:in){
				System.out.println(i.getAccount());
				System.out.println(i.getOpName());
				System.out.println(i.getOpTime().getTime());
			}
		} catch (RemoteException | ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
