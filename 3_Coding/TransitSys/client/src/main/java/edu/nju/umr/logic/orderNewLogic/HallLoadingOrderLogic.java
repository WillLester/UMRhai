package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.HallLoadingOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.HallLoadingOrderDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.OrderInfoLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.HallLoadingOrderLSer;
import edu.nju.umr.logicService.utilityLogicSer.DiaryUpdateLSer;
import edu.nju.umr.logicService.utilityLogicSer.OrderInfoLSer;
import edu.nju.umr.logicService.utilityLogicSer.UtilityLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.HallLoadingVO;

public class HallLoadingOrderLogic implements HallLoadingOrderLSer{
	private HallLoadingOrderDFacSer dataFac;
	private HallLoadingOrderDSer hallData;
	private UtilityLSer uti=new UtilityLogic();
	private DiaryUpdateLSer diarySer;
	private OrderInfoLSer orderInfo;
	public HallLoadingOrderLogic() {
		try{
			dataFac = (HallLoadingOrderDFacSer)Naming.lookup(Url.URL);
			hallData = dataFac.getHallLoadingOrder();
			uti=new UtilityLogic();			
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        } 
		diarySer = new DiaryUpdateLogic();
		orderInfo = new OrderInfoLogic();
	}
	public Result create(HallLoadingVO order) {
		// TODO 自动生成的方法存根
		Result isSuc=Result.DATABASE_ERROR;
		try{
			isSuc=hallData.create(VPFactory.toHallLoadingPO(order));
			if(isSuc.equals(Result.SUCCESS)){
				isSuc = diarySer.addDiary("生成了营业厅装车单", order.getOpName());
			}
			
		} catch (RemoteException e) { 
            return Result.NET_INTERRUPT;
        } catch(Exception e){
			e.printStackTrace();
		}
		return isSuc;
	}

	public ResultMessage getOrgs() {
		return uti.getOrgNames();
	}

	public ResultMessage getVans(String orgId) {
		
		return uti.getVanNames(orgId);
	}
	
	@Override
	public ResultMessage getPrice(String org1, String org2,List<String> expressList) {
		return uti.getPrice(org1, org2,Transit.VAN,expressList);
	}
	@Override
	public ResultMessage getLocalHallAndAllCenter(String orgId) {
		return uti.getLocalHallAndAllCenter(orgId);
	}
	@Override
	public boolean isLegal(String id) {
		return orderInfo.isExpressValid(id);
	}

}
