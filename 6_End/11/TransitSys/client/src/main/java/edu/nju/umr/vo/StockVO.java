package edu.nju.umr.vo;

import java.util.ArrayList;

public class StockVO {
	private ArrayList<GoodVO> goods;
	private String stockId;
	private String name;
	
	public StockVO(ArrayList<GoodVO> goods, String stockId,String name) {
		super();
		this.goods = goods;
		this.stockId = stockId;
		this.name = name;
	}

	public ArrayList<GoodVO> getGoods() {
		return goods;
	}

	public String getStockId() {
		return stockId;
	}

	public String getName() {
		return name;
	}
	
}
