package edu.nju.umr.logic.utilityLogic;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import edu.nju.umr.dataService.dataFactory.utility.UtilityDFacSer;
import edu.nju.umr.dataService.utilityDSer.UtilityDSer;
import edu.nju.umr.logicService.utilityLogicSer.UtilityLSer;
import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.CityPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.StockVO;
import edu.nju.umr.vo.VanVO;
import edu.nju.umr.vo.WorkVO;

public class UtilityLogic implements UtilityLSer{
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
	
	@Override
	public ResultMessage getCities(){
		Result isSuc=Result.DATA_NOT_FOUND;
		List<CityVO> cityList = new ArrayList<CityVO>();
		try {
			ArrayList<CityPO> cities = utilityData.getCities();
			isSuc=Result.SUCCESS;
			for(CityPO city:cities){
				CityVO vo = VPFactory.toCityVO(city);
				cityList.add(vo);
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
		List<OrgVO> arVO=new ArrayList<OrgVO>();
		for(int i=0;i<ar.size();i++)
		{
			OrgPO Org=ar.get(i);
			arVO.add(VPFactory.toOrgVO(Org));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}
	
	@Override
	public ResultMessage getHall() {
		// TODO 自动生成的方法存根
		List<OrgVO> hallList = new ArrayList<OrgVO>();
		Result re=Result.DATA_NOT_FOUND;
		try {
			ArrayList<OrgPO> halls = utilityData.getHall();			
			re=Result.SUCCESS;
			for(OrgPO hall:halls){
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
	
	@Override
	public ResultMessage getCenter(){
		List<OrgVO> centerList=new ArrayList<OrgVO>();
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
				if(i==0)
					cell.setCellStyle(style);//表头格式居中
			}
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
	
	public List<OrgPO> orgs(){
		List<OrgPO> org=new ArrayList<OrgPO>();
		try {
			org=utilityData.getOrgs();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return org;
		}
		return org;
	}
	
	public ArrayList<OrgPO> centers(){
		ArrayList<OrgPO> centers=null;
		try {
			centers=utilityData.getCenters();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ArrayList<OrgPO>();
		}
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
	
	@Override
	@SuppressWarnings("unchecked")
	public ResultMessage getLocalHallAndAllCenter(String orgId){
		Result isSuc=Result.DATA_NOT_FOUND;
		ArrayList<OrgPO> halls=new ArrayList<OrgPO>();//获取营业厅列表
		ArrayList<OrgVO> localHalls=new ArrayList<OrgVO>();//用来存储本城市营业厅列表
		List<OrgPO> orgs=new ArrayList<OrgPO>();//获取总的机构列表
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
		if(centers.size()!=0||localHalls.size()!=0){
			isSuc=Result.SUCCESS;
		}
		localHalls.addAll(centers);
		//返回名称的数组
		String[] names=new String[localHalls.size()];
		for(int i=0;i<localHalls.size();i++){
			names[i]=localHalls.get(i).getName();
		}
		return new ResultMessage(isSuc,names);
	}
	
	@Override
	/**
	 * 获得快递员列表
	 * @param id 营业厅编号
	 * @return ArrayList<String>表示的快递员列表
	 */
	public List<String> getCouriers(String id){
		ArrayList<WorkPO> couriers;
		try {
			couriers = utilityData.getCouriers(id);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ArrayList<String>();
		}
		List<String> cour=new ArrayList<String>();
		for(WorkPO c:couriers){
			cour.add(c.getName());
		}
		return cour;
	}
	
	@Override
	//返回给界面名称数组的一系列方法
	public ResultMessage getOrgNames(){//机构名称
		List<OrgPO> orgList=new ArrayList<OrgPO>();
		orgList=orgs();
		String[] orgName=new String[orgList.size()];
		for(int i=0;i<orgList.size();i++){
			orgName[i]=orgList.get(i).getName();
		}
		return new ResultMessage(Result.SUCCESS,orgName);
	}
	
	@Override
	public ResultMessage getVanNames(String orgId) {//车辆代号
		ArrayList<VanPO> vanList=new ArrayList<VanPO>();
		try {
			vanList=vans(orgId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		String[] vanId=new String[vanList.size()];
		for(int i=0;i<vanList.size();i++){
			vanId[i]=vanList.get(i).getId();
		}
		return new ResultMessage(Result.SUCCESS,vanId);
	}
	
	public ResultMessage getAccountNames() {
		ArrayList<AccountPO> accountList=new ArrayList<AccountPO>();
		try {
			accountList =accounts();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		String[] accountName=new String[accountList.size()];
		for(int i=0;i<accountList.size();i++){
			accountName[i]=accountList.get(i).getName();
		}
		return new ResultMessage(Result.SUCCESS,accountName);
	}

	@Override
	public ResultMessage getCenterNames() {
		// TODO 自动生成的方法存根
		ResultMessage message = getCenter();
		if(message.getReInfo() == Result.SUCCESS){
			@SuppressWarnings("unchecked")
			List<OrgVO> orgs = (List<OrgVO>) message.getMessage();
			String[] orgS = new String[orgs.size()];
			for(int i = 0;i < orgs.size();i++){
				orgS[i] = orgs.get(i).getName();
			}
			return new ResultMessage(Result.SUCCESS, orgS);
		} else {
			return message;
		}
	}
}
