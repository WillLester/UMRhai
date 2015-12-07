package edu.nju.umr.logic.orderNewLogic;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Calendar;

import edu.nju.umr.constants.DateFormat;
import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.HallLoadingOrderDFacSer;
import edu.nju.umr.dataService.orderNewDSer.HallLoadingOrderDSer;
import edu.nju.umr.logic.utilityLogic.UtilityLogic;
import edu.nju.umr.logic.utilityLogic.VPFactory;
import edu.nju.umr.logicService.orderNewLogic.HallLoadingOrderLSer;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.order.HallLoadingVO;

public class HallLoadingOrderLogic implements HallLoadingOrderLSer{
	private HallLoadingOrderDFacSer dataFac;
	private HallLoadingOrderDSer hallData;
	private UtilityLogic uti=new UtilityLogic();
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
		// TODO 自动生成的构造函数存根
	}
	public Result create(HallLoadingVO order,String org) {
		// TODO 自动生成的方法存根
		Result isSuc=Result.DATABASE_ERROR;
		try{
			isSuc=hallData.create(VPFactory.toHallLoadingPO(order, ""));
			if(isSuc.equals(Result.SUCCESS)){
				for(String express:order.getExpress())
				UpdateTransitInfoLogic.update(express,DateFormat.TIME.format(Calendar.getInstance().getTime())
						+" "+org+"已发出 下一站"+order.getArriveLoc());
			}
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
	public ResultMessage getPrice(String org1, String org2) {
//		String city1=null;
//		String city2=null;//两个机构所属城市名称
//		ArrayList<OrgPO> orgs=new ArrayList<OrgPO>();//获取机构列表
//		ArrayList<CitiesPO> citiespo=new ArrayList<CitiesPO>();//所属城市
//		double distance=0;//城市间距离
//		double price=0;//城市间价格
//		ResultMessage costMessage = uti.getTransitCost();
//		if(!costMessage.getReInfo().equals(Result.SUCCESS))
//		{
//			return costMessage;
//		}
//		@SuppressWarnings("unchecked")
//		ArrayList<Double> temp=(ArrayList<Double>)costMessage.getMessage();
//		double PRICE=temp.get(2);
//		Result isSuc=Result.DATA_NOT_FOUND;
//		try {
//			orgs=uti.orgs();
//			citiespo=cityData.getCitiesInfo();
//		} catch (RemoteException e) {
//			e.printStackTrace();
//			return new ResultMessage(Result.NET_INTERRUPT,null);
//		}
//		
//		if(orgs.size()>0&&citiespo.size()>0){
//			isSuc=Result.SUCCESS;
//		}
//		//获得两个机构所在城市名称
//		for(OrgPO po:orgs){
//			if(po.getName()==org1){
//				city1=po.getCity();
//				break;
//			}
//		}
//		for(OrgPO po:orgs){
//			if(po.getName()==org2){
//				city2=po.getCity();
//			    break;
//			}
//		}
//		//两机构在同一城市
//		if(city1.equals(city2))
//			return new ResultMessage(Result.SUCCESS,100);//固定值暂定为100
//		//不在同一城市
//		for(CitiesPO po:citiespo){
//			if((po.getCity1().equals(city1)&&po.getCity2().equals(city2))||(po.getCity1().equals(city2)&&po.getCity2().equals(city1))){
//				distance=po.getDistance();
//				break;
//			}
//			
//		}
//		price=PRICE;
//		return new ResultMessage(isSuc,price*distance);
		return uti.getPrice(org1, org2,2);
	}
	@Override
	public ResultMessage getLocalHallAndAllCenter(String orgId) {
		return uti.getLocalHallAndAllCenter(orgId);
	}

}
