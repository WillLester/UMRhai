package edu.nju.umr.logicService.utilityLogicSer;

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
	 * @return ArrayList<OrgVO>
	 * @see edu.nju.umr.vo.OrgVO
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
}
