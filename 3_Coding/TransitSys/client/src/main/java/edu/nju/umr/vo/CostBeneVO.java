package edu.nju.umr.vo;

import java.math.BigDecimal;

public class CostBeneVO {
     private BigDecimal income;
     private BigDecimal payment;
     private BigDecimal benefit;
     
     public CostBeneVO(BigDecimal income,BigDecimal payment,BigDecimal benefit){
    	 this.income=income;
    	 this.payment=payment;
    	 this.benefit=benefit;
     }
     
     public BigDecimal getIncome(){
    	 return income;
     }
     
     public BigDecimal getPayment(){
    	 return payment;
     }
     
     public BigDecimal getBenefit(){
    	 return benefit;
     }
}
