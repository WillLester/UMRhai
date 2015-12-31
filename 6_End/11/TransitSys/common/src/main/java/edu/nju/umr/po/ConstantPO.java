package edu.nju.umr.po;
import java.io.Serializable;
import java.math.BigDecimal;

public class ConstantPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4767279044070659099L;
	private BigDecimal maxLoadPlane,maxLoadTrain,maxLoadVan,pricePlane,priceTrain,priceVan,lvEco,lvStd,lvVip;
	public ConstantPO (BigDecimal maxLoadPlane,BigDecimal maxLoadTrain,BigDecimal maxLoadVan,BigDecimal pricePlane,BigDecimal priceTrain,BigDecimal priceVan,BigDecimal lvEco,BigDecimal lvStd,BigDecimal lvVIP){	
		this.maxLoadPlane = maxLoadPlane;
		this.maxLoadTrain = maxLoadTrain;
		this.maxLoadVan = maxLoadVan;
		this.pricePlane = pricePlane;
		this.priceTrain = priceTrain;
		this.priceVan = priceVan;
		this.lvEco = lvEco;
		this.lvStd = lvStd;
		this.lvVip = lvVIP;
	}
	public BigDecimal getMaxLoadPlane(){
		return maxLoadPlane;
	}
	public BigDecimal getMaxLoadTrain(){
		return maxLoadTrain;
	}
	public BigDecimal getMaxLoadVan(){
		return maxLoadVan;
	}
	public BigDecimal getPricePlane(){
		return pricePlane;
	}
	public BigDecimal getPriceTrain(){
		return priceTrain;
	}
	public BigDecimal getPriceVan(){
		return priceVan;
	}
	public BigDecimal getLvEco(){
		return lvEco;
	}
	public BigDecimal getLvStd(){
		return lvStd;
	}
	public BigDecimal getLvVip(){
		return lvVip;
	}

}