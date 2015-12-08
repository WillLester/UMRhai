package edu.nju.umr.dataService.utilityDSer;

import java.rmi.Remote;
import java.rmi.RemoteException;

import edu.nju.umr.po.DiaryPO;
import edu.nju.umr.po.enums.Result;
/**
 * 更新日志的数据层接口
 * @author Lester
 *
 */
public interface DiaryUpdateDSer extends Remote {
	/**
	 * 添加新日志记录
	 * @param diary DiaryPO
	 * @see edu.nju.umr.po.DiaryPO
	 * @return 添加结果
	 */
	public Result addDiary(DiaryPO diary) throws RemoteException;
}
