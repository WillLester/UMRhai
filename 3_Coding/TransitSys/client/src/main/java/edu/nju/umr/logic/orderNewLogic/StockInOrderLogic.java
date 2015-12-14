package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.StockInOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.StockInOrderDSer;
import edu.nju.umr.logic.stockLogic.StockCheckWarnLogic;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.OrderInfoLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.StockInOrderLSer;
import edu.nju.umr.logicService.stockLogicSer.StockCheckWarnLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.logicService.utilityLogicSer.UtilityLSer;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;
import edu.nju.umr.vo.order.StockInVO;

public class StockInOrderLogic implements StockInOrderLSer{
	private StockInOrderDFacSer dataFac;
	private StockInOrderDSer stockinData;
	private OrderInfoLSer orderInfoLogic;
	private UtilityLSer uti;
	private DiaryUpdateLSer diarySer;
	public StockInOrderLogic(){
		try{
			dataFac=(StockInOrderDFacSer)Naming.lookup(Url.URL);
			stockinData=dataFac.getStockInOrder();
		} catch (Exception e){
			e.printStackTrace();
		}
		uti = new UtilityLogic();
		orderInfoLogic = new OrderInfoLogic();
		diarySer = new DiaryUpdateLogic();
	}
	public Result create(StockInVO order) {
		Result isSuc=Result.DATABASE_ERROR;
		try{
			StockInPO orderPO = VPFactory.toStockInPO(order);
			isSuc = stockinData.create(orderPO);
			if(isSuc == Result.SUCCESS){
				isSuc = stockinData.addGood(new GoodPO(order.getExpressId(), order.getStockId(), order.getDate(), order.getArrivePlace(), order.getPart(), order.getShelfId(), order.getRow(), order.getPlace()));
				if(isSuc == Result.SUCCESS){
					diarySer.addDiary("为货物"+order.getExpressId()+"生成了入库单", order.getOpName());
				}
			}
		}catch(RemoteException e){
			return Result.NET_INTERRUPT;
		}catch(Exception e){
			e.printStackTrace();
		}
		return isSuc;
	}

	public ResultMessage getOrgs() {
		// TODO 自动生成的方法存根
		return uti.getOrgNames();
	}
	public Result checkWarning(String id){
		StockCheckWarnLSer checkWarn = new StockCheckWarnLogic();
		return (Result) checkWarn.checkWarning(id).getMessage();
	}
	@Override
	public ResultMessage getShelves(String orgId) {
		ArrayList<ShelfVO> shelves=new ArrayList<ShelfVO>();
		ArrayList<ShelfPO> shelfPOs=null;
		try {
			shelfPOs=stockinData.getShelves(orgId);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		
		for(ShelfPO po:shelfPOs){
			ShelfVO shelf=VPFactory.toShelfVO(po);
			shelves.add(shelf);
		}
		return new ResultMessage(Result.SUCCESS,shelves);
	}
	@Override
	public boolean isExpressValid(String id) {
		// TODO 自动生成的方法存根
		return orderInfoLogic.isExpressValid(id);
	}
}
