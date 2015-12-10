package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Express;
import edu.nju.umr.po.enums.Parse;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.order.ExpressVO;

public interface ExpressOrderLSer {
	public Result create(ExpressVO order);
	public String getPrice(String city1,String city2,Express expressKind,Parse pakKind,double weight);
	public int getTime(String city1,String city2);
}
