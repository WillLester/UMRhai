package edu.nju.umr.vo;

import java.util.ArrayList;

public class StockVO {
	private ArrayList<GoodVO> goods;
	private String stockId;
	
	public StockVO(ArrayList<GoodVO> goods, String stockId) {
		super();
		this.goods = goods;
		this.stockId = stockId;
	}

	public ArrayList<GoodVO> getGoods() {
		return goods;
	}

	public String getStockId() {
		return stockId;
	}
	
}
