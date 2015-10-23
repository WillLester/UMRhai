package edu.nju.umr.logicService.workOrgManLogicSer;

import edu.nju.umr.vo.ResultMessage;
import edu.nju.umr.vo.VanVO;

public interface VanManLSer {
	public boolean addVan(VanVO Van);
	public boolean deleteVan(String id);
	public boolean reviseVan(VanVO Van);
	public ResultMessage checkVan(String id);
	public ResultMessage VanList();
	public ResultMessage searchVan(String keyword);
}
