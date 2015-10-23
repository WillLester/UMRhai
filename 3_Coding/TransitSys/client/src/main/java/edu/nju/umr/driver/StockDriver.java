package edu.nju.umr.driver;

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

public class StockDriver {
	StockCheckLSer check = new StockCheckLogic();
	StockCheckNowLSer checkNow = new StockCheckNowLogic();
	StockCheckWarnLSer checkWarn = new StockCheckWarnLogic();
	StockDivideLSer divide = new StockDivideLogic();
	StockWarningLSer warning = new StockWarningLogic();
}
