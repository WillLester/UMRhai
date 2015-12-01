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
import edu.nju.umr.po.GoodPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.AccountVO;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.GoodVO;
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
		ArrayList<CityVO> cityList = new ArrayList<CityVO>();
		try {
			ArrayList<CityPO> cities = utilityData.getCities();
			for(CityPO city:cities){
				CityVO vo = new CityVO(city.getName(), city.getId(),city.getProvince());
				cityList.add(vo);
//				return new ResultMessage(Result.SUCCESS, cityList);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		return new ResultMessage(Result.SUCCESS, cityList);
	}
	public ResultMessage getOrgs(){
		ArrayList<OrgPO> ar= null;
		Result isSuccessful=Result.NET_INTERRUPT;
		try{
			ar=utilityData.getOrgs();
			isSuccessful=Result.SUCCESS;
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		ArrayList<OrgVO> arVO=new ArrayList<OrgVO>();
		for(int i=0;i<ar.size();i++)
		{
			OrgPO Org=ar.get(i);
			arVO.add(new OrgVO(Org.getId(),Org.getName(),Org.getKind(),Org.getLocation(),Org.getCity(),Org.getCityId()));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}
	public ResultMessage getHall() {
		// TODO 自动生成的方法存根
		ArrayList<OrgVO> hallList = new ArrayList<OrgVO>();
		Result re=Result.NET_INTERRUPT;
		try {
			ArrayList<OrgPO> halls = utilityData.getHall();
			re=Result.SUCCESS;
			for(OrgPO hall:halls){
//				CityVO city = new CityVO(hall.getCity(), hall.getCityId(),hall.getCity().getProvince());
				OrgVO vo = new OrgVO(hall.getId(), hall.getName(), hall.getKind(), hall.getLocation(), hall.getCity(), hall.getCityId());
				hallList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return new ResultMessage(re, hallList);
	}
	public ResultMessage getCenter(){
		ArrayList<OrgVO> centerList=new ArrayList<OrgVO>();
		Result re=Result.DATA_NOT_FOUND;
		ArrayList<OrgPO> centers=new ArrayList<OrgPO>();
		try {
			centers=utilityData.getCenters();
			if(centers.size()>0)
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
		Result isSuccessful=Result.NET_INTERRUPT;
		try{
			ar=utilityData.getWorkers("");
			isSuccessful=Result.SUCCESS;
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		ArrayList<WorkVO> arVO=new ArrayList<WorkVO>();
		for(int i=0;i<ar.size();i++)
		{
			WorkPO Work=ar.get(i);
			arVO.add(new WorkVO(Work.getName(),Work.getMobile(),Work.getOrg(),Work.getOrgId(),Work.getJuri(),Work.getKind(),Work.getMoney(),Work.getCommission()));
		}
		ResultMessage message = new ResultMessage(isSuccessful, arVO);
		return message;
	}
	public ResultMessage getVans(String orgId){
		ArrayList<VanVO> vanList = new ArrayList<VanVO>();
		try {
			ArrayList<VanPO> van = utilityData.getVans(orgId);
			for(VanPO po:van){
				VanVO vo = VPFactory.toVanVO(po);
				vanList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return new ResultMessage(Result.SUCCESS, vanList);
	}
	public ResultMessage getStocks(){
		ArrayList<StockVO> stockList = new ArrayList<StockVO>();
		ArrayList<StockPO> stock;
		try {
			stock = utilityData.getStocks();
			for(StockPO po:stock){
				StockVO vo = VPFactory.toStockVO(po);
				stockList.add(vo);				
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return new ResultMessage(Result.NET_INTERRUPT,null);
		}
		return new ResultMessage(Result.SUCCESS, stockList);
	}
	public ResultMessage getAccount() {
		ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();
		Result re=Result.NET_INTERRUPT;
		try {
			ArrayList<AccountPO> account = utilityData.getAccount();
			re=Result.SUCCESS;
			for(AccountPO po:account){
				AccountVO vo = new AccountVO(po.getName(), po.getBalance());
				accountList.add(vo);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return new ResultMessage(re, accountList);
	}

	public static Result setRecord(Calendar cal,String op,String opt){
		Result isSuc=Result.SUCCESS;
		try
		{
			UtilityDFacSer dataFac=(UtilityDFacSer)Naming.lookup("rmi://localhost:8885/DataFactory");
			UtilityDSer data=dataFac.getUtility();
			isSuc=data.setRecord(cal, op, opt);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return isSuc;
	}
	//导出excel文件
	public Result outputExcel(String data[][],String name, String location) {
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
	
	public ArrayList<CityPO> cities(){
		ArrayList<CityPO> city=null;
		try {
			city=utilityData.getCities();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return city;
	}
	
	public ArrayList<OrgPO> orgs(){
		ArrayList<OrgPO> org=null;
		try {
			org=utilityData.getOrgs();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return org;
	}
	
	public ArrayList<OrgPO> halls(){
		ArrayList<OrgPO> hall=null;
		try {
			hall=utilityData.getHall();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hall;
	}
	
	public ArrayList<WorkPO> works(String orgId){
		ArrayList<WorkPO> work=null;
		try {
			work=utilityData.getWorkers(orgId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return work;
	}
	
	public ArrayList<VanPO> vans(String orId){
		ArrayList<VanPO> van=null;
		try {
			van=utilityData.getVans(orId);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return van;
	}
	
	public ArrayList<StockPO> stocks(){
		ArrayList<StockPO> stock=null;
		try {
			stock=utilityData.getStocks();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stock;
	}
	
	public ArrayList<AccountPO> accounts(){
		ArrayList<AccountPO> account=null;
		try {
			account=utilityData.getAccount();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return account;
	}
	
}
