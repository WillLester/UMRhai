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
	public ArrayList<CityPO> getCities(){
//		ArrayList<CityVO> cityList = new ArrayList<CityVO>();
		ArrayList<CityPO> cities=null;
		try {
			cities = utilityData.getCities();
			
//			for(CityPO city:cities){
//				CityVO vo = new CityVO(city.getName(), city.getId(),city.getProvince());
//				cityList.add(vo);
//				return new ResultMessage(Result.SUCCESS, cityList);
//			}
		} catch (RemoteException e) {
			e.printStackTrace();
//			return null;
		}
		return cities;
//		return new ResultMessage(Result.SUCCESS, cityList);
	}
	public ArrayList<OrgPO> getOrgs(){
		ArrayList<OrgPO> ar= null;
//		Result isSuccessful=Result.NET_INTERRUPT;
		try{
			ar=utilityData.getOrgs();
//			isSuccessful=Result.SUCCESS;
		}
		catch(RemoteException e){
			e.printStackTrace();
//			return null;
		}
		return ar;
//		ArrayList<OrgVO> arVO=new ArrayList<OrgVO>();
//		for(int i=0;i<ar.size();i++)
//		{
//			OrgPO Org=ar.get(i);
//			arVO.add(new OrgVO(Org.getId(),Org.getName(),Org.getKind(),Org.getLocation(),Org.getCity(),Org.getCityId()));
//		}
//		ResultMessage message = new ResultMessage(isSuccessful, arVO);
//		return message;
	}
	public ArrayList<OrgPO> getHall() {
		// TODO 自动生成的方法存根
//		ArrayList<OrgVO> hallList = new ArrayList<OrgVO>();
//		Result re=Result.NET_INTERRUPT;
		ArrayList<OrgPO> halls=null;
		try {
			halls = utilityData.getHall();
			
//			re=Result.SUCCESS;
//			for(OrgPO hall:halls){
////				CityVO city = new CityVO(hall.getCity(), hall.getCityId(),hall.getCity().getProvince());
//				OrgVO vo = new OrgVO(hall.getId(), hall.getName(), hall.getKind(), hall.getLocation(), hall.getCity(), hall.getCityId());
//				hallList.add(vo);
//			}
		} catch (RemoteException e) {
			e.printStackTrace();
//			return null;
		}
		return halls;
//		return new ResultMessage(re, hallList);
	}
	public ArrayList<WorkPO> getWorkers(String orgId){
		ArrayList<WorkPO> ar= null;
//		Result isSuccessful=Result.NET_INTERRUPT;
		try{
			ar=utilityData.getWorkers(orgId);
//			isSuccessful=Result.SUCCESS;
		}
		catch(RemoteException e){
			e.printStackTrace();
		}
		return ar;
//		ArrayList<WorkVO> arVO=new ArrayList<WorkVO>();
//		for(int i=0;i<ar.size();i++)
//		{
//			WorkPO Work=ar.get(i);
//			arVO.add(new WorkVO(Work.getName(),Work.getMobile(),Work.getOrgId(),Work.getJuri(),Work.getKind(),Work.getMoney(),Work.getCommission()));
//		}
//		ResultMessage message = new ResultMessage(isSuccessful, arVO);
//		return message;
	}
	public ArrayList<VanPO> getVans(String orgId){
//		ArrayList<VanVO> vanList = new ArrayList<VanVO>();
		ArrayList<VanPO> van=null;
		try {
			van = utilityData.getVans(orgId);
//			for(VanPO po:van){
//				VanVO vo = new VanVO(po.getId(), po.getPlateNum(), po.getServTime(), po.getPhoto());
//				vanList.add(vo);
//			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return van;
	}
	public ArrayList<StockPO> getStocks(){
//		ArrayList<StockVO> stockList = new ArrayList<StockVO>();
		ArrayList<StockPO> stock=null;
		try {
			stock = utilityData.getStocks();
//			for(StockPO po:stock){
//				ArrayList<GoodVO> goodList = new ArrayList<GoodVO>();
//				for(GoodPO gPo:po.getGoods()){
//					GoodVO gVo = new GoodVO(gPo.getId(), gPo.getDate(), gPo.getCity(), gPo.getPart(), gPo.getShelf(), gPo.getRow(), gPo.getPlace());
//					goodList.add(gVo);
//				}
//				StockVO vo = new StockVO(goodList);
//				stockList.add(vo);
//			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return stock;
	}
	public ArrayList<AccountPO> getAccount() {
//		ArrayList<AccountVO> accountList = new ArrayList<AccountVO>();
//		Result re=Result.NET_INTERRUPT;
		ArrayList<AccountPO> account=null;
		try {
			account = utilityData.getAccount();
//			re=Result.SUCCESS;
//			for(AccountPO po:account){
//				AccountVO vo = new AccountVO(po.getName(), po.getBalance());
//				accountList.add(vo);
//			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return account;
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
}
