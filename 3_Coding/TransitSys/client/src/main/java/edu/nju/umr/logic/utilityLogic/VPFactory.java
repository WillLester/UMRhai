package edu.nju.umr.logic.utilityLogic;

import java.util.Calendar;

import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.vo.order.ArriveVO;
import edu.nju.umr.vo.order.CenterLoadingVO;
import edu.nju.umr.vo.order.ExpressVO;
import edu.nju.umr.vo.order.HallLoadingVO;

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
	
}
