package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.List;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.HallLoadingOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.HallLoadingOrderDSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLSer;
import edu.nju.umr.logic.utilityLogic.DiaryUpdateLogic;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.HallLoadingOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.HallLoadingVO;

public class HallLoadingOrderLogic implements HallLoadingOrderLSer{
	private HallLoadingOrderDFacSer dataFac;
	private HallLoadingOrderDSer hallData;
	private UtilityLogic uti=new UtilityLogic();
	private UpdateTransitInfoLogic infoLogic;
	private DiaryUpdateLSer diarySer;
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
		infoLogic = new UpdateTransitInfoLogic();
		diarySer = new DiaryUpdateLogic();
		// TODO 自动生成的构造函数存根
	}
	public Result create(HallLoadingVO order,String org) {
		// TODO 自动生成的方法存根
		Result isSuc=Result.DATABASE_ERROR;
		try{
			isSuc=hallData.create(VPFactory.toHallLoadingPO(order, ""));
			if(isSuc.equals(Result.SUCCESS)){
				for(String express:order.getExpress())
					infoLogic.update(express,DateFormat.TIME.format(Calendar.getInstance().getTime())
						+" "+org+"已发出 下一站"+order.getArriveLoc());
			}
			isSuc = diarySer.addDiary("生成了营业厅装车单", order.getOpName());
		} catch (RemoteException e) { 
            return Result.NET_INTERRUPT;
        } catch(Exception e){
			e.printStackTrace();
		}
		return isSuc;
	}

	public ResultMessage getOrgs() {
//		ArrayList<String> orgs = null;
//		try {
//			orgs = hallData.getOrgs();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//		}
//		return new ResultMessage(Result.SUCCESS, orgs);
		return uti.getOrgs();
	}

	public ResultMessage getVans(String orgId) {
		// TODO 自动生成的方法存根
		return uti.getVans(orgId);
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
		return uti.isExpressValid(id);
	}

}
