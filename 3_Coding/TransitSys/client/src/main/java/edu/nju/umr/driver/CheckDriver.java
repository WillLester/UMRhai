package edu.nju.umr.driver;

import edu.nju.umr.logic.checkLogic.CollectFormLogic;
import edu.nju.umr.logic.checkLogic.DiaryLogic;
import edu.nju.umr.logic.checkLogic.StatementSheetLogic;
import edu.nju.umr.logicService.checkLogicSer.CollectFormLSer;
import edu.nju.umr.logicService.checkLogicSer.DiaryLSer;
import edu.nju.umr.logicService.checkLogicSer.StatementSheetLSer;

public class CheckDriver {
	CollectFormLSer collect = new CollectFormLogic();
	DiaryLSer diary = new DiaryLogic();
	StatementSheetLSer statement = new StatementSheetLogic();
}
