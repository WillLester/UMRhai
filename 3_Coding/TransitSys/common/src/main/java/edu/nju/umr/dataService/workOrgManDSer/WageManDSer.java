package edu.nju.umr.dataService.workOrgManDSer;

import java.rmi.Remote;
import java.util.List;

import edu.nju.umr.po.WorkPO;
import edu.nju.umr.po.enums.Result;

public interface WageManDSer extends Remote{
	public List<WorkPO> searchWork(String keyword);
	public Result updateWork(WorkPO work);
}
