package edu.nju.umr.logicService.orderNewLogic;

import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.order.ExpressVO;

public interface ExpressOrderLSer {
	public Result create(ExpressVO order,String org);
	public String getPriceAndTime(String city1,String city2,int expressKind,int pakKind);//expressKind"经济快递", "标准快递", "特快专递"  pakKind"纸箱", "木箱", "快递袋"
}
