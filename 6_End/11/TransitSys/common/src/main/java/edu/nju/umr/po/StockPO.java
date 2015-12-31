package edu.nju.umr.po;

import java.io.Serializable;
import java.util.ArrayList;

public class StockPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3028163591762035472L;
	private String stockId;
	private String stock;
	private ArrayList<GoodPO> goods;
	
	public StockPO(String stockId,String stock, ArrayList<GoodPO> goods) {
		super();
		this.stockId = stockId;
		this.stock = stock;
		this.goods = goods;
	}
	public ArrayList<GoodPO> getGoods() {
		return goods;
	}
	public String getStock() {
		return stock;
	}
	public String getStockId() {
		return stockId;
	}
}
