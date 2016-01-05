package edu.nju.umr.logic.orderApproveLogic;
/**
 * 更新单据物流状态
 * @author Lester
 *
 */
import java.rmi.RemoteException;
import java.util.List;

import edu.nju.umr.logic.utilityLogic.OrderInfoLogic;
import edu.nju.umr.logicService.orderApproveLogicSer.OrderChooseLSer;
import edu.nju.umr.logicService.orderApproveLogicSer.UpdateTranStateLSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.OrderPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.ArriveVO;
import edu.nju.umr.vo.order.CenterLoadingVO;
import edu.nju.umr.vo.order.HallLoadingVO;
import edu.nju.umr.vo.order.RecipientVO;
import edu.nju.umr.vo.order.SendVO;
import edu.nju.umr.vo.order.StockInVO;
import edu.nju.umr.vo.order.StockOutVO;
import edu.nju.umr.vo.order.TransitVO;
public class ExpressStateUpdate{
	private UpdateTranStateLSer state;
	private OrderChooseLSer cho;
	private OrderInfoLSer orderInfo;
	public ExpressStateUpdate(OrderChooseLSer cho) throws RemoteException{
		this.cho = cho;
		state = new UpdateTranStateLogic();
		orderInfo = new OrderInfoLogic();
	}
	public Result updateOrder(boolean approve,OrderPO order){
		if(approve==false&&order.getKind().equals(Order.HALLLOADING)){
			ResultMessage message =cho.chooseOrder(order.getId(),order.getKind());
			Result result=message.getReInfo();
			if(!result.equals(Result.SUCCESS)){
				return result;
			}
			HallLoadingVO vo=(HallLoadingVO)message.getMessage();
			for(String express:vo.getExpress()){
				result=state.updateExpressState(express, vo.getHallId());
				if(!result.equals(Result.SUCCESS)){
					return result;
				}
			}
		}
		
		if(order.getKind().equals(Order.ARRIVE)){
			ResultMessage message =cho.chooseOrder(order.getId(),order.getKind());
			Result result=message.getReInfo();
			if(!result.equals(Result.SUCCESS)){
				return result;
			}
			ArriveVO ap=(ArriveVO)message.getMessage();
			String id=ap.getId();
//			if(id.length()==19)
			{
				List<String> expresses = orderInfo.getHallLoadExp(id);
				if(approve){
					for(String express:expresses){
						result=state.updateExpressState(express,ap.getCenterId());
						if(!result.equals(Result.SUCCESS)){
							return result;
						}
					}
				}else{
					result=state.updateHallLoadingState(id, false);
					if(!result.equals(Result.SUCCESS)){
						return result;
					}
				}
			}
//			else
			{
				List<String> expresses = orderInfo.getTransitExp(id);
				if(approve){
					for(String express:expresses){
						result=state.updateExpressState(express,ap.getCenterId());
						if(!result.equals(Result.SUCCESS)){
							return result;
						}
					}
				}else{
					result=state.updateTransitState(id, false);
					if(!result.equals(Result.SUCCESS)){
						return result;
					}
				}
			}
		}
		
		if(order.getKind().equals(Order.STOCKIN)){
			ResultMessage message=cho.chooseOrder(order.getId(),Order.STOCKIN);
			Result result=message.getReInfo();
			if(!result.equals(Result.SUCCESS)){
				return result;
			}
			StockInVO siv=(StockInVO)message.getMessage();
			if(approve){
				result=state.updateExpressState(siv.getExpressId(), siv.getStockId()+"*");
				if(!result.equals(Result.SUCCESS)){
					return result;
				}
			}else{
				result=state.updateExpressState(siv.getExpressId(), siv.getStockId());
				if(!result.equals(Result.SUCCESS)){
					return result;
				}
			}
		}
		
		if(order.getKind().equals(Order.TRANSIT)&&(!approve)){
			ResultMessage message=cho.chooseOrder(order.getId(),Order.TRANSIT);
			Result result=message.getReInfo();
			if(!result.equals(Result.SUCCESS))
			{
				return result;
			}
			TransitVO tv=(TransitVO)message.getMessage();
			for(String express:tv.getExpress()){
				result=state.updateExpressState(express,tv.getStartOrgId()+"*");
				if(!result.equals(Result.SUCCESS))
				{
					return result;
				}
			}
		}
		
		if(order.getKind().equals(Order.CENTERLOADING)&&(!approve)){
			ResultMessage message=cho.chooseOrder(order.getId(),Order.CENTERLOADING);
			Result result=message.getReInfo();
			if(!result.equals(Result.SUCCESS))
			{
				return result;
			}
			CenterLoadingVO cv=(CenterLoadingVO)message.getMessage();
			for(String express:cv.getExpress()){
				result=state.updateExpressState(express,cv.getStartOrgId()+"*");
				if(!result.equals(Result.SUCCESS))
				{
					return result;
				}
			}
		}
		
		if(order.getKind().equals(Order.STOCKOUT)&&!approve){
			ResultMessage message=cho.chooseOrder(order.getId(),Order.STOCKOUT);
			Result result=message.getReInfo();
			if(!result.equals(Result.SUCCESS))
			{
				return result;
			}
			StockOutVO sov=(StockOutVO)message.getMessage();
			String id=sov.getTransitId();
			if(sov.getArrivePlace().endsWith("营业厅")){
				List<String> expresses = orderInfo.getCenterLoadExp(id);
				for(String express:expresses){
					result=state.updateExpressState(express,sov.getStockId()+"*#");
					if(!result.equals(Result.SUCCESS))
					{
						return result;
					}
				}
			}else{
				List<String> expresses = orderInfo.getTransitExp(id);
				for(String express:expresses){
					result=state.updateExpressState(express,sov.getStockId()+"*#");
					if(!result.equals(Result.SUCCESS))
					{
						return result;
					}
				}
			}
		}
		
		if(order.getKind().equals(Order.RECIPIENT)){
			ResultMessage message=cho.chooseOrder(order.getId(),order.getKind());
			Result result=message.getReInfo();
			if(!result.equals(Result.SUCCESS)){
				return result;
			}
			RecipientVO rv=(RecipientVO)message.getMessage();
			if(!approve){
				state.updateCenterLoadingState(rv.getTransitId(), true);
				state.updateHallLoadingState(rv.getTransitId(), true);
			}else{
				String id=rv.getTransitId();
				List<String> expresses = orderInfo.getHallLoadExp(id);
				for(String express:expresses){
					state.updateExpressState(express,rv.getId().substring(0,6)+"*");
				}
				expresses = orderInfo.getCenterLoadExp(id);
				for(String express:expresses){
					state.updateExpressState(express,rv.getId().substring(0,6)+"*");
				}
			}
		}
		
		if(order.getKind().equals(Order.SEND)&&!approve){
			ResultMessage message=cho.chooseOrder(order.getId(),order.getKind());
			Result result=message.getReInfo();
			if(!result.equals(Result.SUCCESS)){
				return result;
			}
			SendVO sv=(SendVO)message.getMessage();
			String exp=sv.getExpressId();
			state.updateExpressState(exp, sv.getId().substring(0,6)+"*");
		}
		return Result.SUCCESS;
	}
}
