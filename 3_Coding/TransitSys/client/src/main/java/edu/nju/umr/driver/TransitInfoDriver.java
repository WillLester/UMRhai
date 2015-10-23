package edu.nju.umr.driver;

import edu.nju.umr.logic.transitInfoLogic.CourierLogic;
import edu.nju.umr.logic.transitInfoLogic.CustomerLogic;
import edu.nju.umr.logicService.transitInfoLogicSer.CourierLSer;
import edu.nju.umr.logicService.transitInfoLogicSer.CustomerLogicSer;

public class TransitInfoDriver {
	CourierLSer courier = new CourierLogic();
	CustomerLogicSer customer = new CustomerLogic();
}
