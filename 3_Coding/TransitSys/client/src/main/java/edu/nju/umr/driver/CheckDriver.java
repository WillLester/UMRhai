package edu.nju.umr.driver;

import java.util.ArrayList;

import edu.nju.umr.logic.checkLogic.CollectFormLogic;
import edu.nju.umr.logic.checkLogic.DiaryLogic;
import edu.nju.umr.logic.checkLogic.StatementSheetLogic;
import edu.nju.umr.logicService.checkLogicSer.CollectFormLSer;
import edu.nju.umr.logicService.checkLogicSer.DiaryLSer;
import edu.nju.umr.logicService.checkLogicSer.StatementSheetLSer;
import edu.nju.umr.vo.DiaryVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.order.IncomeVO;

public class CheckDriver {
	CollectFormLSer collect = new CollectFormLogic();
	DiaryLSer diary = new DiaryLogic();
	StatementSheetLSer statement = new StatementSheetLogic();
	public static void main(String[] args) {
		CheckDriver driver = new CheckDriver();
		driver.driveCollect();
		driver.driveDiary();
		driver.driveStatement();
	}
	private void driveCollect(){
		ArrayList<IncomeVO> incomes = (ArrayList<IncomeVO>) collect.seeCollectRecord(null, null).getMessage();
		for(IncomeVO income:incomes){
			System.out.println(income.getId() + " " + income.getCost() + " " + income.getCourier() + " " + income.getDate());
			for(String ex:income.getExpress()){
				System.out.println(ex);
			}
		}
		IncomeVO income = new IncomeVO(null, "宝华", 20, null, "00001");
		ArrayList<IncomeVO> incomeList = new ArrayList<IncomeVO>();
		incomeList.add(income);
		System.out.println((Double)collect.total(incomeList).getMessage());
	}
	private void driveDiary(){
		ArrayList<DiaryVO> diaries = (ArrayList<DiaryVO>) diary.seeDiary(null, null).getMessage();
		for(DiaryVO vo:diaries){
			System.out.println(vo.getOperation() + " " + vo.getTime());
		}
	}
	private void driveStatement(){
		ArrayList<IncomeVO> incomes = (ArrayList<IncomeVO>) statement.seeStatementSheet(null, null, "00001").getMessage();
		for(IncomeVO income:incomes){
			System.out.println(income.getId() + " " + income.getCost() + " " + income.getCourier() + " " + income.getDate());
			for(String ex:income.getExpress()){
				System.out.println(ex);
			}
		}
		for(OrgVO org:(ArrayList<OrgVO>)statement.getHall().getMessage()){
			System.out.println(org.getName() + " " + org.getLocation() + " " + org.getCity().getName() + " " + org.getCity().getId() + " "+ org.getKind());
		}
		System.out.println(statement.outputExcel(null, "D:\\"));
	}
}
