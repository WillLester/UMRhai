package edu.nju.umr.logic.orderApproveLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.OrderResubmitDFacSer;
import edu.nju.umr.dataService.orderApproveDSer.OrderResubmitDSer;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderApproveLogicSer.OrderResubmitLSer;
import edu.nju.umr.po.enums.Order;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.ArrivePO;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;
import edu.nju.umr.po.order.HallLoadingPO;
import edu.nju.umr.po.order.IncomePO;
import edu.nju.umr.po.order.KindGetter;
import edu.nju.umr.po.order.PaymentPO;
import edu.nju.umr.po.order.RecipientPO;
import edu.nju.umr.po.order.SendPO;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.po.order.StockOutPO;
import edu.nju.umr.po.order.TransitPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.OrderVO;

public class OrderResubmitLogic implements OrderResubmitLSer{
	private OrderResubmitDFacSer dataFac;
	private OrderResubmitDSer resubmitData;
	private List<KindGetter> orderList;
	public OrderResubmitLogic() {
		try{
			dataFac = (OrderResubmitDFacSer)Naming.lookup(Url.URL);
			resubmitData = dataFac.getOrderResubmit();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        }
	}

	@Override
	public ResultMessage getUnpassed(String id) {
		// TODO 自动生成的方法存根
		try {
			orderList = resubmitData.getOrders(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ResultMessage(Result.NET_INTERRUPT, 0);
		}
		System.out.println(orderList.size());
		return new ResultMessage(Result.SUCCESS, orderList.size());
	}

	@Override
	public ResultMessage getOrdersDisplay() {
		// TODO 自动生成的方法存根
		ArrayList<OrderVO> orderDisplay = new ArrayList<OrderVO>();
		for(KindGetter order:orderList){
			orderDisplay.add(getInfo(order));
		}
		return new ResultMessage(Result.SUCCESS, orderDisplay);
	}

	@Override
	public ResultMessage getOrder(int index) {
		// TODO 自动生成的方法存根
		KindGetter order = orderList.get(index);
		Order kind = order.getOrderKind();
		switch(kind){
		case ARRIVE:
			ArrivePO poA = (ArrivePO) order;
			return new ResultMessage(Result.SUCCESS, VPFactory.toArriveVO(poA));
		case CENTERLOADING:
			CenterLoadingPO poC = (CenterLoadingPO) order;
			return new ResultMessage(Result.SUCCESS, VPFactory.toCenterLoadVO(poC));
		case EXPRESS:
			ExpressPO poE = (ExpressPO) order;
			return new ResultMessage(Result.SUCCESS, VPFactory.toExpressVO(poE));
		case HALLLOADING:
			HallLoadingPO poH = (HallLoadingPO) order;
			return new ResultMessage(Result.SUCCESS, VPFactory.toHallLoadingVO(poH));
		case INCOME:
			IncomePO poI = (IncomePO) order;
			return new ResultMessage(Result.SUCCESS, VPFactory.toIncomeVO(poI));
		case PAYMENT:
			PaymentPO poP = (PaymentPO) order;
			return new ResultMessage(Result.SUCCESS, VPFactory.toPaymentVO(poP));
		case RECIPIENT:
			RecipientPO poR = (RecipientPO) order;
			return new ResultMessage(Result.SUCCESS, VPFactory.toRecipientVO(poR));
		case SEND:
			SendPO poS = (SendPO) order;
			return new ResultMessage(Result.SUCCESS, VPFactory.toSendVO(poS));
		case STOCKIN:
			StockInPO poSI = (StockInPO) order;
			return new ResultMessage(Result.SUCCESS, VPFactory.toStockInVO(poSI));
		case STOCKOUT:
			StockOutPO poSO = (StockOutPO) order;
			return new ResultMessage(Result.SUCCESS, VPFactory.toStockOutVO(poSO));
		case TRANSIT:
			TransitPO poT = (TransitPO) order;
			return new ResultMessage(Result.SUCCESS, VPFactory.toTransitVO(poT));
		}
		return null;
	}
	private OrderVO getInfo(KindGetter order){
		Order kind = order.getOrderKind();
		OrderVO result = null;
		switch(kind){
		case ARRIVE:
			ArrivePO poA = (ArrivePO) order;
			result = new OrderVO(poA.getId(), kind, poA.getOpName(), poA.getOpTime());
			break;
		case CENTERLOADING:
			CenterLoadingPO poC = (CenterLoadingPO) order;
			result = new OrderVO(poC.getId(), kind, poC.getOpName(), poC.getOpTime());
			break;
		case EXPRESS:
			ExpressPO poE = (ExpressPO) order;
			result = new OrderVO(poE.getId(), kind, poE.getOpName(), poE.getOpTime());
			break;
		case HALLLOADING:
			HallLoadingPO poH = (HallLoadingPO) order;
			result = new OrderVO(poH.getId(), kind, poH.getOpName(), poH.getOpTime());
			break;
		case INCOME:
			IncomePO poI = (IncomePO) order;
			result = new OrderVO(poI.getId()+"", kind, poI.getOpName(), poI.getOpTime());
			break;
		case PAYMENT:
			PaymentPO poP = (PaymentPO) order;
			result = new OrderVO(poP.getId()+"", kind, poP.getOpName(), poP.getOpTime());
			break;
		case RECIPIENT:
			RecipientPO poR = (RecipientPO) order;
			result = new OrderVO(poR.getId(), kind, poR.getOpName(), poR.getOpTime());
			break;
		case SEND:
			SendPO poS = (SendPO) order;
			result = new OrderVO(poS.getId(), kind, poS.getOpName(), poS.getOpTime());
			break;
		case STOCKIN:
			StockInPO poSI = (StockInPO) order;
			result = new OrderVO(poSI.getId()+"", kind, poSI.getOpName(), poSI.getOpTime());
			break;
		case STOCKOUT:
			StockOutPO poSO = (StockOutPO) order;
			result = new OrderVO(poSO.getId()+"", kind, poSO.getOpName(), poSO.getOpTime());
			break;
		case TRANSIT:
			TransitPO poT = (TransitPO) order;
			result = new OrderVO(poT.getId(), kind, poT.getOpName(), poT.getOpTime());
			break;
		}
		return result;
	}

}
