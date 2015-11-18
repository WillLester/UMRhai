package edu.nju.umr.driver;

import java.util.ArrayList;
import java.util.Date;

import edu.nju.umr.logic.stockLogic.StockCheckLogic;
import edu.nju.umr.logic.stockLogic.StockCheckNowLogic;
import edu.nju.umr.logic.stockLogic.StockCheckWarnLogic;
import edu.nju.umr.logic.stockLogic.StockDivideLogic;
import edu.nju.umr.logic.stockLogic.StockWarningLogic;
import edu.nju.umr.logicService.stockLogicSer.StockCheckLSer;
import edu.nju.umr.logicService.stockLogicSer.StockCheckNowLSer;
import edu.nju.umr.logicService.stockLogicSer.StockCheckWarnLSer;
import edu.nju.umr.logicService.stockLogicSer.StockDivideLSer;
import edu.nju.umr.logicService.stockLogicSer.StockWarningLSer;
import edu.nju.umr.po.enums.Part;
import edu.nju.umr.vo.GoodVO;
import edu.nju.umr.vo.ShelfVO;
import edu.nju.umr.vo.StockVO;
import edu.nju.umr.vo.order.StockInVO;
import edu.nju.umr.vo.order.StockOutVO;

public class StockDriver {
	StockCheckLSer check = new StockCheckLogic();
	StockCheckNowLSer checkNow = new StockCheckNowLogic();
	StockCheckWarnLSer checkWarn = new StockCheckWarnLogic();
	StockDivideLSer divide = new StockDivideLogic();
	StockWarningLSer warning = new StockWarningLogic();
	public static void main(String[] args) {
		StockDriver driver = new StockDriver();
		driver.driveCheck();
		driver.driveCheckNow();
		driver.driveCheckWarn();
		driver.driveDivide();
		driver.driveWarning();
	}
	private void driveCheck(){
		ArrayList<StockInVO> stockInList = (ArrayList<StockInVO>) check.checkStockIn(new Date(110,2,23), new Date(110,3,31), "00001").getMessage();
		for(StockInVO vo:stockInList){
			System.out.println( vo.getDate() + " " + vo.getArrivePlace() + " " + vo.getExpressId() + " " + vo.getPart() + " " + vo.getShelfId() + " " + vo.getRow() + " "+ vo.getPlace());
		} 
		ArrayList<StockOutVO> stockOutList = (ArrayList<StockOutVO>) check.checkStockOut(new Date(110,2,23), new Date(110,3,31), "00001").getMessage();
		for(StockOutVO vo:stockOutList){
			System.out.println(vo.getExpressId() + " " + vo.getTransitId() + " " + vo.getDate() + " " + vo.getKind());
		}
	}
	private void driveCheckNow(){
		StockVO stock = (StockVO) checkNow.checkNow("00001").getMessage();
			for(GoodVO good:stock.getGoods()){
				System.out.println(good.getId() + " " + good.getCity() + " " + good.getDate() + " " + good.getPart() + " " + good.getShelf() + " " + good.getRow() +" " + good.getPlace());
				
			}
		System.out.println(checkNow.outputExcel("D:\\", stock));
	}
	private void driveCheckWarn(){
		ArrayList<Integer> warnings = (ArrayList<Integer>) checkWarn.checkWarning("00001").getMessage();
		for(Integer warn:warnings){
			System.out.println(warn);
		}
	}
	private void driveDivide(){
//		ArrayList<ShelfVO> shelfList = (ArrayList<ShelfVO>) divide.shelfList("00001").getMessage();
//		for(ShelfVO shelf:shelfList){
//			System.out.println(shelf.getId() + " " + shelf.getPart() + " " + shelf.getRow() + " " + shelf.getPlace());
//		}
		ShelfVO vo = new ShelfVO("2",3,4,Part.TRAIN);
		System.out.println(divide.addShelf(vo));
		System.out.println(divide.deleteShelf("T10000"));
		System.out.println(divide.reviseShelf(vo));
//		ShelfVO get = (ShelfVO) divide.checkShelf("T10000").getMessage();
//		System.out.println(get.getId() + " " + get.getPart() + " " + get.getRow() + " " + get.getPlace());
	}
	private void driveWarning(){
		System.out.println(warning.setWarning(50, Part.VAN, "00001"));
		ArrayList<Integer> warnings = (ArrayList<Integer>) warning.getWarning("00001").getMessage();
		for(Integer warn:warnings){
			System.out.println(warn);
		}
		
	}
}
