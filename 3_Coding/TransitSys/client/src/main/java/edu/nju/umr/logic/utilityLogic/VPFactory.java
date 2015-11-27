package edu.nju.umr.logic.utilityLogic;

import java.util.Calendar;

import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.po.order.TransitPO;
import edu.nju.umr.vo.order.ArriveVO;
import edu.nju.umr.vo.order.CenterLoadingVO;
import edu.nju.umr.vo.order.ExpressVO;
import edu.nju.umr.vo.order.HallLoadingVO;
import edu.nju.umr.vo.order.IncomeVO;
import edu.nju.umr.vo.order.PaymentVO;
import edu.nju.umr.vo.order.RecipientVO;
import edu.nju.umr.vo.order.SendVO;
import edu.nju.umr.vo.order.StockInVO;
import edu.nju.umr.vo.order.StockOutVO;
import edu.nju.umr.vo.order.TransitVO;

public class VPFactory {
	//到达单
     public static ArriveVO toArriveVO(ArrivePO po){
    	 ArriveVO vo=new ArriveVO(po.getCenterId(), po.getDate(), po.getStartPlace(), po.getState(), po.getOpName());
    	 return vo;
     }
     public static ArrivePO toArrivePO(ArriveVO vo,String id){
    	 ArrivePO po=new ArrivePO(vo.getCenterId(), vo.getDate(), id, vo.getStartPlace(), vo.getState(), Calendar.getInstance(), vo.getOpName());
    	 return po;
     }
     
     //中转中心装车单
     public static CenterLoadingVO toCenterLoadVO(CenterLoadingPO po){
    	 CenterLoadingVO vo=new CenterLoadingVO(po.getDate(), po.getTarget(), po.getVanId(), po.getSupervision(), po.getEscort(), po.getExpress(),po.getCost(), po.getOpName());
    	 return vo;
     }
     public static CenterLoadingPO toCenterLoadPO(CenterLoadingVO vo,String id){
    	 CenterLoadingPO po=new CenterLoadingPO(vo.getDate(), id, vo.getTarget(), vo.getVanId(), vo.getSupervision(), vo.getEscort(), vo.getExpress(), Calendar.getInstance(), vo.getOpName(), vo.getCost());
    	 return po;
     }
     
     //快递单
     public static ExpressVO toExpressVO(ExpressPO po){
    	 ExpressVO vo=new ExpressVO(po.getId(), po.getSender(), po.getSendLoc(), po.getReceiver(), po.getReceiveLoc(), po.getSendMobile(), po.getReceiveMobile(), 
    			 po.getSendPhone(), po.getReceivePhone(), po.getSendUnit(), po.getReceiveUnit(),po.getNum(), po.getName(), po.getLength(), po.getWidth(), po.getHeight(), po.getWeight(), po.getVolumn(), po.getArrive(), po.getKind(), po.getCost(), po.getOpName());
    	 return vo;
     }
     public static ExpressPO toExpressPO(ExpressVO vo){
    	 ExpressPO po=new ExpressPO(vo.getSender(), vo.getSendLoc(), vo.getReceiver(), vo.getReceiveLoc(),vo.getSendMobile(), vo.getReceiveMobile(),
    			 vo.getSendPhone(), vo.getReceivePhone(), vo.getSendUnit(),vo.getReceiveUnit(), vo.getNum(), vo.getName(),vo.getLength(),vo.getWidth(), vo.getHeight(), vo.getWeight(), vo.getVolumn(), 
    			 vo.getId(), vo.getArrive(), vo.getKind(), vo.getCost(), Calendar.getInstance(), vo.getOpName());
    	 return po;
     }
     
     //营业厅装车单
     public static HallLoadingVO toHallLoadingVO(HallLoadingPO po){
    	 HallLoadingVO vo=new HallLoadingVO(po.getHallId(), po.getConvertId(), po.getArriveLoc(), po.getVanId(), po.getSupervision(), po.getEscort(), po.getExpress(), 0, po.getDate(), po.getOpName());
    	 return vo;
     }
     public static HallLoadingPO toHallLoadingPO(HallLoadingVO vo,String id){
    	 HallLoadingPO po=new HallLoadingPO(id,vo.getHallId(),vo.getConvertId(),vo.getArriveLoc(),vo.getVanId(),vo.getSupervision(),vo.getEscort(),vo.getExpress(),vo.getDate(),Calendar.getInstance(),vo.getOpName(),vo.getCost());
    	 return po;
     }
     
     //入款单
     public static IncomeVO toIncomeVO(IncomePO po){
    	 IncomeVO vo=new IncomeVO(po.getDate(), po.getCourier(), po.getCost(), po.getExpress(), po.getOpName(), po.getOrgId());
    	 return vo;
     }
	public static IncomePO toIncomePO(IncomeVO vo,int id){
		IncomePO po=new IncomePO(vo.getDate(), vo.getCourier(), vo.getCost(), vo.getExpress(), id,Calendar.getInstance(),vo.getOpName(),vo.getOrgId());
		return po;
	}
	
	//付款单
	public static PaymentVO toPaymentVO(PaymentPO po){
		PaymentVO vo=new PaymentVO(po.getDate(), po.getPayer(), po.getAccount(), po.getKind(), po.getAmount(), po.getRemarks(), po.getOpName());
		return vo;
	}
	public static PaymentPO toPaymentPO(PaymentVO vo,int id){
		PaymentPO po=new PaymentPO(id, vo.getDate(), vo.getPayer(), vo.getAccount(), vo.getKind(), vo.getAmount(),vo.getRemarks(),Calendar.getInstance(),vo.getOpName());
		return po;
	}
	
	//到达单
	public static RecipientVO toRecipientVO(RecipientPO po){
		RecipientVO vo=new RecipientVO(po.getDate(), po.getTransitId(), po.getStartPlace(),po.getState(), po.getOpName());
		return vo;
	}
	public static RecipientPO toRecipientPO(RecipientVO vo,String id){
		RecipientPO po=new RecipientPO(vo.getDate(),id,vo.getTransitId(),vo.getStartPlace(),vo.getState(),Calendar.getInstance(),vo.getOpName());
		return po;
	}
	
	//派件单
	public static SendVO toSendVO(SendPO po){
		SendVO vo=new SendVO(po.getDate(), po.getExpressId(), po.getCourier(), po.getOpName());
		return vo;
	}
	public static SendPO toSendPO(SendVO vo,String id){
		SendPO po=new SendPO(vo.getDate(),vo.getExpressId(),id,vo.getCourier(),Calendar.getInstance(),vo.getOpName());
		return po;
	}
	
	//入库单
	public static StockInVO toStockInVO(StockInPO po){
		StockInVO vo=new StockInVO(po.getExpressId(), po.getDate(), po.getArrivePlace(), po.getPart(), po.getShelfId(), po.getRow(), po.getPlace(), po.getOpName(), po.getStockId());
		return vo;
	}
	public static StockInPO toStockInPO(StockInVO vo,int id){
		StockInPO po=new StockInPO(id,vo.getExpressId(),vo.getDate(),vo.getArrivePlace(),vo.getPart(),vo.getShelfId(),vo.getRow(),vo.getPlace(),Calendar.getInstance(),vo.getOpName(),vo.getStockId());
		return po;
	}
	
	//出库单
	public static StockOutVO toStockOutVO(StockOutPO po){
		StockOutVO vo=new StockOutVO(po.getExpressId(), po.getDate(), po.getKind(), po.getArrivePlace(), po.getTransitId(), po.getOpName(), po.getStockId());
		return vo;
	}
	public static StockOutPO toStockOutPO(StockOutVO vo,int id){
		StockOutPO po=new StockOutPO(id,vo.getExpressId(),vo.getDate(),vo.getKind(),vo.getArrivePlace(),vo.getTransitId(),Calendar.getInstance(),vo.getOpName(),vo.getStockId());
		return po;
	}
	
	//中转单
	public static TransitVO toTransitVO(TransitPO po){
		TransitVO vo=new TransitVO(po.getPlaneId(), po.getStartPlace(),po.getArrivePlace(), po.getContainerId(), po.getSupervision(), po.getExpress(), po.getOpName());
		return vo;
	}
	public static TransitPO toTransitPO(TransitVO vo,String id){
		TransitPO po=new TransitPO(id,vo.getPlaneId(),vo.getStartPlace(),vo.getArrivePlace(),vo.getContainerId(),vo.getSupervision(),vo.getExpress(),Calendar.getInstance(),vo.getOpName());
		return po;
	}
}
