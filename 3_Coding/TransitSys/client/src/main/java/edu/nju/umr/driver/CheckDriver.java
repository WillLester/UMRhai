package edu.nju.umr.driver;

import java.util.ArrayList;

import edu.nju.umr.logic.checkLogic.IncomeListLogic;
import edu.nju.umr.logic.checkLogic.DiaryLogic;
import edu.nju.umr.logic.checkLogic.BusiCircumLogic;
import edu.nju.umr.logicService.checkLogicSer.IncomeListLSer;
import edu.nju.umr.logicService.checkLogicSer.DiaryLSer;
import edu.nju.umr.logicService.checkLogicSer.BusiCircumLSer;
import edu.nju.umr.vo.DiaryVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.order.IncomeVO;

public class CheckDriver {
	IncomeListLSer collect = new IncomeListLogic();
	DiaryLSer diary = new DiaryLogic();
	BusiCircumLSer statement = new BusiCircumLogic();
	public static void main(String[] args) {
		CheckDriver driver = new CheckDriver();
		driver.driveCollect();
		driver.driveDiary();
		driver.driveStatement();
	}
	private void driveCollect(){
		@SuppressWarnings("unchecked")
		ArrayList<IncomeVO> incomes = (ArrayList<IncomeVO>) collect.seeIncomeList(null, null).getMessage();
		for(IncomeVO income:incomes){
			System.out.println( income.getCost() + " " + income.getCourier() + " " + income.getDate());
			for(String ex:income.getExpress()){
				System.out.println(ex);
			}
		}
		IncomeVO income = new IncomeVO(null, "宝华", 20, null);
		ArrayList<IncomeVO> incomeList = new ArrayList<IncomeVO>();
		incomeList.add(income);
		System.out.println((Double)collect.total(incomeList).getMessage());
	}
	private void driveDiary(){
		@SuppressWarnings("unchecked")
		ArrayList<DiaryVO> diaries = (ArrayList<DiaryVO>) diary.seeDiary(null, null).getMessage();
		for(DiaryVO vo:diaries){
			System.out.println(vo.getOperation() + " " + vo.getTime());
		}
	}
	@SuppressWarnings("unchecked")
	private void driveStatement(){
		ArrayList<IncomeVO> incomes = (ArrayList<IncomeVO>) statement.seeBusinessCircum(null, null).getMessage();
		for(IncomeVO income:incomes){
			System.out.println(income.getCost() + " " + income.getCourier() + " " + income.getDate());
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
