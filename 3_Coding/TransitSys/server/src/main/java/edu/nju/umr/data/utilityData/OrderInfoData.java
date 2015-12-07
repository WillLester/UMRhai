package edu.nju.umr.data.utilityData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.nju.umr.data.databaseUtility.MysqlImpl;
import edu.nju.umr.data.databaseUtility.MysqlService;
import edu.nju.umr.po.order.CenterLoadingPO;
import edu.nju.umr.po.order.ExpressPO;
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
	
	public static boolean isTransitValid(String id){
		ResultSet result = mysqlSer.checkInfo(new TransitPO(id, null, null, null, null, null, null, null, null, null, 0, null));
		try {
			if(result.next()){
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}
	
	public static boolean isExpressValid(String id){
		ResultSet result = mysqlSer.checkInfo(new ExpressPO(null, null, null, null, null, null, null, null, null, null, 0, null, 0, 0, 0, 0, 0, id, null, null, null, 0, null, null, null, null, null, null, null, null));
		try {
			if(result.next()){
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}
	
	public static boolean isCenterLoadValid(String id){
		ResultSet result = mysqlSer.checkInfo(new CenterLoadingPO(null, id, null, null, null, null, null, null, null, 0, null));
		try {
			if(result.next()){
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			return false;
		}
	}
}
