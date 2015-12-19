package edu.nju.umr.data.driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.data.stockData.StockCheckNowData;
import edu.nju.umr.dataService.stockDSer.StockCheckNowDSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.StockPO;

public class StockCheckNowDriver {
	private StockCheckNowDSer serv;
	public StockCheckNowDriver() {
		// TODO 自动生成的构造函数存根
		try {
			serv = StockCheckNowData.getStockCheckNow();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	public void drive(){
		try {
			StockPO stock = serv.getStock("0250");
			System.out.println(stock.getStock());
			System.out.println(stock.getStockId());
			ArrayList<GoodPO> goods = stock.getGoods();
			for(GoodPO good:goods){
				System.out.println(good.getId());
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
