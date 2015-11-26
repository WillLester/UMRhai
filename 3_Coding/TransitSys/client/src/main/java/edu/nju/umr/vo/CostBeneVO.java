package edu.nju.umr.vo;

public class CostBeneVO {
     private double income;
     private double payment;
     private double benefit;
     
     public CostBeneVO(double income,double payment,double benefit){
    	 this.income=income;
    	 this.payment=payment;
    	 this.benefit=benefit;
     }
     
     public double getIncome(){
    	 return income;
     }
     
     public double getPayment(){
    	 return payment;
     }
     
     public double getBenefit(){
    	 return benefit;
     }
}
