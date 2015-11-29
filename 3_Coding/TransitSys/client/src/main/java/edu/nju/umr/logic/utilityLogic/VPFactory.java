package edu.nju.umr.logic.utilityLogic;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.ConstantPO;
import edu.nju.umr.po.CountPO;
import edu.nju.umr.po.DiaryPO;
import edu.nju.umr.po.DriverPO;
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.ShelfPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.UserPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
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
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.CitiesVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.ConstantVO;
import edu.nju.umr.vo.CountVO;
import edu.nju.umr.vo.DiaryVO;
import edu.nju.umr.vo.DriverVO;
import edu.nju.umr.vo.GoodVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ShelfVO;
import edu.nju.umr.vo.StockVO;
import edu.nju.umr.vo.UserVO;
import edu.nju.umr.vo.VanVO;
import edu.nju.umr.vo.WorkVO;
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
	//账户
	public static AccountVO toAccountVO(AccountPO po){
		AccountVO vo=new AccountVO(po.getName(), po.getBalance());
		return vo;
	}
	public static AccountPO toAccountPO(AccountVO vo,int id){
		AccountPO po=new AccountPO(id, vo.getName(), vo.getBalance());
		return po;
	}
	//城市
	public static CityVO toCityVO(CityPO po){
		CityVO vo=new CityVO(po.getName(), po.getId(), po.getProvince());
		return vo;
	}
	public static CityPO toCityPO(CityVO vo,int key){
		CityPO po=new CityPO(vo.getName(), vo.getId(),vo.getProvince(),key );
		return po;
	}
	
	//两个城市
	public static CitiesVO toCitiesVO(CitiesPO po){
		CitiesVO vo=new CitiesVO(po.getCity1(), po.getCity2(), po.getDistance());
		return vo;
	}
	public static CitiesPO toCitiesPO(CitiesVO vo){
		CitiesPO po=new CitiesPO(vo.getCity1(),vo.getCity2(), vo.getDistance());
		return po;
	}
	//常量
	public static ConstantVO toConstantVO(ConstantPO po){
		ConstantVO vo=new ConstantVO(po.getMaxLoadPlane(), po.getMaxLoadTrain(), po.getMaxLoadVan(), po.getPricePlane(), po.getPriceTrain(), po.getPriceVan(), po.getLvEco(), po.getLvStd(), po.getLvVip());
		return vo;
	}
	public static ConstantPO toConstantPO(ConstantVO vo){
		ConstantPO po=new ConstantPO(vo.getMaxLoadPlane(), vo.getMaxLoadTrain(), vo.getMaxLoadVan(), vo.getPricePlane(), vo.getPriceTrain(), vo.getPriceVan(), vo.getLvEco(), vo.getLvStd(), vo.getLvVip());
		return po;
	}
	
	//账  待完善！！！
	public static CountVO toCountVO(CountPO po){
		ArrayList<OrgPO> orgp=po.getOrganizations();
		ArrayList<OrgVO> orgv=new ArrayList<OrgVO>();
		for(OrgPO op:orgp){
			OrgVO ov=VPFactory.toOrgVO(op);
			orgv.add(ov);
		}
		ArrayList<WorkPO> workp=po.getWorkers();
		ArrayList<WorkVO> workv=new ArrayList<WorkVO>();
		for(WorkPO wp:workp){
			WorkVO wv=VPFactory.toWorkVO(wp);
			workv.add(wv);
		}
		ArrayList<VanPO> vanp=po.getVans();
		ArrayList<VanVO> vanv=new ArrayList<VanVO>();
		for(VanPO vp:vanp){
			VanVO vv=VPFactory.toVanVO(vp);
			vanv.add(vv);
		}
		ArrayList<StockPO> stockp=po.getStocks();
		ArrayList<StockVO> stockv=new ArrayList<StockVO>();
		for(StockPO sp:stockp){
			StockVO sv=VPFactory.toStockVO(sp);
			stockv.add(sv);
		}
		ArrayList<AccountPO> accountp=po.getAccounts();
		ArrayList<AccountVO> accountv=new ArrayList<AccountVO>();
		for(AccountPO ap:accountp){
			AccountVO av=VPFactory.toAccountVO(ap);
			accountv.add(av);
		}
		CountVO vo=new CountVO(0, orgv, workv, vanv, stockv, accountv, po.getOpTime());//时间不明,id类型不一致，待修改
		return vo;	
	}
	public static CountPO toCountPO(CountVO vo){
		return null;
	}
	
	//日志
	public static DiaryVO toDiaryVO(DiaryPO po){
		DiaryVO vo=new DiaryVO(po.getOperator(), po.getOperation(), po.getTime());
		return vo;
	}
	public static DiaryPO toDiaryPO(DiaryVO vo){
		DiaryPO po =new DiaryPO(vo.getOperation(), vo.getTime(), vo.getOperator());
		return po;
	}
	
	//司机
	public static DriverVO toDriverVO(DriverPO po){
		DriverVO vo=new DriverVO(po.getId(), po.getName(), po.getBirthday(), po.getIdNum(), po.getMobile(), po.getSex(), po.getDriveStart(), po.getDriveEnd(), po.getHallId());
		return vo;
	}
	public static DriverPO toDriverPO(DriverVO vo){
		DriverPO po=new DriverPO(vo.getId(),vo.getIdNum(),vo.getBirthday(),vo.getIdNum(),vo.getMobile(),vo.getSex(),vo.getDriveStart(),vo.getDriveEnd(),vo.getHallId());
		return po;
	}
	
	//货物
	public static GoodVO toGoodVO(GoodPO po){
		GoodVO vo=new GoodVO(po.getId(), po.getDate(), po.getCity(), po.getPart(), po.getShelf(), po.getRow(), po.getPlace());
		return vo;
	}
	public static GoodPO toGoodPO(GoodVO vo,String stockId){
		GoodPO po=new GoodPO(vo.getId(),stockId , vo.getDate(),vo.getCity(),vo.getPart(),vo.getShelf(),vo.getRow(),vo.getPlace());
		return po;
	}
	
	//机构
	public static OrgVO toOrgVO(OrgPO po){
		OrgVO vo=new OrgVO(po.getId(), po.getName(), po.getKind(), po.getLocation(), po.getCity(), po.getCityId());
		return vo;
	}
	public static OrgPO toOrgPO(OrgVO vo){
		OrgPO po=new OrgPO(vo.getId(), vo.getName(), vo.getKind(), vo.getLocation(), vo.getCity(), vo.getCityId());
		return po;
	}
	
	//架
	public ShelfVO toShelfVO(ShelfPO po){
		ShelfVO vo=new ShelfVO(po.getId(), po.getRow(), po.getPlace(), po.getPart());
		return vo;
	}
	public ShelfPO toShelfPO(ShelfVO vo,String stockId){
		ShelfPO po=new ShelfPO(vo.getId(),stockId , vo.getRow(), vo.getPlace(), vo.getPart());
		return po;
	}
	
	//库存
	public static StockVO toStockVO(StockPO po){
		ArrayList<GoodPO> goodp=po.getGoods();
		ArrayList<GoodVO> goodv=new ArrayList<GoodVO>();
		for(GoodPO good:goodp){
			GoodVO gd=VPFactory.toGoodVO(good);
			goodv.add(gd);
		}
		StockVO vo=new StockVO(goodv, po.getStockId());
		return vo;
	}
	public static StockPO toStockPO(StockVO vo){
		ArrayList<GoodVO> goodv=vo.getGoods();
		ArrayList<GoodPO> goodp=new ArrayList<GoodPO>();
		for(GoodVO gv:goodv){
			GoodPO gp=VPFactory.toGoodPO(gv, vo.getStockId());
			goodp.add(gp);
		}
		StockPO po=new StockPO(vo.getStockId(), goodp);
		return po;
	}
	
	//用户
	public static UserVO toUserVO(UserPO po){
		UserVO vo=new UserVO(po.getId(), po.getPassword(), po.getJuri(), po.getName(), po.getMobile(), po.getOrg(), po.getOrgId());
		return vo;
	}
	public static UserPO toUserPO(UserVO vo,int key){
		UserPO po=new UserPO(vo.getId(),vo.getPassword(),vo.getJuri(),vo.getName(),vo.getMobile(),vo.getOrg(),key,vo.getOrgId());
		return po;
	}
	
	//车辆
	public static VanVO toVanVO(VanPO po){
		VanVO vo=new VanVO(po.getId(), po.getPlateNum(), po.getServTime(), po.getPhoto(), po.getHallId());
		return vo;
	}
	public static VanPO toVanPO(VanVO vo){
		VanPO po=new VanPO(vo.getId(), vo.getPlateNum(), vo.getServTime(), vo.getPhoto(), vo.getHallId());
		return po;
	}
	
	//工作人员
	public static WorkVO toWorkVOCommit(WorkPO po){
		WorkVO vo=new WorkVO(po.getName(), po.getMobile(), po.getOrg(), po.getOrgId(), po.getJuri(), po.getKind(), po.getMoney(), po.getCommission());
		return vo;
	}
	public static WorkVO toWorkVO(WorkPO po){
		WorkVO vo=new WorkVO(po.getName(), po.getMobile(), po.getOrg(), po.getOrgId(), po.getJuri(), po.getKind(), po.getMoney());
		return vo;
	}
	public static WorkPO toWorkPO(WorkVO vo,int id){
		WorkPO po=new WorkPO(vo.getName(), vo.getMobile(), vo.getOrg(), vo.getOrgId(), id, vo.getJuri(), vo.getKind(), vo.getMoney(), vo.getCommission());
		return po;
	}
}