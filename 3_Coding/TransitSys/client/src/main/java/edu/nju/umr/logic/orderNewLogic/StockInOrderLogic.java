package edu.nju.umr.logic.orderNewLogic;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.orderNew.StockInOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.StockInOrderDSer;
import edu.nju.umr.logic.stockLogic.StockCheckWarnLogic;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.OrderInfoLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.StockInOrderLSer;
import edu.nju.umr.logicService.orderNewLogic.UpdateTranStateLSer;
import edu.nju.umr.logicService.stockLogicSer.StockCheckWarnLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.logicService.utilityLogicSer.UtilityLSer;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.order.StockInPO;
import edu.nju.umr.vo.GoodVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.ShelfVO;
import edu.nju.umr.vo.StockVO;
import edu.nju.umr.vo.order.StockInVO;

public class StockInOrderLogic implements StockInOrderLSer{
	private StockInOrderDFacSer dataFac;
	private StockInOrderDSer stockinData;
	private OrderInfoLSer orderInfoLogic;
	private UtilityLSer uti;
	private DiaryUpdateLSer diarySer;
	private UpdateTranStateLSer orderState;
	private StockVO thisStock;
	private ArrayList<ShelfVO> theseShelves;
	private boolean [][][] positions;
	private int [] size;
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
		orderState = new UpdateTranStateLogic();
	}
	public Result create(StockInVO order) {
		Result isSuc=Result.DATABASE_ERROR;
		try{
			StockInPO orderPO = VPFactory.toStockInPO(order);
			isSuc = stockinData.create(orderPO);
			if(isSuc == Result.SUCCESS){
				diarySer.addDiary("为货物"+order.getExpressId()+"生成了入库单", order.getOpName());
			}
			if(isSuc == Result.SUCCESS){
				isSuc=orderState.updateExpressState(order.getExpressId(), order.getStockId()+"#");
				if(isSuc != Result.SUCCESS){
					return isSuc;
				}
			}
			if(isSuc == Result.SUCCESS){
				isSuc = this.checkWarning(order.getStockId());
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
	private Result checkWarning(String id){
		StockCheckWarnLSer checkWarn = new StockCheckWarnLogic();
		return (Result) checkWarn.checkWarning(id).getMessage();
	}
	@SuppressWarnings("unchecked")
	@Override
	public ResultMessage getShelves(String orgId) {
		theseShelves=new ArrayList<ShelfVO>();
		ArrayList<ShelfPO> shelfPOs=null;
		try {
			shelfPOs=stockinData.getShelves(orgId);
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		
		for(ShelfPO po:shelfPOs){
			ShelfVO shelf=VPFactory.toShelfVO(po);
			theseShelves.add(shelf);
		}
		
		ResultMessage message = uti.getStocks();
		Result result=message.getReInfo();
		if(!result.equals(Result.SUCCESS)){
			return message;
		}
		ArrayList<StockVO> stocks=(ArrayList<StockVO>)message.getMessage();
		for(StockVO sv:stocks){
			if(sv.getStockId().equals(orgId)){
				thisStock=sv;
				break;
				
			}
		}
		if(theseShelves.size()==0){
			return new ResultMessage(Result.NOSPACE_FOR_STOCK,null);
		}
		
		size=new int[3];
		size[0]=theseShelves.size();
		for(int i=0;i<size[0];i++){
			if(size[1]<theseShelves.get(i).getRow())size[1]=theseShelves.get(i).getRow();
			if(size[2]<theseShelves.get(i).getPlace())size[2]=theseShelves.get(i).getPlace();
		}
		positions=new boolean[size[0]][size[1]][size[2]];
		
		
		for(GoodVO gv:thisStock.getGoods()){
			for(int i=0;i<size[0];i++){
				ShelfVO sv=theseShelves.get(i);
				if(gv.getShelf().equals(sv.getId())){
					positions[i][gv.getRow()-1][gv.getPlace()-1]=true;
					break;
				}
			}
		}
		
		ArrayList<ShelfVO> emptyShelves=new ArrayList<ShelfVO>();
		for(int i=0;i<size[0];i++){
			boolean empty=false;
			ShelfVO tempSV=theseShelves.get(i);
			for(int j=0;j<tempSV.getRow();j++){
				for(int k=0;k<tempSV.getPlace();k++){
					if(positions[i][j][k]==false){
						empty=true;break;
					}
				}
				if(empty){
					break;
				}
			}
			if(empty){
				emptyShelves.add(theseShelves.get(i));
			}
		}
		
		if(emptyShelves.size()==0){
			return new ResultMessage(Result.STOCK_FULL,null);
		}
		
		return new ResultMessage(Result.SUCCESS,emptyShelves);
	}
	@Override
	public boolean isExpressValid(String id) {
		// TODO 自动生成的方法存根
		return orderInfoLogic.isExpressValid(id);
	}
	@Override
	public ResultMessage getNextId(String orgId) {
		String time=DateFormat.DATESTRING.format(Calendar.getInstance().getTime());
		try{
			int num = stockinData.getOrderSize(orgId+time);
			if(num==-1)
			{
				return new ResultMessage(Result.DATABASE_ERROR,null);
			}
			return new ResultMessage(Result.SUCCESS,num);
		}catch(RemoteException e)
		{
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
	}
	@Override
	public ResultMessage getComingExpresses(String orgId) {
		// TODO Auto-generated method stub
		return orderState.getExpressHere(orgId);
	}
	@Override
	public Integer[] getRow(String shelf) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ar=new ArrayList<Integer>();
		int sh=-1;
		for(int i=0;i<size[0];i++){
			if(theseShelves.get(i).getId().equals(shelf)){
				sh=i;
				break;
			}
		}
		ShelfVO tempSV=theseShelves.get(sh);
		for(int i=0;i<tempSV.getRow();i++){
			int count=tempSV.getPlace();
			for(int j=0;j<tempSV.getPlace();j++){
				if(positions[sh][i][j]){
					count--;
				}
			}
			if(count!=0){
				ar.add(i);
			}
		}
		
		Integer [] t = new Integer[ar.size()];
		for(int i=0;i<ar.size();i++){
			t[i]=ar.get(i)+1;
		}
		return t;
	}
	@Override
	public Integer[] getPlace(String shelf, int row) {
		// TODO Auto-generated method stub
		ArrayList<Integer> ar=new ArrayList<Integer>();
		int sh=-1;
		for(int i=0;i<size[0];i++){
			if(theseShelves.get(i).getId().equals(shelf)){
				sh=i;
				break;
			}
		}
		ShelfVO tempSV=theseShelves.get(sh);
		
		for(int i=0;i<tempSV.getPlace();i++){
			if(positions[sh][row-1][i]==false){
				ar.add(i);
			}
		}
		
		Integer [] t = new Integer[ar.size()];
		for(int i=0;i<ar.size();i++){
			t[i]=ar.get(i)+1;
		}
		return t;
	}
}
