package edu.nju.umr.logicService.utilityLogicSer;

import java.util.ArrayList;
import java.util.List;

import edu.nju.umr.po.AccountPO;
import edu.nju.umr.po.OrgPO;
import edu.nju.umr.po.StockPO;
import edu.nju.umr.po.VanPO;
import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;
import edu.nju.umr.vo.CityVO;
import edu.nju.umr.vo.OrgVO;
import edu.nju.umr.vo.ResultMessage;

public interface UtilityLSer {
	/**
	 * 获得List<CityVO>形式的城市信息列表
	 * @see CityVO
	 * @return List<CityVO>
	 */
	public ResultMessage getCities();
	
	/**
	 * 获得机构名称的String数组
	 * @return String[] 包含机构名称
	 */
	public ResultMessage getOrgNames();
	
	/**
	 * 获得中转中心VO列表
	 * @return List<OrgVO> 中转中心信息列表
	 * @see OrgVO
	 */
	public ResultMessage getCenter();
	
	/**
	 * 获得本地营业厅和所有中转中心
	 * @param orgId 机构编号
	 * @return String[]
	 */
	public ResultMessage getLocalHallAndAllCenter(String id);
	
	/**
	 * 获得营业厅
	 * @return List<OrgVO> 营业厅信息列表
	 * @see OrgVO
	 */
	public ResultMessage getHall();
	
	/**
	 * 获得车辆名称列表
	 * @param orgId 营业厅编号
	 * @return String[] 含有车辆名称列表
	 */
	public ResultMessage getVanNames(String orgId);
	
	/**
	 * 获得机构PO
	 * @return List<OrgPO>形式的机构信息列表
	 * @see OrgPO
	 */
	public List<OrgPO> orgs();
	
	/**
	 * 获得快递员列表
	 * @param hallId 营业厅编号
	 * @return List<String>形式的快递员列表
	 */
	public List<String> getCouriers(String hallId);
	
	/**
	 * 获得账户列表
	 * @return String[]形式的账户列表
	 */
	public ResultMessage getAccountNames();
	
	/**
	 * 获得中转中心名称列表
	 * @return String[]形式的账户列表
	 */
	public ResultMessage getCenterNames();
	
	/**
	 * 获得营业厅名称列表
	 * @return String[]形式的账户列表
	 */
	public ResultMessage getHallNames();
	/**
	 * 获得仓库名称列表
	 * @return String[]形式的仓库列表
	 */
	public ResultMessage getStocks();

	public ResultMessage getOrgs();

	/**
	 * 获得人员信息列表
	 * @param orgId 机构编号，为null时返回全部人员
	 * @return WorkPO的ArrayList表示的人员列表
	 */
	public ArrayList<WorkPO> works(String orgId);

	public ArrayList<AccountPO> accounts();

	public ArrayList<StockPO> stocks();

	public ArrayList<VanPO> vans(String orgId);

	/**
	 * 导出Excel表格
	 * @param data 二维字符串数组表示的数据
	 * @param name 表格名
	 * @param location 表格地址
	 * @return 导出结果
	 */
	public Result outputExcel(String[][] data, String name, String location);
	
}
