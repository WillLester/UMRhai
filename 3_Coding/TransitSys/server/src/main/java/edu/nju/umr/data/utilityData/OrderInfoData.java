package edu.nju.umr.data.utilityData;

import java.sql.ResultSet;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.po.order.TransitPO;
/**
 * 用于获得各种单据的信息
 * @author Lester
 *
 */
public class OrderInfoData {
	private static MysqlService mysqlSer = MysqlImpl.getMysql();
	/**
	 * 获得中转单中的订单号列表
	 * @param id 中转单编号
	 * @return 中转单中含有的订单号组成的ArrayList
	 */
	public static ArrayList<String> getExpressList(String id){
		ResultSet result = mysqlSer.checkInfo(new TransitPO(id, null, null, null, null, null, null, null, null, null, 0, null));
		TransitPO transit = OrderPOFactory.getTransit(result);
		return transit.getExpress();
	}
}
