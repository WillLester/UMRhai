package edu.nju.umr.vo;

public class ConstantVO {
	private double maxLoadPlane,maxLoadTrain,maxLoadVan,pricePlane,priceTrain,priceVan,lvEco,lvStd,lvVip;
	public ConstantVO(double maxLoadPlane,double maxLoadTrain,double maxLoadVan,double pricePlane,double priceTrain,double priceVan,double lvEco,double lvStd,double lvVIP)
	{
		this.maxLoadPlane=maxLoadPlane;
		this.maxLoadTrain=maxLoadTrain;
		this.maxLoadVan=maxLoadVan;
		this.pricePlane=pricePlane;
		this.priceTrain=priceTrain;
		this.priceVan=priceVan;
		this.lvEco=lvEco;
		this.lvStd=lvStd;
		this.lvVip=lvVIP;
	}
	public double getMaxLoadPlane(){
		return maxLoadPlane;
	}
	public double getMaxLoadTrain(){
		return maxLoadTrain;
	}
	public double getMaxLoadVan(){
		return maxLoadVan;
	}
	public double getPricePlane(){
		return pricePlane;
	}
	public double getPriceTrain(){
		return priceTrain;
	}
	public double getPriceVan(){
		return priceVan;
	}
	public double getLvEco(){
		return lvEco;
	}
	public double getLvStd(){
		return lvStd;
	}
	public double getLvVip(){
		return lvVip;
	}

}