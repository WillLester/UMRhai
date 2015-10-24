package edu.nju.umr.po;

import java.util.ArrayList;

public class StockPO {
	private ArrayList<GoodPO> goods;
	public StockPO(ArrayList<GoodPO> goods) {
		// TODO 自动生成的构造函数存根
		this.goods = goods;
	}
	public ArrayList<GoodPO> getGoods() {
		return goods;
	}
}
