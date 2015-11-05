package edu.nju.umr.po;

import java.io.Serializable;
import java.util.ArrayList;

public class StockPO implements Serializable{
	private String stockId;
	private ArrayList<GoodPO> goods;
	
	public StockPO(String stockId, ArrayList<GoodPO> goods) {
		super();
		this.stockId = stockId;
		this.goods = goods;
	}
	public ArrayList<GoodPO> getGoods() {
		return goods;
	}
	public String getStockId() {
		return stockId;
	}
}
