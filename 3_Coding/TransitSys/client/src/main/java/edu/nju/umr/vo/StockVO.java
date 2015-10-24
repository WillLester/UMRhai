package edu.nju.umr.vo;

import java.util.ArrayList;

public class StockVO {
	private ArrayList<GoodVO> goods;
	public StockVO(ArrayList<GoodVO> goods) {
		// TODO 自动生成的构造函数存根
		this.goods = goods;
	}
	public ArrayList<GoodVO> getGoods() {
		return goods;
	}
	
}
