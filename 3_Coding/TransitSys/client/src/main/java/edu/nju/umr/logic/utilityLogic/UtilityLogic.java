package edu.nju.umr.logic.utilityLogic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import edu.nju.umr.constants.Url;
import edu.nju.umr.dataService.dataFactory.UtilityDFacSer;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CitiesPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.ConstantPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.po.enums.Transit;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.StockVO;
import edu.nju.umr.vo.VanVO;
import edu.nju.umr.vo.WorkVO;

public class UtilityLogic {
	private UtilityDSer utilityData;
	private UtilityDFacSer dataFac;
	public UtilityLogic() {
		// TODO 自动生成的构造函数存根
		try {
			dataFac = (UtilityDFacSer) Naming.lookup(Url.URL);
			utilityData = dataFac.getUtility();
		} catch (NotBoundException e) { 
            e.printStackTrace(); 
        } catch (MalformedURLException e) { 
            e.printStackTrace(); 
        } catch (RemoteException e) { 
            e.printStackTrace();   
        }  
	}
	public ResultMessage getCities(){
		Result isSuc=Result.DATA_NOT_FOUND;
		ArrayList<CityVO> cityList = new ArrayList<CityVO>();
		try {
			ArrayList<CityPO> cities = utilityData.getCities();
			isSuc=Result.SUCCESS;
			for(CityPO city:cities){
				CityVO vo = VPFactory.toCityVO(city);
				cityList.add(vo);
//				return new ResultMessage(Result.SUCCESS, cityList);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		return new ResultMessage(isSuc, cityList);
	}
	public ResultMessage getOrgs(){
		ArrayList<OrgPO> ar= null;
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			ar=utilityData.getOrgs();
		    isSuccessful=Result.SUCCESS;
		}
		catch(RemoteException e){
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}
		ArrayList<OrgVO> arVO=new ArrayList<OrgVO>();
		for(int i=0;i<ar.size();i++)
		{
			OrgPO Org=ar.get(i);
			arVO.add(VPFactory.toOrgVO(Org));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}
	public ResultMessage getHall() {
		// TODO 自动生成的方法存根
		ArrayList<OrgVO> hallList = new ArrayList<OrgVO>();
		Result re=Result.DATA_NOT_FOUND;
		try {
			ArrayList<OrgPO> halls = utilityData.getHall();			
			re=Result.SUCCESS;
			for(OrgPO hall:halls){
//				CityVO city = new CityVO(hall.getCity(), hall.getCityId(),hall.getCity().getProvince());
				OrgVO vo = VPFactory.toOrgVO(hall);
				hallList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		return new ResultMessage(re, hallList);
	}
	public ResultMessage getCenter(){
		ArrayList<OrgVO> centerList=new ArrayList<OrgVO>();
		Result re=Result.DATA_NOT_FOUND;
		ArrayList<OrgPO> centers=new ArrayList<OrgPO>();
		try {
			centers=utilityData.getCenters();
			re=Result.SUCCESS;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		for(OrgPO po:centers){
			OrgVO vo=VPFactory.toOrgVO(po);
			centerList.add(vo);
		}
		return new ResultMessage(re,centerList);
	}
	public ResultMessage getWorkers(String orgId){
		ArrayList<WorkPO> ar= null;
		Result isSuccessful=Result.DATA_NOT_FOUND;
		try{
			ar=utilityData.getWorkers(orgId);
			isSuccessful=Result.SUCCESS;
		}
		catch(RemoteException e){
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		ArrayList<WorkVO> arVO=new ArrayList<WorkVO>();
		for(int i=0;i<ar.size();i++)
		{
			WorkPO Work=ar.get(i);
			arVO.add(VPFactory.toWorkVO(Work));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}
	public ResultMessage getVans(String orgId){
		ArrayList<VanVO> vanList = new ArrayList<VanVO>();
		Result isSuc=Result.DATA_NOT_FOUND;
		try {
			ArrayList<VanPO> van = utilityData.getVans(orgId);
			isSuc=Result.SUCCESS;
			for(VanPO po:van){
				VanVO vo = VPFactory.toVanVO(po);
				vanList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}
		
		return new ResultMessage(isSuc, vanList);
	}
	public ResultMessage getStocks(){
		ArrayList<StockVO> stockList = new ArrayList<StockVO>();
		ArrayList<StockPO> stock=new ArrayList<StockPO>();
		Result isSuc=Result.DATA_NOT_FOUND;
		try {
			stock = utilityData.getStocks();
			isSuc=Result.SUCCESS;
			for(StockPO po:stock){
				StockVO vo = VPFactory.toStockVO(po);
				stockList.add(vo);				
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		return new ResultMessage(isSuc, stockList);
	}
	public ResultMessage getAccount() {
		ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();
		Result re=Result.DATA_NOT_FOUND;
		try {
			ArrayList<AccountPO> account = utilityData.getAccount();
			re=Result.SUCCESS;
			for(AccountPO po:account){
				AccountVO vo = VPFactory.toAccountVO(po);
				accountList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		
		return new ResultMessage(re, accountList);
	}

	public static Result setRecord(Calendar cal,String op,String opt){
		Result isSuc=Result.SUCCESS;
		
			UtilityDFacSer dataFac;
			try {
				dataFac = (UtilityDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
				UtilityDSer data=dataFac.getUtility();
				isSuc=data.setRecord(cal, op, opt);
			} catch (MalformedURLException e) {
				
				e.printStackTrace();
			} catch (RemoteException e) {
				e.printStackTrace();
				return Result.NET_INTERRUPT;
			} catch (NotBoundException e) {
				e.printStackTrace();
				return Result.DATA_NOT_FOUND;
			}
			
		
		return isSuc;
	}
	//导出excel文件
	public Result outputExcel(String data[][],String name, String location) {
		@SuppressWarnings("resource")
		HSSFWorkbook wb=new HSSFWorkbook();//创建一个workbook对应一个excel文件
		HSSFSheet sheet=wb.createSheet(name);//在wb中添加一个sheet对应excel中sheet
		
		HSSFCellStyle style=wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		
		for(int i=0;i<data.length;i++){
			HSSFRow row=sheet.createRow((int)i);//创建表格第i行
			for(int j=0;j<data[0].length;j++){
				HSSFCell cell=row.createCell(j);	
				cell.setCellValue(data[i][j]);
//				System.out.print(data[i][j]+" ");
				if(i==0)
					cell.setCellStyle(style);//表头格式居中
			}
//			System.out.println();
		}
		
		try {
			FileOutputStream fout=new FileOutputStream(location+name+".xls");
			wb.write(fout);
			fout.close();
		} catch (FileNotFoundException e) {
			return Result.FILE_NOT_FOUND;
		} catch (IOException e) {
			e.printStackTrace();
			return Result.FILE_NOT_FOUND;
		}
		return Result.SUCCESS;
	}
	
	//返回po的一系列方法
	
	public ArrayList<CityPO> cities() throws RemoteException{
		ArrayList<CityPO> city=new ArrayList<CityPO>();
		city=utilityData.getCities();
		return city;
	}
	
	public ArrayList<OrgPO> orgs() throws RemoteException{
		ArrayList<OrgPO> org=new ArrayList<OrgPO>();
		org=utilityData.getOrgs();
		return org;
	}
	
	public ArrayList<OrgPO> centers() throws RemoteException{
		ArrayList<OrgPO> centers=null;
		centers=utilityData.getCenters();
		return centers;
	}
	 
	public ArrayList<OrgPO> halls() throws RemoteException{
		ArrayList<OrgPO> hall=new ArrayList<OrgPO>();
		hall=utilityData.getHall();
		return hall;
	}
	
	public ArrayList<WorkPO> works(String orgId) throws RemoteException{
		ArrayList<WorkPO> work=new ArrayList<WorkPO>();
		work=utilityData.getWorkers(orgId);
		return work;
	}
	
	public ArrayList<VanPO> vans(String orId) throws RemoteException{
		ArrayList<VanPO> van=new ArrayList<VanPO>();
		van=utilityData.getVans(orId);
		return van;
	}
	
	public ArrayList<StockPO> stocks() throws RemoteException{
		ArrayList<StockPO> stock=new ArrayList<StockPO>();
		stock=utilityData.getStocks();
		return stock;
	}
	
	public ArrayList<AccountPO> accounts() throws RemoteException{
		ArrayList<AccountPO> account=new ArrayList<AccountPO>();
		account=utilityData.getAccount();
		return account;
	}
	
	@SuppressWarnings("unchecked")
	public ResultMessage getLocalHallAndAllCenter(String orgId){
		Result isSuc=Result.DATA_NOT_FOUND;
		ArrayList<OrgPO> halls=new ArrayList<OrgPO>();//获取营业厅列表
		ArrayList<OrgVO> localHalls=new ArrayList<OrgVO>();//用来存储本城市营业厅列表
		ArrayList<OrgPO> orgs=new ArrayList<OrgPO>();//获取总的机构列表
		String city=null;//存储本地营业厅所在的城市名称
		ArrayList<OrgVO> centers=new ArrayList<OrgVO>();//获取所有的中转中心列表
		try {
			halls = halls();
			orgs=orgs();
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		for(OrgPO po:orgs){
			if(po.getId().equals(orgId)){
				city=po.getCity();
				break;
			}
		}
		for(OrgPO hall:halls){
			if(hall.getCity().equals(city)){
				OrgVO vo=VPFactory.toOrgVO(hall);
				localHalls.add(vo);
			}		
		}
		Object temp=getCenter().getMessage();
		if(temp==null){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}else{
			centers=(ArrayList<OrgVO>)temp;
		}
		if(centers.size()!=0||localHalls.size()!=0)
			isSuc=Result.SUCCESS;
		return new ResultMessage(isSuc,localHalls.addAll(centers));
	}
	
	public ArrayList<String> getCouriers(String id) throws RemoteException{
		ArrayList<WorkPO> couriers=utilityData.getCouriers(id);
		ArrayList<String> cour=new ArrayList<String>();
		for(WorkPO c:couriers){
			cour.add(c.getName());
		}
		return cour;
	}
	
	/**
	 * 判断中转单是否存在
	 * @param id 中转单的编号
	 * @return 判断结果
	 */
	public boolean isTransitValid(String id){
		try {
			return utilityData.isTransitValid(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}
	
	/**
	 * 获得订单运费（经济，标准，特快）
	 * @return 价格List，目前是Array，按经济，标准和特快的顺序排,数值是double
	 */
	public ResultMessage getExpressCost() {
		// TODO 自动生成的方法存根
		try {
			ConstantPO constant = utilityData.getConstant();
			if(constant == null){
				return new ResultMessage(Result.DATA_NOT_FOUND, null);
			} else {
				List<Double> costs = new ArrayList<Double>();
				costs.add(constant.getLvEco());
				costs.add(constant.getLvStd());
				costs.add(constant.getLvVip());
				return new ResultMessage(Result.SUCCESS, costs);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}
	}
	
	/**
	 * 获得运费额（飞机，铁路，公路）
	 * @return List,目前是Array，按照飞机、铁路、公路排序的运费，数值是double
	 */
	public ResultMessage getTransitCost(){
		try {
			ConstantPO constant = utilityData.getConstant();
			if(constant == null){
				return new ResultMessage(Result.DATA_NOT_FOUND, null);
			} else {
				List<Double> costs = new ArrayList<Double>();
				costs.add(constant.getPricePlane());
				costs.add(constant.getPriceTrain());
				costs.add(constant.getPriceVan());
				return new ResultMessage(Result.SUCCESS, costs);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}
	}
	
	/**
	 * 获得满载量（飞机、铁路、公路）
	 * @return List，目前是Array,按照飞机、铁路、公路排，数值是double
	 */
	public ResultMessage getFullLoad(){
		try {
			ConstantPO constant = utilityData.getConstant();
			if(constant == null){
				return new ResultMessage(Result.DATA_NOT_FOUND, null);
			} else {
				List<Double> load = new ArrayList<Double>();
				load.add(constant.getMaxLoadPlane());
				load.add(constant.getMaxLoadTrain());
				load.add(constant.getMaxLoadVan());
				return new ResultMessage(Result.SUCCESS, load);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ResultMessage(Result.NET_INTERRUPT, null);
		}
	}
	
	/**
	 * 检查订单编号是否存在
	 * @param id 订单编号
	 * @return 结果
	 */
	public boolean isExpressValid(String id){
		try {
			return utilityData.isExpressValid(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}
	
	/**
	 * 检查中转中心装车单是否存在
	 * @param id 装车单编号
	 * @return 结果
	 */
	public boolean isCenterLoadValid(String id){
		try {
			return utilityData.isCenterLoadValid(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}
	
	/**
	 * 检查订单列表中各订单号是否存在
	 * @param expressList 订单列表，List形式
	 * @return 有错误的第一个订单的index（0-base），如果没有错误则返回-1。
	 */
	public int isExpressListValid(List<String> expressList){
		for(int i = 0;i < expressList.size();i++){
			if(!isExpressValid(expressList.get(i))){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * 获得两个城市之间的距离
	 * @param city1 城市1
	 * @param city2 城市2
	 * @return 城市之间的距离 类型是BigDecimal，考虑到精度问题。如果没有，则返回。若网络错误，返回null
	 */
	public BigDecimal getDistance(String city1,String city2){
		CitiesPO cities = null;
		try {
			cities = utilityData.getCitesPO(city1, city2);
			if(cities == null){
				return new BigDecimal(0);
			} else {
				return new BigDecimal(cities.getDistance());
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return null;
		}
	}
	
	/**
	 * 获得机构之间的运费
	 * @param org1 机构1
	 * @param org2 机构2
	 * @param transit Transit类型，飞机，铁路，公路
	 * @param weight 总重量 BigDecimal
	 * @see edu.nju.umr.po.enums.Transit
	 * @return
	 */
	public ResultMessage getPrice(String org1, String org2,Transit transit,BigDecimal weight) {
		String city1=null;
		String city2=null;//两个机构所属城市名称
		ArrayList<OrgPO> orgs=new ArrayList<OrgPO>();//获取机构列表
		BigDecimal distance= new BigDecimal(0);//城市间距离
		BigDecimal price = new BigDecimal(0);//城市间价格
		ResultMessage costMessage = getTransitCost();
		if(!costMessage.getReInfo().equals(Result.SUCCESS)){
			return costMessage;
		}
		@SuppressWarnings("unchecked")
		ArrayList<Double> temp=(ArrayList<Double>)costMessage.getMessage();
		double cost = temp.get(transit.ordinal());
		Result isSuc=Result.DATA_NOT_FOUND;
		try {
			orgs = orgs();
		} catch (RemoteException e) {
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		if(orgs.size()>0){
			isSuc=Result.SUCCESS;
		}
		//获得两个机构所在城市名称
		for(OrgPO po:orgs){
			if(po.getName()==org1){
				city1=po.getCity();
				break;
			}
		}
		for(OrgPO po:orgs){
			if(po.getName()==org2){
				city2=po.getCity();
			    break;
			}
		}
		//两机构在同一城市
		if(city1.equals(city2))
			return new ResultMessage(Result.SUCCESS,100);//固定值暂定为100
		//不在同一城市
		try{
			distance= getDistance(city1, city2);
		}catch(Exception e){
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		price= new BigDecimal(cost);
		return new ResultMessage(isSuc,distance.multiply(price));
	}
	
	/**
	 * 根据订单列表获得总重量
	 * @param expressList List<String>形式的订单号列表
	 * @return ResultMessage，包含了一个BigDecimal形式的总重量
	 */
	public ResultMessage getTotalWeight(List<String> expressList){
		return null;
	}
}
